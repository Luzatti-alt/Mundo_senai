from datetime import datetime, timedelta, timezone
from flask_login import UserMixin
from . import db


class ModeloDeTarefa(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    titulo = db.Column(db.String(50))
    descricao = db.Column(db.Text)
    pontos = db.Column(db.Integer)

class Tarefa(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    usuario_id = db.Column(db.Integer, db.ForeignKey('usuario.id'))
    tarefa_id = db.Column(db.Integer, db.ForeignKey('modelo_de_tarefa.id'))

    data_criacao = db.Column(db.DateTime, default=datetime.now(timezone.utc))
    data_expiracao = db.Column(db.DateTime, default=datetime.now(timezone.utc) + timedelta(days=7))

    status = db.Column(db.String(20), default='pendente')
    
    usuario = db.relationship('Usuario', back_populates='tarefas')
    modelo = db.relationship('ModeloDeTarefa')

class Usuario(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(30))
    email = db.Column(db.String(50), unique=True)
    senha = db.Column(db.String(50))
    pontos = db.Column(db.Integer, default=0)
    admin = db.Column(db.Boolean, default=False)

    tarefas = db.relationship('Tarefa', back_populates='usuario')