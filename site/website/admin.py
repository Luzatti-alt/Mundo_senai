from flask import Blueprint, render_template, request, redirect, url_for, flash, get_flashed_messages
from . import db, Usuario, ModeloDeTarefa, Tarefa
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
@admin.route('/users/<ind:id>/excluir', methods=['POST'])
def excluir_usuario(id):
    usuario = Usuario.query.get_or_404(id)
    db.session.delete(usuario)
    db.session.commit()
    flash('Usuário excluído.', category='success')
    return redirect(url_for('listar_usuarios'))

@admin_required
@admin.route('/models')
def listar_modelos():
    modelos = ModeloDeTarefa.query.all()
    return render_template('admin/models.html', modelos=modelos)

@admin_required
@admin.route('/models/<ind:id>/excluir', methods=['POST'])
def excluir_modelo(id):
    modelo = ModeloDeTarefa.query.get_or_404(id)
    db.session.delete(modelo)
    db.session.commit()
    flash('Modelo de tarefa excluído.', category='success')
    return redirect(url_for('listar_modelos'))

@admin_required
@admin.route('/tasks')
def listar_tarefas():
    tarefas = Tarefa.query.all()
    return render_template('admin/tasks.html', tarefas=tarefas)

@admin_required
@admin.route('/tasks/<ind:id>/excluir', methods=['POST'])
def excluir_tarefa(id):
    tarefa = Tarefa.query.get_or_404(id)
    db.session.delete(tarefa)
    db.session.commit()
    flash('Tarefa excluída.', category='success')
    return redirect(url_for('listar_tarefas'))
