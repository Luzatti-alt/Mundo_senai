const botoesFechar = document.querySelectorAll('.close');

botoesFechar.forEach(function(botao) {
    botao.addEventListener('click', function() {
        const divPai = this.parentElement;
        divPai.style.display = 'none';
    });
});