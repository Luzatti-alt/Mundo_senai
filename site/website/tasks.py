import random
from . import db
from .models import Usuario, Tarefa, ModeloDeTarefa

# deve ser menor do que o número total de modelos diferentes
WEEKLY_TASKS = 10

def gerar_tarefas(usuario):
    Tarefa.query.filter_by(usuario_id=usuario.id).delete()
    
    modelos = list(ModeloDeTarefa.query.all())
    if len(modelos) < WEEKLY_TASKS:
        raise ValueError('Não há modelos de tarefa suficientes para gerar tarefas únicas.')
    
    modelos_escolhidos = random.sample(modelos, WEEKLY_TASKS)

    for modelo in modelos_escolhidos:
        tarefa = Tarefa(usuario_id=usuario.id, modelo_id=modelo.id)
        db.session.add(tarefa)

def atualizar_usuarios(app):
    with app.app_context():
        for usuario in Usuario.query.all():
            gerar_tarefas(usuario)
        db.session.commit()