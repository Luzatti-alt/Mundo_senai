import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Carrinho extends JFrame implements ActionListener, ComponentListener, AdjustmentListener{
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
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
    JButton configs = new JButton("Configurações");
    JButton Carrinho_bot = new JButton("carrinho");
    JButton dinheiro = new JButton("Comprar");
    JButton volte = new JButton("voltar");
    ImageIcon toalha_icon = new ImageIcon(toalha_img);
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
    JPanel fundo = new JPanel();
    JTextArea titulo = new JTextArea();
    public Carrinho() {
    carrinho();
    this.setSize(largura_atual,altura_atual);
    this.addComponentListener(this);
    }
     public void carrinho(){
        this.setMinimumSize(new Dimension(700,700));
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        produtos.setIcon(Loja_icon);
        Carrinho_bot.setIcon(Carrinho_icon);
        JScrollPane scroll_bar = new JScrollPane();//add em loja e carrinho
        JTextArea valor_a_pagar = new JTextArea("Total a pagar: ");
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Carrinho.this.getWidth();
        int altura_atual = Carrinho.this.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 30);
        parceiros.setBounds((largura_atual/2)-200, 0, 100, 30);
        quests.setBounds((largura_atual/2), 0, 100, 30);
        configs.setBounds((largura_atual/2)+100, 0, 100, 30);
        titulo.setBounds(0, 30, largura_atual, 30);
        volte.setBounds(0,altura_atual-100,largura_atual,60);
        dinheiro.setBounds(0,altura_atual-175,largura_atual,60);
        valor_a_pagar.setBounds(0, altura_atual-250, largura_atual, 60);
        fundo.setBounds(0, altura_atual-625, largura_atual, (altura_atual/2)-50);
        scroll_bar.setBounds(largura_atual-50,0,100,(altura_atual/2)-50);
    }
    });
        this.add(scroll_bar);
        this.add(produtos);
        produtos.addActionListener(this);
        this.add(parceiros);
        parceiros.addActionListener(this);
        this.add(quests);
        quests.addActionListener(this);
        this.add(configs);
        configs.addActionListener(this);
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
        titulo.setFont(new Font("arial",Font.PLAIN,30));
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
    }else if(e.getSource()==volte){
        new Loja().setVisible(true);;
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
