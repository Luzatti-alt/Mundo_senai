from website import create_app

# cria o app
app = create_app()

if __name__ == '__main__':
    app.run(debug=True)
