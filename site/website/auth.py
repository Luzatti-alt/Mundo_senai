from flask import Blueprint, render_template, request, redirect, url_for, flash
from flask_login import login_user, login_required, logout_user, current_user
from werkzeug.security import generate_password_hash, check_password_hash
from . import db
from .models import User

auth = Blueprint('auth', __name__)


@auth.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        email = request.form['email']
        senha = request.form['senha']

        user = User.query.filter_by(email=email).first()
        if user and check_password_hash(user.senha, senha):
            flash('Logado com uscesso!', category='success')
            login_user(user, remember=True)
            return redirect(url_for('views.home'))
            
    flash('Email ou senha incorreto, tente novamente!', category='error')
    return render_template('login.html', user=current_user)


@auth.route('/logout')
@login_required
def logout():
    logout_user()
    return redirect(url_for('auth.login'))

@auth.route('/sign-up', methods=['GET', 'POST'])
def sign_up():
    if request.method == 'POST':
        nome = request.form['nome']
        email = request.form['email']
        senha1 = request.form['senha1']
        senha2 = request.form['senha2']

        user = User.query.filter_by(email=email).first()
        if user:
            flash('Email já registrado.', category='error')

        elif len(nome) < 2:
            flash('O nome precisa ter pelo menos 2 caracteres.', category='error')
        elif len(nome) > 30:
            flash('O nome não pode ter mais de 30 caracteres', category='error')

        elif len(email) < 5:
            flash('O email precisa ter pelo menos 5 caracteres.', category='error')
        elif len(email) > 50:
            flash('O email não pode ter mais de 50 caracteres.', category='error')

        elif len(senha1) < 8:
            flash('A senha precisa ter pelo menos 8 caracteres.', category='error')
        elif len(senha2) > 50:
            flash('A senha não pode ter mais de 50 caracteres.', category='error')

        elif senha1 != senha2:
            flash('As senhas não coincidem.', category='error')

        else:
            new_user = User(nome=nome, email=email, senha=generate_password_hash(senha1))
            db.session.add(new_user)
            db.session.commit()
            login_user(new_user, remember=True)
            flash('Conta criada com sucesso!', category='success')
            return redirect(url_for('views.home'))
        
    return render_template('sign-up.html', user=current_user)