import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Login extends JFrame implements ActionListener, ComponentListener{
    JFrame janela = new JFrame();
    JPanel box_login = new JPanel();
    int largura_atual = janela.getWidth();  
    JButton voltar_login = new JButton("voltar a aba de login");
    JTextField usuario_login = new JTextField();
    JTextField senha_login = new JTextField();
    JButton criar_conta = new JButton();
    JButton Logar = new JButton();
    JButton esqueceu_senha = new JButton();
    JTextArea usuario_text = new JTextArea("Usuario");
    JTextArea senha_text = new JTextArea("Senha");
    //criando conta
    JButton criar_nova_conta_botao = new JButton("Criar conta");
    JPanel conta_criando = new JPanel();
    JTextArea nome_conta = new JTextArea("digite seu nome: ");
    JTextField entrar_nome = new JTextField();
    JTextArea email = new JTextArea("digite seu email:");
    JTextField entrar_email = new JTextField();
    JTextArea senha_criar = new JTextArea("digite sua senha:");
    JTextField entrar_senha_criando = new JTextField();
    JTextArea confirmar_senha = new JTextArea("confirme sua senha:");
    JTextField entrar_confirma_senha = new JTextField();
    public void login(){
        janela.setTitle("Projeto Mundo Senai: Treina Aí");
        janela.setMinimumSize(new Dimension(600, 300));
        janela.setSize(new Dimension(700, 700));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null); 
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        box_login.setBounds((largura_atual/2)-250, 100, 500, 225);
        usuario_login.setBounds(10, 60, 480, 40);
        senha_login.setBounds(10, 150, 480, 40);  
        criar_conta.setBounds((largura_atual/2)-150, 425, 300, 50);
        Logar.setBounds((largura_atual/2)-150, 350, 300, 50);  
        esqueceu_senha.setBounds(0, 600,largura_atual,50);
        janela.repaint();
        janela.revalidate();
    }
    });
        voltar_login.setBackground(Color.gray);
        box_login.setLayout(null);
        box_login.setBackground(Color.lightGray);
        usuario_text.setBackground(null);
        usuario_text.setEditable(false);
        usuario_text.setFont(new Font("Arial", Font.PLAIN, 30));
        box_login.add(usuario_text);
        usuario_login.setBorder(BorderFactory.createEmptyBorder());
        usuario_text.setBounds(largura_atual/2, 10, 480, 60);
        usuario_login.setBackground(new Color(200, 255, 206));
        box_login.add(usuario_login);
        senha_text.setBounds(0, 100, 480, 60);
        senha_text.setBackground(null);
        senha_text.setEditable(false);
        senha_text.setFont(new Font("Arial", Font.PLAIN, 30)); 
        box_login.add(senha_text);
        senha_login.setBorder(BorderFactory.createEmptyBorder()); 
        senha_login.setBackground(new Color(200, 255, 206));
        box_login.add(senha_login);
        janela.add(box_login);
        janela.add(criar_conta);
        criar_conta.setBackground(new Color(122,159,125));
        criar_conta.setFocusable(false);
        criar_conta.setText("Criar conta");
		janela.add(esqueceu_senha);
        esqueceu_senha.setBackground(new Color(122,159,125));
		esqueceu_senha.setFocusable(false);
		esqueceu_senha.setText("esqueceu sua senha");
		esqueceu_senha.addActionListener(this);
        Logar.setText("Logar");
        criar_conta.addActionListener(this);
        voltar_login.addActionListener(this);
        Logar.setBackground(new Color(122,159,125));
        Logar.addActionListener(this);
        janela.add(Logar);
        janela.setVisible(true);
    }
    public void Criar_nova_conta(){
        janela.add(criar_nova_conta_botao);
        janela.add(voltar_login);
        janela.add(conta_criando);
        conta_criando.setBackground(Color.lightGray);
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        criar_nova_conta_botao.setBounds(0,altura_atual-200,largura_atual,50);
        conta_criando.setBounds((largura_atual/3)-50, 100, (largura_atual/2), altura_atual/2);
        voltar_login.setBounds((largura_atual/2)-200,0,largura_atual/3,100);
    }
    });
    conta_criando.setLayout(new GridLayout(8,1));//nome email senha confirma_senha
    conta_criando.add(nome_conta);
    nome_conta.setEditable(false);
    conta_criando.add(entrar_nome);
    nome_conta.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(email);
    email.setEditable(false);
    email.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_email);
    conta_criando.add(senha_criar);
    senha_criar.setEditable(false);
    senha_criar.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_senha_criando);
    conta_criando.add(confirmar_senha);
    confirmar_senha.setEditable(false);
    confirmar_senha.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_confirma_senha);
    criar_nova_conta_botao.setBackground(Color.green);
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == criar_conta) {
            janela.getContentPane().removeAll();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            criar_nova_conta_botao.setBounds(0,altura_atual-200,largura_atual,50);
            voltar_login.setBounds((largura_atual/2)-200,0,largura_atual/3,100);
            conta_criando.setBounds((largura_atual/3)-50, 100, (largura_atual/2), altura_atual/2);
            Criar_nova_conta();
            janela.repaint();
            janela.revalidate();
        } else if (e.getSource() == Logar) {
        System.out.println("Logar clicado!");
    } else if (e.getSource() == esqueceu_senha) {
        System.out.println("Esqueceu a senha clicado!");
    }else if (e.getSource()==voltar_login){
        janela.getContentPane().removeAll();
        login();      
        janela.repaint();
        janela.revalidate();  
    }
}

@Override
public void componentResized(ComponentEvent e) {
}
@Override
public void componentMoved(ComponentEvent e) {}
@Override
public void componentShown(ComponentEvent e) {}
@Override
public void componentHidden(ComponentEvent e) {}
public void main(String[] args) {
        new Login();  // Isso funciona se você chamar login() dentro do construtor
    }
}
