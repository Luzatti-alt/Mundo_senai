from flask import Blueprint, render_template, request, redirect, url_for

auth = Blueprint('auth', __name__)

usuarios = {}

# rota de formulario de login
@auth.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        usuario = request.form['usuario']
        senha = request.form['senha']
        if usuario in usuarios and usuarios[usuario] == senha:
            return render_template('dashboard.html', nome=usuario)
        else:
            return 'Usuário ou senha incorretos'
    return render_template('login.html')

@auth.route('/signup', methods=['GET', 'POST'])
def sign_up():
    if request.method == 'POST':
        usuario = request.form['usuario']
        senha = request.form['senha']
        if usuario in usuarios:
            return 'Usuário já existe'
        usuarios[usuario] = senha
        return redirect(url_for('auth.login'))
    return render_template('sign_up.html')