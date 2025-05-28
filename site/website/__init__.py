import os
from datetime import datetime, timezone
from dotenv import load_dotenv
from flask import Flask
from flask_login import LoginManager
from flask_sqlalchemy import SQLAlchemy
from flask_apscheduler import APScheduler
from .models import Usuario, Tarefa, ModeloDeTarefa

load_dotenv()

db = SQLAlchemy()
DB_NAME = 'database.db'

scheduler = APScheduler()

def create_app():
    app = Flask(__name__)
    app.config['SECRET_KEY'] = os.getenv('SECRET_KEY')

    app.config['SQLALCHEMY_DATABASE_URI'] = f'sqlite:///{DB_NAME}'
    db.init_app(app)

    app.config['SCHEDULER_API_ENABLED'] = True
    scheduler.init_app(app)
    scheduler.start()

    from .views import views
    from .auth import auth
    
    app.register_blueprint(views, url_prefix='/')
    app.register_blueprint(auth, url_prefix='/')

    # from .models import Usuario

    criar_database(app)

    login_manager = LoginManager()
    login_manager.session_protection = 'basic'
    login_manager.login_view = 'auth.login'
    login_manager.login_message = ''
    login_manager.init_app(app)

    @login_manager.user_loader
    def load_user(id):
        return Usuario.query.get(int(id))

    # ADICIONAR FUNCIONALIDADE DAS TAREFAS

    # gerar_tarefas(app)
    # scheduler.add_job(
    #     id='gerar_tarefas',
    #     func=gerar_tarefas,
    #     trigger='cron',
    #     day_of_week='sun',
    #     hour=6,
    #     minute=0
    #     )
    
    return app

def criar_database(app):
    if not os.path.exists(os.path.join(app.instance_path, DB_NAME)):
        with app.app_context():
            db.create_all()
        print('Banco de dados criado!')

def gerar_tarefas(app):
    with app.app_context():
        usuarios = Usuario.query.all()
        modelos = ModeloDeTarefa.query.all()

        for usuario in usuarios:
            for modelo in modelos:
                nova_tarefa = Tarefa(
                    usuario=usuario, 
                    modelo=modelo
                    )
                db.session.add(nova_tarefa)
        db.session.commit()
        print(f'Tarefas criadas em {datetime.now(timezone.utc)}')

# def excluir_tarefa_expiradas():
#     hoje = datetime.now(timezone.utc)
#     Tarefa.query.filter(
#         Tarefa.data_expiracao < hoje,
#         Tarefa.status == 'pendente'
#     ).delete()
#     db.session.commit()
