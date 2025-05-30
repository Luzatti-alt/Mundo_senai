from flask import Blueprint, render_template, redirect, url_for, flash
from flask_login import current_user
from . import db
from .models import Usuario, ModeloDeTarefa, Tarefa
from .utils import admin_required

admin = Blueprint('admin', __name__)


@admin_required
@admin.route('/')
def home():
    return render_template('admin/home.html')

@admin_required
@admin.route('/users')
def listar_usuarios():
    usuarios = Usuario.query.all()
    return render_template('admin/users.html', usuarios=usuarios)

@admin_required
@admin.route('/users/<int:id>/excluir', methods=['POST'])
def excluir_usuario(id):
    usuario = Usuario.query.get_or_404(id)
    db.session.delete(usuario)
    db.session.commit()
    flash('Usuário excluído.', category='success')
    return redirect(url_for('admin.listar_usuarios'))

@admin_required
@admin.route('/models')
def listar_modelos():
    modelos = ModeloDeTarefa.query.all()
    return render_template('admin/models.html', modelos=modelos)

@admin_required
@admin.route('/models/<int:id>/excluir', methods=['POST'])
def excluir_modelo(id):
    modelo = ModeloDeTarefa.query.get_or_404(id)
    db.session.delete(modelo)
    db.session.commit()
    flash('Modelo de tarefa excluído.', category='success')
    return redirect(url_for('admin.listar_modelos'))

@admin_required
@admin.route('/tasks')
def listar_tarefas():
    tarefas = Tarefa.query.all()
    return render_template('admin/tasks.html', tarefas=tarefas)

@admin_required
@admin.route('/tasks/<int:id>/excluir', methods=['POST'])
def excluir_tarefa(id):
    tarefa = Tarefa.query.get_or_404(id)
    db.session.delete(tarefa)
    db.session.commit()
    flash('Tarefa excluída.', category='success')
    return redirect(url_for('admin.listar_tarefas'))
