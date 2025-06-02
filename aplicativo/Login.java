//min pra rodar
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class Login extends JFrame implements ActionListener, ComponentListener{
    JPanel box_login = new JPanel();
    int largura_atual = this.getWidth();  
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
    public void requests() throws Exception{
        File client = new File("teste.txt");
        String linhas;
        if (client.exists()) {
            System.out.println("teste");
        }
        //tenta se conectar com a api 
        URL url_login = new URL("http://192.168.100.34:5000/api/usuarios");
        HttpURLConnection conectar = (HttpURLConnection) url_login.openConnection();
        //ver se está conectado
        conectar.setRequestMethod("GET");
        int resposta = conectar.getResponseCode();
        System.out.println("resp: "+resposta);
        //configurações da conecção
        conectar.setConnectTimeout(1000); // 1 secs
        conectar.setReadTimeout(1000); 
        if(client.exists()){
            BufferedReader ler = new BufferedReader(new InputStreamReader(conectar.getInputStream()));
            try {
                FileWriter client_txt = new FileWriter("teste.txt", true);
            while ((linhas = ler.readLine()) != null) {
            client_txt.write(linhas + "\n");
            System.out.println(linhas);
        }
        client_txt.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(ler);
        }
    }
    public void login(){
        this.setTitle("Projeto Mundo Senai: Treina Aí");
        this.setMinimumSize(new Dimension(600, 300));
        this.setSize(new Dimension(700, 700));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); 
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Login.this.getWidth();
        box_login.setBounds((largura_atual/2)-250, 100, 500, 225);
        usuario_login.setBounds(10, 60, 480, 40);
        senha_login.setBounds(10, 150, 480, 40);  
        criar_conta.setBounds((largura_atual/2)-150, 425, 300, 50);
        Logar.setBounds((largura_atual/2)-150, 350, 300, 50);  
        esqueceu_senha.setBounds(0, 600,largura_atual,50);
        Login.this.repaint();
        Login.this.revalidate();
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
        this.add(box_login);
        this.add(criar_conta);
        criar_conta.setBackground(new Color(122,159,125));
        criar_conta.setFocusable(false);
        criar_conta.setText("Criar conta");
		this.add(esqueceu_senha);
        esqueceu_senha.setBackground(new Color(122,159,125));
		esqueceu_senha.setFocusable(false);
		esqueceu_senha.setText("esqueceu sua senha");
		esqueceu_senha.addActionListener(this);
        Logar.setText("Logar");
        criar_conta.addActionListener(this);
        voltar_login.addActionListener(this);
        Logar.setBackground(new Color(122,159,125));
        Logar.addActionListener(this);
        this.add(Logar);
        this.setVisible(true);
    }
    public void Criar_nova_conta(){
        this.add(criar_nova_conta_botao);
        this.add(voltar_login);
        this.add(conta_criando);
        conta_criando.setBackground(Color.lightGray);
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Login.this.getWidth();
        int altura_atual = Login.this.getHeight();
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
            this.getContentPane().removeAll();
            int largura_atual = this.getWidth();  
            int altura_atual = this.getHeight();
            criar_nova_conta_botao.setBounds(0,altura_atual-200,largura_atual,50);
            voltar_login.setBounds((largura_atual/2)-200,0,largura_atual/3,100);
            conta_criando.setBounds((largura_atual/3)-50, 100, (largura_atual/2), altura_atual/2);
            Criar_nova_conta();
            this.repaint();
            this.revalidate();
        } else if (e.getSource() == Logar) {
        String val_user = usuario_login.getText();
        //senha_login.getText();
        //faz o request
         try {
            requests();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar: " + ex.getMessage());
        }//tenta ver se é compativel
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("teste.txt"));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.equals(val_user)){
                    System.out.println("user valido");
                    this.getContentPane().removeAll();
                    Configuracoes configuracoesPanel = new Configuracoes();
                    this.setContentPane(configuracoesPanel);
                    this.revalidate();
                    this.repaint();
                    break;
                }else {
                    //invalido
                    System.out.println("user invalido");
                    break;
                }
            }
            leitor.close();
            } catch (IOException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "usuario invalido: " + ex.getMessage());
} 
    }else if (e.getSource() == esqueceu_senha) {
        System.out.println("Esqueceu a senha clicado!");
    }else if (e.getSource()==voltar_login){
        this.getContentPane().removeAll();
        login();      
        this.repaint();
        this.revalidate();  
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
public static void main(String[] args) {
        Login login = new Login();
        login.login();
    }
}
