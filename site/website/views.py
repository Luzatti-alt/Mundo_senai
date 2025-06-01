from flask import Blueprint, render_template, redirect, url_for
from flask_login import login_required, current_user
from . import db
from .models import Tarefa
from .news import fetch_news

views = Blueprint('views', __name__)


@views.route('/')
@login_required
def home():
    noticias = fetch_news()
    return render_template('home.html', usuario=current_user, noticias=noticias)

@views.route('/tasks')
@login_required
def tarefas():
    pendentes = Tarefa.query.filter_by(usuario_id=current_user.id, status='pendente').all()
    concluidas = Tarefa.query.filter_by(usuario_id=current_user.id, status='concluida').all()
    return render_template('tasks.html', usuario=current_user, pendentes=pendentes, concluidas=concluidas)

@views.route('/tasks/<int:tarefa_id>/')
@login_required
def concluir_tarefa(tarefa_id):
    tarefa = Tarefa.query.get(tarefa_id)
    
    if tarefa.status != 'concluida':
        tarefa.status = 'concluida'
        tarefa.usuario.pontos += tarefa.modelo.pontos
        db.session.commit()
    
    return redirect(url_for('views.tarefas'))