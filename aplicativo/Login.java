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
    @Override
public void actionPerformed(ActionEvent e) {
    // Exemplo: verifique qual botão foi clicado
    if (e.getSource() == criar_conta) {
        System.out.println("Criar conta clicado!");
    } else if (e.getSource() == Logar) {
        System.out.println("Logar clicado!");
    } else if (e.getSource() == esqueceu_senha) {
        System.out.println("Esqueceu a senha clicado!");
    }
}

@Override
public void componentResized(ComponentEvent e) {
    // Se quiser, pode mover a lógica de redimensionamento aqui
}

@Override
public void componentMoved(ComponentEvent e) {}

@Override
public void componentShown(ComponentEvent e) {}

@Override
public void componentHidden(ComponentEvent e) {}
}