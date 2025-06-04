from flask import Blueprint, render_template, redirect, url_for

products = Blueprint('products', __name__)

@products.route('/camisa')
def camisa():
    return render_template('produtos/camisa.html')

@products.route('/creatina')
def creatina():
    return render_template('produtos/creatina.html')

@products.route('/whey')
def whey():
    return render_template('produtos/whey.html')

@products.route('/garrafa')
def garrafa():
    return render_template('produtos/garrafa.html')