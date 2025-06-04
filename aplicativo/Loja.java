import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Loja extends JPanel implements ActionListener, ComponentListener, AdjustmentListener{
    int largura_atual = this.getWidth();
    int altura_atual = this.getHeight();
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
    JScrollBar scroll_bar = new JScrollBar();//add em loja e carrinho
    JTextArea valor_a_pagar = new JTextArea("Total a pagar: ");
public Loja() {
    loja();
    this.addComponentListener(this);
    }
    public void loja(){
        this.add(temp);
        temp.addActionListener(this);
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
        scroll_bar.setBounds(0,105,altura_atual/15,altura_atual-90);
        temp.setBounds((largura_atual/2)+200, 500, 100, 30);
        Carrinho_bot.setBounds(0,60,largura_atual/2,30);
        titulo.setBounds(0,30,largura_atual,30);
        Loja.this.revalidate();
        Loja.this.repaint();
    }
    });
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
        scroll_bar.addAdjustmentListener(this);
        pontuacao.setEditable(false);
    }
    public void carrinho(){
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        produtos.setIcon(Loja_icon);
        Carrinho_bot.setIcon(Carrinho_icon);
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Loja.this.getWidth();
        int altura_atual = Loja.this.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 30);
        parceiros.setBounds((largura_atual/2)-200, 0, 100, 30);
        quests.setBounds((largura_atual/2), 0, 100, 30);
        configs.setBounds((largura_atual/2)+100, 0, 100, 30);
        titulo.setBounds(0, 30, largura_atual, 30);
        volte.setBounds(0,altura_atual-100,largura_atual,60);
        dinheiro.setBounds(0,altura_atual-175,largura_atual,60);
        valor_a_pagar.setBounds(0, altura_atual-250, largura_atual, 60);
        fundo.setBounds(0, altura_atual-625, largura_atual, (altura_atual/2)-50);
        scroll_bar.setBounds(largura_atual-50,0,largura_atual/20,(altura_atual/2)-50);
    }
    });
        fundo.add(scroll_bar);
        scroll_bar.addAdjustmentListener(this);
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
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==produtos){
        //
    }else  if(e.getSource()==quests){
        this.removeAll();
        Metas metas = new Metas();
        this.add(metas);
        metas.setBounds(0,0,this.getWidth(), this.getHeight());
        this.revalidate();
        this.repaint();
    }else  if(e.getSource()==parceiros){
        //
    }else  if(e.getSource()==configs){
        this.removeAll();
        Configuracoes configuracoes = new Configuracoes();
        this.add(configuracoes);
        configuracoes.setBounds(0,0,this.getWidth(), this.getHeight());
        this.revalidate();
        this.repaint();
    }else  if(e.getSource()==Carrinho_bot){
        this.removeAll();
        carrinho();
        Loja.this.revalidate();
        Loja.this.repaint();
    }
}
@Override
    public void adjustmentValueChanged(AdjustmentEvent arg0){
        System.out.println("scrollbar: "+scroll_bar.getValue());
    }
@Override
public void componentResized(ComponentEvent e) {}
@Override
public void componentMoved(ComponentEvent e) {}
@Override
public void componentShown(ComponentEvent e) {}
@Override
public void componentHidden(ComponentEvent e) {}
    public static void main(String[]args){
    }
}
