import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Loja extends JFrame implements ActionListener, ComponentListener, AdjustmentListener{
    int largura_atual = this.getWidth();
    int altura_atual = this.getHeight();
    ImageIcon Halter_original = new ImageIcon(getClass().getResource("/imagens/halter.png"));
    Image Halter_img = Halter_original.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
    ImageIcon Halter_icon = new ImageIcon(Halter_img);
    ImageIcon Whey_original = new ImageIcon(getClass().getResource("/imagens/whey.jpg"));
    Image Whey_img = Whey_original.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
    ImageIcon Whey_icon = new ImageIcon(Whey_img);
    ImageIcon bar_prot_original = new ImageIcon(getClass().getResource("/imagens/barra_prot.png"));
    Image bar_prot_img = bar_prot_original.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
    ImageIcon bar_prot_icon = new ImageIcon(bar_prot_img);
    ImageIcon toalha_original = new ImageIcon(getClass().getResource("/imagens/toalha.jpg"));
    Image toalha_img = toalha_original.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
    ImageIcon toalha_icon = new ImageIcon(toalha_img);
    JButton prod_1 = new JButton();
    JButton prod_2 = new JButton();
    JButton prod_3 = new JButton();
    JButton prod_4 = new JButton();
    JButton prod_5 = new JButton();
    ImageIcon carrinho_original = new ImageIcon(getClass().getResource("/imagens/Carrinho-removebg.png"));
    Image carrinho_img = carrinho_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Carrinho_icon = new ImageIcon(carrinho_img);
    ImageIcon Config_original = new ImageIcon(getClass().getResource("/imagens/Configs-removebg.png"));
    Image Config_img = Config_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Config_icon = new ImageIcon(Config_img);
    ImageIcon Metas_original = new ImageIcon(getClass().getResource("/imagens/Metas-removebg.png"));
    Image Metas_img = Metas_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Metas_icon = new ImageIcon(Metas_img);
    ImageIcon Parca_original = new ImageIcon(getClass().getResource("/imagens/Parceiros-removebg.png"));
    Image Parca_img = Parca_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Parca_icon = new ImageIcon(Parca_img);
    ImageIcon Loja_original = new ImageIcon(getClass().getResource("/imagens/logo_loja.png"));
    Image Loja_img = Loja_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Loja_icon = new ImageIcon(Loja_img);
    JTextArea titulo = new JTextArea();
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
    JButton configs = new JButton("Configurações");
    JButton Carrinho_bot = new JButton("carrinho");
    JButton dinheiro = new JButton("Comprar");
    JButton volte = new JButton("voltar");
    JButton temp = new JButton();
    JTextField pesquisa = new JTextField("pesquise aqui o seu produto");
    JTextArea pontuacao = new JTextArea("Pontos");
    JPanel fundo = new JPanel();
    JScrollPane scroll_bar = new JScrollPane();//add em loja e carrinho
    JTextArea valor_a_pagar = new JTextArea("Total a pagar: ");
public Loja() {
    loja();
    this.setSize(largura_atual,altura_atual);
    this.addComponentListener(this);
    }
    public void loja(){
        this.setSize(700,700);
        this.setMinimumSize(new Dimension(700,700));
        this.add(temp);
        temp.addActionListener(this);
        temp.setText("voltar a tela login(temporario para ajudar na demonstração)");
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Loja.this.getWidth();
        int altura_atual = Loja.this.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 30);
        parceiros.setBounds((largura_atual/2)+300, 0, 100, 30);
        quests.setBounds((largura_atual/2), 0, 100, 30);
        configs.setBounds((largura_atual/2)+100, 0, 100, 30);
        pesquisa.setBounds(0,90,largura_atual,30);
        pontuacao.setBounds(largura_atual/2,60,largura_atual/2,30);
        pontuacao.setFont(new Font("Arial",Font.PLAIN,30));
        titulo.setFont(new Font("Arial",Font.PLAIN,30));
        scroll_bar.setBounds(0,105,altura_atual/15,altura_atual-90);
        temp.setBounds((largura_atual/2)+200, 500, 100, 30);
        Carrinho_bot.setBounds(0,60,largura_atual/2,30);
        prod_1.setBounds((largura_atual/6)-100,200,largura_atual/6,200);
        prod_2.setBounds((largura_atual/6)+(largura_atual/6)-100,200,largura_atual/6,200);
        prod_3.setBounds((largura_atual/6)+2*(largura_atual/6)-100,200,largura_atual/6,200);
        prod_4.setBounds((largura_atual/6)+3*(largura_atual/6)-100,200,largura_atual/6,200);
        prod_5.setBounds((largura_atual/6)+4*(largura_atual/6)-100,200,largura_atual/6,200);
        titulo.setBounds(0,30,largura_atual,30);
        Loja.this.revalidate();
        Loja.this.repaint();
    }
    });
        this.add(prod_1);
        prod_1.setBackground(Color.white);
        prod_1.setIcon(Halter_icon);
        prod_1.addActionListener(this);
        this.add(prod_2);
        prod_2.setBackground(Color.white);
        prod_2.setIcon(bar_prot_icon);
        prod_2.addActionListener(this);
        this.add(prod_3);
        prod_3.setBackground(Color.white);
        prod_3.setIcon(Whey_icon);
        prod_3.addActionListener(this);
        this.add(prod_4);
        prod_4.setBackground(Color.white);
        prod_4.setIcon(toalha_icon);
        prod_4.addActionListener(this);
        this.add(prod_5);
        prod_5.setBackground(Color.white);
        prod_5.addActionListener(this);
        this.add(produtos);
        produtos.addActionListener(this);
        this.add(quests);
        quests.addActionListener(this);
        this.add(configs);
        configs.addActionListener(this);
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
        pontuacao.setEditable(false);
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==produtos){
        new Loja().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==quests){
        new Metas().setVisible(true);;
        this.dispose();
        this.repaint();
    }else  if(e.getSource()==parceiros){
        new Parceiros().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==configs){
        new Configuracoes().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==Carrinho_bot){
        new Carrinho().setVisible(true);
        this.dispose();
    }
}
@Override
public void adjustmentValueChanged(AdjustmentEvent e) {
}
@Override
public void componentResized(ComponentEvent e) {}
@Override
public void componentMoved(ComponentEvent e) {}
@Override
public void componentShown(ComponentEvent e) {}
@Override
public void componentHidden(ComponentEvent e) {}
}
