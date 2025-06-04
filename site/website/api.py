from flask import Blueprint, request, jsonify
from .models import Usuario, Tarefa, ModeloDeTarefa
# from flask_jwt_extended import jwt_required, create_access_token

api = Blueprint('api', __name__)

# @api.route('/login', methods=['POST'])
# def login():
#     data = request.get_json()

#     if not data:
#         return jsonify({'msg': 'JSON inválido ou ausente'}), 400

#     username = data.get('username')
#     password = data.get('password')

#     if username == 'admin' and password == 'admin':
#         token = create_access_token(identity=username)
#         return jsonify(acess_token=token)

#     return jsonify({'msg': 'Credenciais inválidas'}), 401

@api.route('/modelos', methods=['GET'])
# @jwt_required()
def get_modelos():
    modelos = ModeloDeTarefa.query.all()
    resultado = []

    for modelo in modelos:
        data = {
            'id': modelo.id,
            'titulo': modelo.titulo,
            'descricao': modelo.descricao,
            'pontos': modelo.pontos,
        }
        resultado.append(data)
    
    return jsonify(resultado)

@api.route('/tarefas', methods=['GET'])
# @jwt_required()
def get_tarefas():
    tarefas = Tarefa.query.all()
    resultado = []

    for tarefa in tarefas:
        data = {
            'id': tarefa.id,
            'usuario_id': tarefa.usuario_id,
            'modelo_id': tarefa.modelo_id,
            'data_criacao': tarefa.data_criacao.isoformat(),
            'data_expiracao': tarefa.data_expiracao.isoformat(),
            'status': tarefa.status,
            'usuario': {
                'id': tarefa.usuario.id,
                'nome': tarefa.usuario.nome,
            },
            'modelo': {
                'id': tarefa.modelo.id,
                'titulo': tarefa.modelo.titulo,
            },
        }
        resultado.append(data)
    
    return jsonify(resultado)

@api.route('/usuarios', methods=['GET'])
# @jwt_required()
def get_usuarios():
    usuarios = Usuario.query.all()
    resultado = []

    for usuario in usuarios:
        data = {
            'id': usuario.id,
            'nome': usuario.nome,
            'email': usuario.email,
            'admin': usuario.admin,
            'pontos': usuario.pontos,
            'tarefas': [],
        }

        for tarefa in usuario.tarefas:
            data['tarefas'].append({
                'id': tarefa.id,
                'modelo_id': tarefa.modelo_id,
                'data_expiracao': tarefa.data_expiracao,
                'status': tarefa.status,
            })
        
        resultado.append(data)
    
    return jsonify(resultado)