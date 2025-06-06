import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Login extends JFrame implements ActionListener, ComponentListener{
    JPanel box_login = new JPanel();
    boolean encontrado = false;
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
    public void requests() throws Exception {
        //IP
    URL url_login = new URL("http://192.168.100.34:5000/api/usuarios");
    HttpURLConnection conectar = (HttpURLConnection) url_login.openConnection();
    conectar.setRequestMethod("GET");
    conectar.setConnectTimeout(2000);
    conectar.setReadTimeout(2000);
    int resposta = conectar.getResponseCode();
    System.out.println("resp: " + resposta);
    if (resposta == 200) {
        BufferedReader ler = new BufferedReader(new InputStreamReader(conectar.getInputStream()));
        StringBuilder Json = new StringBuilder();
        String linha;
        while ((linha = ler.readLine()) != null) {
            Json.append(linha).append("\n");
        }
        ler.close();
        // Salva o conteúdo no arquivo
        try (
            FileWriter client_txt = new FileWriter("teste.txt", false)) {
            client_txt.write(Json.toString());
        }
    }
}
    public void reset(){
    try {
        FileWriter client_txt = new FileWriter("teste.txt", false);
        client_txt.write("");
        client_txt.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    public Login(){
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
        usuario_login.setFont(new Font("Arial",Font.PLAIN,30));
        senha_login.setBounds(10, 150, 480, 40); 
        senha_login.setFont(new Font("Arial",Font.PLAIN,30)); 
        criar_conta.setBounds((largura_atual/2)-150, 425, 300, 50);
        Logar.setBounds((largura_atual/2)-150, 350, 300, 50);  
        esqueceu_senha.setBounds(0, 600,largura_atual,50);
        Login.this.repaint();
        Login.this.revalidate();
    }
    });
        voltar_login.setBackground(new Color(122,159,125));
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
        criar_nova_conta_botao.setBackground(new Color(122,159,125));
        this.add(voltar_login);
        this.add(conta_criando);
        conta_criando.setBackground(Color.white);
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Login.this.getWidth();
        int altura_atual = Login.this.getHeight();
        criar_nova_conta_botao.setBounds(0,altura_atual-200,largura_atual,50);
        conta_criando.setBounds((largura_atual/2)-(largura_atual/5)-50,100, (largura_atual/2), altura_atual/2);
        voltar_login.setBounds((largura_atual/2)-(largura_atual/5),0,largura_atual/3,100);
    }
    });
    criar_nova_conta_botao.addActionListener(this);
    conta_criando.setLayout(new GridLayout(8,1));//nome email senha confirma_senha
    conta_criando.add(nome_conta);
    nome_conta.setEditable(false);
    conta_criando.add(entrar_nome);
    entrar_nome.setFont(new Font("Arial", Font.PLAIN, 30));
    nome_conta.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(email);
    email.setEditable(false);
    email.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_email);
    entrar_email.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(senha_criar);
    senha_criar.setEditable(false);
    senha_criar.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_senha_criando);
    entrar_senha_criando.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(confirmar_senha);
    confirmar_senha.setEditable(false);
    confirmar_senha.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_confirma_senha);
    entrar_confirma_senha.setFont(new Font("Arial", Font.PLAIN, 30));
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == criar_conta) {
            this.getContentPane().removeAll();
            int largura_atual = this.getWidth();  
            int altura_atual = this.getHeight();
            criar_nova_conta_botao.setBounds(0,altura_atual-200,largura_atual,50);
            voltar_login.setBounds((largura_atual/2)-(largura_atual/5),0,largura_atual/3,100);
            conta_criando.setBounds((largura_atual/2)-(largura_atual/5)-50,100, (largura_atual/2), altura_atual/2);
            Criar_nova_conta();
            this.repaint();
            this.revalidate();
        }else if (e.getSource() == Logar) {
        String val_user = usuario_login.getText();
        //senha_login.getText();
        boolean encontrado = false;
        //em login_salvo.txt add data de criação e tipo de assinatura conta fazer o skip do login
        try {
    requests();
    String jsonStr = new String(Files.readAllBytes(Paths.get("teste.txt")));
    // Criar padrões simples para procurar email ou nome
    String emailPattern = "\"email\"\\s*:\\s*\"" + val_user + "\"";
    String nomePattern = "\"nome\"\\s*:\\s*\"" + val_user + "\"";
    if (jsonStr.matches("(?s).*" + emailPattern + ".*") || jsonStr.matches("(?s).*" + nomePattern + ".*")) {
        encontrado = true;
    }
} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Erro ao conectar: " + ex.getMessage());
}
if (encontrado) {
    try {
        FileWriter dados = new FileWriter("nome.txt", false);
        dados.write(val_user + "\n");//mesma coida + 
        dados.close();
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + ex.getMessage());
    }
    this.getContentPane().removeAll();
    new Configuracoes();
    this.dispose();
    reset();
}else {
    JOptionPane.showMessageDialog(this, "Usuário inválido!");
}
    }else if (e.getSource() == esqueceu_senha) {
        JOptionPane.showMessageDialog(this,"Esqueceu a senha");//ver se vamos criar automação de email no futuro
    }else if (e.getSource()==voltar_login){
        this.getContentPane().removeAll();
        new Login();      
        this.repaint();
        this.revalidate();  
    }else if(e.getSource()==criar_nova_conta_botao){
        if(!entrar_nome.getText().isEmpty() && !entrar_email.getText().isEmpty() && entrar_email.getText().contains("@") && entrar_email.getText().contains(".") && !entrar_senha_criando.getText().isEmpty() && entrar_confirma_senha.getText().equals(entrar_senha_criando.getText()) && entrar_senha_criando.getText().length() > 7 && entrar_senha_criando.getText().length() < 33){       
            try {
            String new_acc = entrar_nome.getText();
            FileWriter dados = new FileWriter("nome.txt", false);
            dados.write(new_acc + "\n");
            dados.close();
            //IP
            URL url_login = new URL("http://192.168.100.34:5000/api/usuarios");
            HttpURLConnection conectar = (HttpURLConnection) url_login.openConnection();
            conectar.setConnectTimeout(2000);
            conectar.setReadTimeout(2000);
            conectar.setRequestMethod("POST");
            conectar.setDoOutput(true);
            conectar.setRequestProperty("Content-Type", "application/json");
            String jsonInputString = "{"
            + "\"email\":\"" + entrar_email.getText() + "\","
            + "\"nome\":\"" + entrar_nome.getText() + "\","
            + "\"senha\":\"" + entrar_senha_criando.getText() + "\""
            + "}";
    try (OutputStream os = conectar.getOutputStream()) {
        byte[] input = jsonInputString.getBytes("utf-8");
        os.write(input, 0, input.length);
    }
    int responseCode = conectar.getResponseCode();
System.out.println("POST response code: " + responseCode);
BufferedReader br = new BufferedReader(new InputStreamReader(conectar.getInputStream(), "utf-8"));
StringBuilder response = new StringBuilder();
String responseLine;
while ((responseLine = br.readLine()) != null) {
    response.append(responseLine.trim());
}
    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + ex.getMessage());
    }
            new Configuracoes();
            this.dispose();
            this.revalidate();
            this.repaint();
            reset();
}else{
            JOptionPane.showMessageDialog(this,"algo é invalido");
        }
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
    }
}
