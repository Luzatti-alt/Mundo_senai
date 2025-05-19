from flask import Flask, render_template, request

# cria o app
app = Flask(__name__)

# rota basica
@app.route('/')
def home():
    return render_template("template teste.html", nome="Fellipe", teste="seilabro")

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
        return f'Usuário: {usuario}, Senha: {senha}'
    return  '''
            
            '''

if __name__ == '__main__':
    app.run(debug=True)
