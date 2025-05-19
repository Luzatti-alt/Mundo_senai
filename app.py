from flask import Flask, render_template, request, redirect, url_for

# cria o app
app = Flask(__name__)
usuarios = {} # banco de dados simulado

# rota basica
# @app.route('/')
# def home():
#     return render_template("template teste.html", nome="Fellipe", teste="seilabro")

@app.route('/')
def home():
    return redirect(url_for('login'))

# cria uma rota dinâmica
@app.route('/usuario/<nome>')
def usuario(nome):
    return f'Olá, {nome}'

# rota de formulario de login
@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        usuario = request.form['usuario']
        senha = request.form['senha']
        if usuario in usuarios and usuarios[usuario] == senha:
            return render_template('dashboard.html', nome=usuario)
        else:
            return 'Usuário ou senha incorretos'
    return render_template('login.html')

@app.route('/signup', methods=['GET', 'POST'])
def sign_up():
    if request.method == 'POST':
        usuario = request.form['usuario']
        senha = request.form['senha']
        if usuario in usuarios:
            return 'Usuário já existe'
        usuarios[usuario] = senha
        return redirect(url_for('login'))
    return render_template('sign_up.html')

if __name__ == '__main__':
    app.run(debug=True)
