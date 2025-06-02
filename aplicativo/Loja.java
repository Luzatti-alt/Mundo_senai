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

    public void parceiro_page() {
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura_atual = janela.getWidth();
                int altura_atual = janela.getHeight();
                produtos.setBounds((largura_atual / 2) - 100, 0, 100, 28);
                quests.setBounds((largura_atual / 2), 0, 100, 28);
                configs.setBounds((largura_atual / 2) + 100, 0, 100, 28);
                titulo.setBounds(0, 26, largura_atual, 35);
                fundo.setBounds(0, 60, largura_atual, altura_atual - 63);
                titulo.setBounds(0, 26, largura_atual, 35);
                parça.setBounds(0, 61, largura_atual, 1000);
            }
        });
        titulo.setText("Instituições parceiras");
        this.add(produtos);
        this.add(quests);
        this.add(configs);
        this.add(titulo);
        this.add(parça);
        produtos.setIcon(Loja_icon);
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        parça.setBounds(0, 61, largura_atual, 1000);
        parça.setBackground(Color.lightGray);
        this.add(titulo);
        titulo.setBackground(new Color(61, 153, 32));
        titulo.setEditable(false);
        titulo.setFont(new Font("arial", Font.PLAIN, 30));
        parça.setLayout(new GridLayout(5, 1));
        // 1 academia
        parça.add(academia_1);
        academia_1.setLayout(new GridLayout(2, 1));
        academia_1.add(nome_e_dist_aca_1);
        nome_e_dist_aca_1.setEditable(false);
        nome_e_dist_aca_1.setFont(new Font("arial", Font.PLAIN, 30));
        academia_1.add(endereco_aca_1);
        endereco_aca_1.setEditable(false);
        endereco_aca_1.setFont(new Font("arial", Font.PLAIN, 30));
        // 2 academia
        parça.add(academia_2);
        academia_2.setLayout(new GridLayout(2, 1));
        academia_2.add(nome_e_dist_aca_2);
        nome_e_dist_aca_2.setEditable(false);
        nome_e_dist_aca_2.setFont(new Font("arial", Font.PLAIN, 30));
        academia_2.add(endereco_aca_2);
        endereco_aca_2.setEditable(false);
        endereco_aca_2.setFont(new Font("arial", Font.PLAIN, 30));
        // 3 academia
        parça.add(academia_3);
        academia_3.setLayout(new GridLayout(2, 1));
        academia_3.add(nome_e_dist_aca_3);
        nome_e_dist_aca_3.setEditable(false);
        nome_e_dist_aca_3.setFont(new Font("arial", Font.PLAIN, 30));
        academia_3.add(endereco_aca_3);
        endereco_aca_3.setEditable(false);
        endereco_aca_3.setFont(new Font("arial", Font.PLAIN, 30));
        // 4 academia
        parça.add(academia_4);
        academia_4.setLayout(new GridLayout(2, 1));
        academia_4.add(nome_e_dist_aca_4);
        nome_e_dist_aca_4.setEditable(false);
        nome_e_dist_aca_4.setFont(new Font("arial", Font.PLAIN, 30));
        academia_4.add(endereco_aca_4);
        endereco_aca_4.setEditable(false);
        endereco_aca_4.setFont(new Font("arial", Font.PLAIN, 30));
        // 5 academia
        parça.add(academia_5);
        academia_5.setLayout(new GridLayout(2, 1));
        academia_5.add(nome_e_dist_aca_5);
        nome_e_dist_aca_5.setEditable(false);
        nome_e_dist_aca_5.setFont(new Font("arial", Font.PLAIN, 30));
        academia_5.add(endereco_aca_5);
        endereco_aca_5.setEditable(false);
        endereco_aca_5.setFont(new Font("arial", Font.PLAIN, 30));
    }

    public void loja() {
        this.add(temp);
        temp.addActionListener(this);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura_atual = janela.getWidth();
                int altura_atual = janela.getHeight();
                scroll_bar.setBounds(0, 105, altura_atual / 15, altura_atual - 90);
                temp.setBounds((largura_atual / 2) + 200, 500, 100, 30);
                produtos.setBounds((largura_atual / 2) - 100, 0, 100, 30);
                parceiros.setBounds((largura_atual / 2) + 300, 0, 100, 30);
                quests.setBounds((largura_atual / 2), 0, 100, 30);
                configs.setBounds((largura_atual / 2) + 100, 0, 100, 30);
                pesquisa.setBounds(0, 90, largura_atual, 30);
                pontuacao.setBounds(largura_atual / 2, 60, largura_atual / 2, 30);
                Carrinho_bot.setBounds(0, 60, largura_atual / 2, 30);
                titulo.setBounds(0, 30, largura_atual, 30);
            }
        });
        this.add(produtos);
        this.add(quests);
        this.add(configs);
        this.add(titulo);
        produtos.setIcon(Loja_icon);
        this.add(Carrinho_bot);
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        Carrinho_bot.setIcon(Carrinho_icon);
        this.add(titulo);
        titulo.setEditable(false);
        titulo.setText("Produtos a venda");
        titulo.setBackground(Color.green);
        Carrinho_bot.addActionListener(this);
        this.add(pesquisa);
        this.add(pontuacao);
        fundo.setBackground(Color.blue);
        this.add(scroll_bar);
        scroll_bar.addAdjustmentListener(this);
        pontuacao.setEditable(false);
    }

    public void carrinho() {
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        produtos.setIcon(Loja_icon);
        Carrinho_bot.setIcon(Carrinho_icon);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura_atual = janela.getWidth();
                int altura_atual = janela.getHeight();
                produtos.setBounds((largura_atual / 2) - 100, 0, 100, 30);
                parceiros.setBounds((largura_atual / 2) - 200, 0, 100, 30);
                quests.setBounds((largura_atual / 2), 0, 100, 30);
                configs.setBounds((largura_atual / 2) + 100, 0, 100, 30);
                titulo.setBounds(0, 30, largura_atual, 30);
                volte.setBounds(0, altura_atual - 100, largura_atual, 60);
                dinheiro.setBounds(0, altura_atual - 175, largura_atual, 60);
                valor_a_pagar.setBounds(0, altura_atual - 250, largura_atual, 60);
                fundo.setBounds(0, altura_atual - 625, largura_atual, (altura_atual / 2) - 50);
                scroll_bar.setBounds(largura_atual - 50, 0, largura_atual / 20, (altura_atual / 2) - 50);
            }
        });
        fundo.add(scroll_bar);
        scroll_bar.addAdjustmentListener(this);
        this.add(produtos);
        this.add(parceiros);
        this.add(quests);
        this.add(configs);
        this.add(titulo);
        this.add(fundo);
        fundo.setBackground(Color.LIGHT_GRAY);
        this.add(valor_a_pagar);
        valor_a_pagar.setBackground(Color.green);
        valor_a_pagar.setFont(new Font("Arial", Font.PLAIN, 56));
        this.add(volte);
        this.add(dinheiro);
        titulo.setBackground(Color.green);
        titulo.setText("carrinho");
    }

    public void descricao() {
        // add funcionalidade para produtos especificos
        this.add(produtos);
        this.add(quests);
        this.add(configs);
        this.add(titulo);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura_atual = janela.getWidth();
                int altura_atual = janela.getHeight();
                produtos.setBounds((largura_atual / 2) - 100, 0, 100, 30);
                parceiros.setBounds((largura_atual / 2) - 200, 0, 100, 30);
                quests.setBounds((largura_atual / 2), 0, 100, 30);
                configs.setBounds((largura_atual / 2) + 100, 0, 100, 30);
                item.setBounds(50, 80, largura_atual / 2 - 50, altura_atual / 2);
                desc.setBounds(largura_atual / 2 + 50, 80, largura_atual / 2 - 100, altura_atual / 2);
                titulo.setBounds(0, 30, largura_atual, 30);
                dinheiro.setBounds(0, altura_atual - 200, largura_atual, 60);
                volte.setBounds(0, altura_atual - 100, largura_atual, 60);
            }
        });
        this.add(item);
        volte.addActionListener(this);
        item.setBackground(Color.lightGray);
        // item.add();//imagem do item
        this.add(desc);
        desc.setBackground(Color.gray);
        // desc.add();//descrição do produto
        this.add(dinheiro);
        this.add(titulo);
        titulo.setBackground(Color.green);
        titulo.setText("Descrição do produto");
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        titulo.setEditable(false);
        this.add(volte);
    }

    // funcionamento de scrollbar
    @Override
    public void adjustmentValueChanged(AdjustmentEvent arg0) {
        System.out.println("scrollbar: " + scroll_bar.getValue());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == esqueceu_senha) {
            //
        } else if (e.getSource() == sobre_nos) {
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            this.setSize(largura_atual + 1, altura_atual);
            quests.setBounds((largura_atual / 2) - 200, 0, 100 + 1, 28);
            produtos.setBounds((largura_atual / 2) - 100, 0, 100 + 1, 28);
            parceiros.setBounds((largura_atual / 2), 0, 100 + 1, 28);
            configs.setBounds((largura_atual / 2) + 100, 0, 100 + 1, 28);
        } else if (e.getSource() == produtos) {
            loja();
            int largura_atual = janela.getWidth();
            produtos.setBounds((largura_atual / 2) - 100, 0, 100 + 1, 28);
            parceiros.setBounds((largura_atual / 2) - 200, 0, 100 + 1, 28);
            quests.setBounds((largura_atual / 2), 0, 100 + 1, 28);
            configs.setBounds((largura_atual / 2) + 100, 0, 100 + 1, 28);
            pesquisa.setBounds(0, 90, (largura_atual) + 1, 30);
            titulo.setBounds(0, 30, largura_atual + 1, 30);
            pontuacao.setBounds(largura_atual / 2, 60, (largura_atual / 2) + 1, 30);
            Carrinho_bot.setBounds(0, 60, (largura_atual / 2) + 1, 30);
            scroll_bar.setBounds(0, 105, altura_atual / 15, altura_atual - 90);
            // temporario
            temp.setBounds((largura_atual / 2) - 100, 500, 100 + 1, 30);
        } else if (e.getSource() == quests) {
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            this.setSize(largura_atual + 1, altura_atual);
            Sistema_metas.setBounds(0, 60, largura_atual + 1, altura_atual - 63);
            produtos.setBounds((largura_atual / 2) - 100, 0, 100 + 1, 28);
            parceiros.setBounds((largura_atual / 2), 0, 100 + 1, 28);
            configs.setBounds((largura_atual / 2) + 100, 0, 100 + 1, 28);
            titulo.setBounds(0, 26, largura_atual + 1, 35);
            fundo.setBounds(0, 60, largura_atual + 1, altura_atual);
        } else if (e.getSource() == parceiros) {
            int largura_atual = janela.getWidth();
            parceiro_page();
            produtos.setBounds((largura_atual / 2) - 100, 0, 100 + 1, 28);
            quests.setBounds((largura_atual / 2), 0, 100 + 1, 28);
            configs.setBounds((largura_atual / 2) + 100, 0, 100 + 1, 28);
            titulo.setBounds(0, 26, largura_atual + 1, 35);
            parça.setBounds(0, 61, largura_atual + 1, 1000);
        }
        if (e.getSource() == configs) {
            limparJanela();
            //
        }
        if (e.getSource() == Carrinho_bot) {
            carrinho();
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            produtos.setBounds((largura_atual / 2) - 100, 0, 100 + 1, 30);
            parceiros.setBounds((largura_atual / 2) - 200, 0, 100 + 1, 30);
            quests.setBounds((largura_atual / 2), 0, 100 + 1, 30);// +1
            configs.setBounds((largura_atual / 2) + 100, 0, 100 + 1, 30);
            titulo.setBounds(0, 31, largura_atual + 1, 30);
            volte.setBounds(0, altura_atual - 100, largura_atual + 1, 60);
            dinheiro.setBounds(0, altura_atual - 175, largura_atual + 1, 60);
            valor_a_pagar.setBounds(0, altura_atual - 250, largura_atual + 1, 60);
            fundo.setBounds(0, altura_atual - 625, largura_atual, (altura_atual / 2) - 50);
            scroll_bar.setBounds(largura_atual - 50, 0, largura_atual / 20, (altura_atual / 2) - 50);
            this.repaint();
            this.revalidate();
        }
        if (e.getSource() == temp) {
            descricao();
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            produtos.setBounds((largura_atual / 2) - 100, 0, 100, 30);
            parceiros.setBounds((largura_atual / 2) - 200, 0, 100, 30);
            quests.setBounds((largura_atual / 2), 0, 100, 30);
            configs.setBounds((largura_atual / 2) + 100, 0, 100, 30);
            item.setBounds(50, 80, largura_atual / 2 - 50, altura_atual / 2);
            desc.setBounds(largura_atual / 2 + 50, 80, largura_atual / 2 - 100, altura_atual / 2);
            titulo.setBounds(0, 30, largura_atual, 30);
            dinheiro.setBounds(0, altura_atual - 200, largura_atual, 60);
            volte.setBounds(0, altura_atual - 100, largura_atual, 60);
            this.repaint();
            this.revalidate();
        } else if (e.getSource() == volte) {
            loja();
        }
    }

    public static void main(String[] args) {
        new App_mundo_senai();
    }
}
