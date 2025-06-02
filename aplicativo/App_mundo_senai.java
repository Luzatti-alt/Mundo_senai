import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class App_mundo_senai extends JFrame implements ActionListener, AdjustmentListener {
    // adjustamentlistener usado no scroll bar
    JPanel Top_ui = new JPanel();
    // ImageIcon nome = new ImageIcon(path); //imagem tem que estar numa mesma pasta
    // que src/código esta se o codigo esta numa parte e a img tbm vai dar erro
    ImageIcon carrinho_original = new ImageIcon(getClass().getResource("imagens/Carrinho-removebg.png"));
    Image carrinho_img = carrinho_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Carrinho_icon = new ImageIcon(carrinho_img);
    ImageIcon Config_original = new ImageIcon(getClass().getResource("imagens/Configs-removebg.png"));
    Image Config_img = Config_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Config_icon = new ImageIcon(Config_img);
    ImageIcon Metas_original = new ImageIcon(getClass().getResource("imagens/Metas-removebg.png"));
    Image Metas_img = Metas_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Metas_icon = new ImageIcon(Metas_img);
    ImageIcon Parca_original = new ImageIcon(getClass().getResource("imagens/Parceiros-removebg.png"));
    Image Parca_img = Parca_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Parca_icon = new ImageIcon(Parca_img);
    ImageIcon Loja_original = new ImageIcon(getClass().getResource("imagens/logo_loja.png"));
    Image Loja_img = Loja_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Loja_icon = new ImageIcon(Loja_img);
    JFrame janela = new JFrame();
    File info = new File("info.txt");
    JScrollBar scroll_bar = new JScrollBar();// add em loja e carrinho
    int largura_atual = janela.getWidth();
    int altura_atual = this.getHeight();
    JTextArea titulo = new JTextArea();
    JPanel fundo = new JPanel();
    JPanel box_login = new JPanel();
    JButton parceiros = new JButton("Parceiros");
    JButton quests = new JButton("Metas");
    JButton produtos = new JButton("Produtos");
    JButton sobre_nos = new JButton("Sobre nos");
    JButton configs = new JButton("Configurações");
    JButton voltar_login = new JButton("voltar a aba de login");
    JButton Logar = new JButton();
    JButton esqueceu_senha = new JButton();
    JButton criar_conta = new JButton();
    JButton Carrinho_bot = new JButton("carrinho");
    JButton dinheiro = new JButton("Comprar");
    JButton volte = new JButton("voltar");
    // componentes abaixo podem ser alterados ou substituidos //menos os JButtons
    // por conta de como funcionam
    JTextField usuario_login = new JTextField();
    JTextField senha_login = new JTextField();
    JTextArea usuario_text = new JTextArea("Usuario");
    JTextArea senha_text = new JTextArea("Senha");
    // parceiros
    JPanel parça = new JPanel();
    JPanel academia_1 = new JPanel();
    JTextArea nome_e_dist_aca_1 = new JTextArea("academia 1");
    JTextArea endereco_aca_1 = new JTextArea("endereço rua 1 , num");
    JPanel academia_2 = new JPanel();
    JTextArea nome_e_dist_aca_2 = new JTextArea("academia 2");
    JTextArea endereco_aca_2 = new JTextArea("endereço rua 2 , num");
    JPanel academia_3 = new JPanel();
    JTextArea nome_e_dist_aca_3 = new JTextArea("academia 3");
    JTextArea endereco_aca_3 = new JTextArea("endereço rua 3 , num");
    JPanel academia_4 = new JPanel();
    JTextArea nome_e_dist_aca_4 = new JTextArea("academia 4");
    JTextArea endereco_aca_4 = new JTextArea("endereço rua 4 , num");
    JPanel academia_5 = new JPanel();
    JTextArea nome_e_dist_aca_5 = new JTextArea("academia 5");
    JTextArea endereco_aca_5 = new JTextArea("endereço rua 5 , num");
    // loja
    JTextField pesquisa = new JTextField("pesquise aqui o seu produto");
    JTextArea pontuacao = new JTextArea("Pontos");
    // descrição
    JPanel item = new JPanel();
    JPanel desc = new JPanel();
    // carrinho
    JTextArea valor_a_pagar = new JTextArea("Total a pagar: ");
    // temporario
    JButton temp = new JButton();

    public App_mundo_senai() {
        if (info.exists()) {
        } else {
            try {
                FileWriter info = new FileWriter("info.txt");
                info.write("add info de login talvez via pipe");
                info.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String validador_login = "salvo_sim";
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(info));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.equals(validador_login)) {
                    Configuracoes configuracoesPanel = new Configuracoes();
                    this.setContentPane(configuracoesPanel);
                    this.setSize(new Dimension(700, 700));
                    this.setVisible(true);
                    break;
                } else {
                    Login logando = new Login();
                    this.setContentPane(logando);
                    this.setSize(new Dimension(700, 700));
                    this.setVisible(true);
                    break;
                }
            }
            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void limparJanela() {
        this.getContentPane().removeAll();
        this.repaint();
        this.revalidate();
    }

    // funcionamento de scrollbar
    @Override
    public void adjustmentValueChanged(AdjustmentEvent arg0) {
        System.out.println("scrollbar: " + scroll_bar.getValue());
    }
    public static void main(String[] args) {
        new App_mundo_senai();
    }
}
