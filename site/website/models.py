from . import db
from flask_login import UserMixin


class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(30))
    email = db.Column(db.String(50), unique=True)
    senha = db.Column(db.String(50))