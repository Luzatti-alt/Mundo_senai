from flask import Blueprint, render_template, redirect, url_for, flash, request, abort
from flask_login import current_user
from . import db
from .models import Usuario, ModeloDeTarefa, Tarefa
from .utils import admin_required

admin = Blueprint('admin', __name__)

@admin.route('/')
@admin_required
def home():
    return render_template('admin/home.html')

@admin.route('/users')
@admin_required
def listar_usuarios():
    usuarios = Usuario.query.all()
    return render_template('admin/users.html', usuarios=usuarios)

@admin.route('/users/<int:id>')
@admin_required
def inspecionar_usuario(id):
    usuario = Usuario.query.get(id)
    return render_template('admin/inspect.html', usuario=usuario)

@admin.route('/users/<int:id>/add_task')
@admin_required
def atribuir_tarefa(id):
    modelos = ModeloDeTarefa.query.all()
    return render_template('admin/tasks.html', id=id, modelos=modelos)

@admin.route('/users/<int:usuario_id>/<int:modelo_id>')
@admin_required
def criar_tarefa(usuario_id, modelo_id):
    tarefa = Tarefa(usuario_id=usuario_id, modelo_id=modelo_id)
    db.session.add(tarefa)
    db.session.commit()
    return redirect(url_for('admin.inspecionar_usuario', id=usuario_id))

@admin.route('/users/<int:id>/delete')
@admin_required
def excluir_tarefa(id):
    tarefa = Tarefa.query.get(id)
    usuario = tarefa.usuario
    db.session.delete(tarefa)
    db.session.commit()
    flash('Tarefa excluída.', category='success')
    return redirect(url_for('admin.inspecionar_usuario', id=usuario.id))

@admin.route('/users/<int:id>/delete', methods=['POST'])
@admin_required
def excluir_usuario(id):
    usuario = Usuario.query.get_or_404(id)
    db.session.delete(usuario)
    db.session.commit()
    flash('Usuário excluído.', category='success')
    return redirect(url_for('admin.listar_usuarios'))

@admin.route('/models')
@admin_required
def listar_modelos():
    modelos = ModeloDeTarefa.query.all()
    return render_template('admin/models.html', modelos=modelos)

@admin.route('/models/new', methods=['GET', 'POST'])
@admin_required
def criar_modelo():
    if request.method == 'POST':
        nome = request.form.get('nome')
        desc = request.form.get('desc')
        pontos = int(request.form.get('pontos'))

        modelo = ModeloDeTarefa(titulo=nome, descricao=desc, pontos=pontos)
        db.session.add(modelo)
        db.session.commit()
        flash('Modelo criado com sucesso!', category='success')
        return redirect(url_for('admin.listar_modelos'))
    
    return render_template('admin/new_model.html')

@admin.route('/models/<int:id>/edit', methods=['GET', 'POST'])
@admin_required
def editar_modelo(id):
    modelo = ModeloDeTarefa.query.get_or_404(id)

    if request.method == 'POST':
        modelo.titulo = request.form.get('nome')
        modelo.descricao = request.form.get('desc')
        modelo.pontos = int(request.form.get('pontos'))

        db.session.commit()
        flash('Modelo atualizado com sucesso!', category='success')
        return redirect(url_for('admin.listar_modelos'))
    
    return render_template('admin/edit_model.html', modelo=modelo)

@admin.route('/models/<int:id>/delete', methods=['POST'])
@admin_required
def excluir_modelo(id):
    modelo = ModeloDeTarefa.query.get_or_404(id)
    db.session.delete(modelo)
    db.session.commit()
    flash('Modelo de tarefa excluído.', category='success')
    return redirect(url_for('admin.listar_modelos'))

@admin.route('/seja_admin')
def virar_admin():
    current_user.admin = True
    db.session.commit()
    return redirect(url_for('admin.home'))
