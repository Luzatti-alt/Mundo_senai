import os
from datetime import datetime
from dotenv import load_dotenv
from flask import Flask
from flask_login import LoginManager
from flask_sqlalchemy import SQLAlchemy
# from flask_jwt_extended import JWTManager
from apscheduler.schedulers.background import BackgroundScheduler
from apscheduler.schedulers import SchedulerNotRunningError

load_dotenv()

db = SQLAlchemy()
DB_NAME = 'database.db'

scheduler = BackgroundScheduler()

def create_app():
    app = Flask(__name__)
    app.config['SECRET_KEY'] = os.getenv('SECRET_KEY')

    # app.config['JWT_SECRET_KEY'] = os.getenv('JWT_SECRET_KEY')
    # app.config['JWT_ACCESS_TOKEN_EXPIRES'] = False
    # jwt = JWTManager(app)

    app.config['SQLALCHEMY_DATABASE_URI'] = f'sqlite:///{DB_NAME}'
    db.init_app(app)

    from .views import views
    from .auth import auth
    from .products import products
    from .admin import admin
    from .api import api
    
    app.register_blueprint(views, url_prefix='/')
    app.register_blueprint(auth, url_prefix='/')
    app.register_blueprint(products, url_prefix='/products')
    app.register_blueprint(admin, url_prefix='/admin')
    app.register_blueprint(api, url_prefix='/api')

    from .models import Usuario

    criar_database(app)
    iniciar_scheduler(app)

    login_manager = LoginManager()
    login_manager.session_protection = 'basic'
    login_manager.login_view = 'auth.login'
    login_manager.login_message = ''
    login_manager.init_app(app)

    @login_manager.user_loader
    def load_user(id):
        return Usuario.query.get(int(id))
    
    return app

def criar_database(app):
    if not os.path.exists(os.path.join(app.instance_path, DB_NAME)):
        with app.app_context():
            db.create_all()
        print('Banco de dados criado!')

def iniciar_scheduler(app):
    with app.app_context():
        if not scheduler.running:
            from .tasks import atualizar_usuarios
            scheduler.add_job(func=lambda: atualizar_usuarios(app), trigger='interval', weeks=1, next_run_time=datetime.now())
            scheduler.start()

        @app.teardown_appcontext
        def shutdown_session(exception=None):
            try:
                if scheduler.running:
                    scheduler.shutdown(wait=False)
            except SchedulerNotRunningError:
                pass
