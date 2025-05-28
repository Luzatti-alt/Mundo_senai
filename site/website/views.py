from flask import Blueprint, render_template
from flask_login import login_required, current_user
from .news import fetch_news

views = Blueprint('views', __name__)


@views.route('/')
@login_required
def home():
    noticias = fetch_news()
    
    return render_template(
        'home.html',
        nome=current_user.nome,
        noticias=noticias,
        user=current_user
        )