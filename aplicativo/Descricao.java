import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Descricao extends JFrame implements ActionListener, ComponentListener{
    JPanel fundo = new JPanel();
    JTextArea titulo = new JTextArea();
    JButton prod = new JButton();
    JLabel descricao = new JLabel();
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
	JButton configs = new JButton("Configurações");
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
    JPanel item = new JPanel();
    JPanel desc = new JPanel();
    JButton dinheiro = new JButton("Comprar");
    JButton volte = new JButton("voltar");
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
    public Descricao() {
    descricao();
    this.setSize(700,700);
    this.addComponentListener(this);
    }
    public void descricao(){
        prod.setBackground(Color.WHITE);
        try{
    FileReader leitor = new FileReader("produto.txt");
    BufferedReader br = new BufferedReader(leitor);
    String qual_prod = br.readLine(); 
            if (qual_prod.equals("halter")) {
                prod.setIcon(Halter_icon);
                descricao.setText("Equipamento de musculação usado para treinos de força, ideal para exercícios de braços, peito e ombros.");
            }else if (qual_prod.equals("barra")) {
                prod.setIcon(bar_prot_icon);
                descricao.setText("Suplemento proteico de rápida absorção, excelente para recuperação muscular após o treino.");
            }else if (qual_prod.equals("whey")) {
                prod.setIcon(Whey_icon);
                descricao.setText("alimento nutritivo com alta concentração de proteínas, perfeito para consumir antes ou depois do treino");
            }else if (qual_prod.equals("toalha")) {
                prod.setIcon(toalha_icon);
                descricao.setText("Toalha prática e absorvente, essencial para manter a higiene pessoal durante os exercícios." );
            }
            br.close();
            leitor.close();
    }catch(IOException ex){
        ex.printStackTrace();
    }
        //add funcionalidade para produtos especificos
        this.add(produtos);
        produtos.addActionListener(this);
        this.add(quests);
        quests.addActionListener(this);
        this.add(configs);
        configs.addActionListener(this);
        this.add(titulo);
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Descricao.this.getWidth();
        int altura_atual = Descricao.this.getHeight();
        fundo.setBounds(largura_atual/4,80,largura_atual/2,altura_atual/2);
        produtos.setBounds((largura_atual/2)-100, 0, 100, 30);
        parceiros.setBounds((largura_atual/2)-200, 0, 100, 30);
        quests.setBounds((largura_atual/2), 0, 100, 30);
        configs.setBounds((largura_atual/2)+100, 0, 100, 30);
        titulo.setBounds(0,30,largura_atual,30);
        dinheiro.setBounds(0,altura_atual-200,largura_atual,60);
        volte.setBounds(0,altura_atual-100,largura_atual,60);
        prod.setSize(largura_atual/2,altura_atual/2);
        desc.setSize(largura_atual/2,altura_atual/2);
    }
    }); 
    this.add(fundo);
    fundo.setBackground(Color.lightGray);
    fundo.setLayout(new GridLayout(1,2));
    item.add(desc);
        desc.add(prod);
        volte.addActionListener(this);
        item.setBackground(Color.lightGray);
        fundo.add(desc);
        fundo.add(item);
        desc.setBackground(Color.gray);
        this.add(dinheiro);
        this.add(titulo);
        titulo.setBackground(Color.green);
        titulo.setText("Descrição do produto");
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        titulo.setEditable(false);
        this.add(volte);
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==produtos){
        new Loja().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==quests){
        new Metas().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==parceiros){
        new Parceiros().setVisible(true);
        this.dispose();
    }else  if(e.getSource()==configs){
        new Configuracoes().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==produtos){
        new Loja().setVisible(true);;
        this.dispose();
    }
    else if(e.getSource()==volte){
        new Loja().setVisible(true);;
        this.dispose();
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
public static void main(){}
}
