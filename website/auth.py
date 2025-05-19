from flask import Blueprint, render_template, request, redirect, url_for

auth = Blueprint('auth', __name__)

usuarios = {}

# rota de formulario de login
@auth.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        user = request.form['email']
        senha = request.form['senha']
        if user in usuarios and usuarios[user] == senha:
            return render_template('dashboard.html', nome=user)
        else:
            return 'Usuário ou senha incorretos'
    return render_template('login.html')

@auth.route('/signup', methods=['GET', 'POST'])
def sign_up():
    if request.method == 'POST':
        # adicionar usuario depois
        user = request.form['email']
        senha = request.form['senha']
        if user in usuarios:
            return 'Usuário já existe'
        usuarios[user] = senha
        return redirect(url_for('auth.login'))
    return render_template('sign_up.html')