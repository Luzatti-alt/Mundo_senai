import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Descricao extends JPanel implements ActionListener, ComponentListener{
    JTextArea titulo = new JTextArea();
    JButton prod = new JButton();
    JLabel descricao = new JLabel();
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
	JButton configs = new JButton("Configurações");
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
    public void descricao(){
        try{
    FileReader leitor = new FileReader("produto.txt");
    BufferedReader br = new BufferedReader(leitor);
    String qual_prod = br.readLine(); 
            if (qual_prod == "halter") {
                prod.setIcon(Halter_icon);
                descricao.setText("");
            }else if (qual_prod == "barra") {
                prod.setIcon(bar_prot_icon);
                descricao.setText("");
            }else if (qual_prod == "whey") {
                prod.setIcon(Whey_icon);
                descricao.setText("");
            }else if (qual_prod == "toalha") {
                prod.setIcon(toalha_icon);
                descricao.setText("");
            }
            br.close();
            leitor.close();
    }catch(IOException ex){
        ex.printStackTrace();
    }
        //add funcionalidade para produtos especificos
        this.add(produtos);
        item.add(prod);
        desc.add(prod);
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
        produtos.setBounds((largura_atual/2)-100, 0, 100, 30);
        parceiros.setBounds((largura_atual/2)-200, 0, 100, 30);
        quests.setBounds((largura_atual/2), 0, 100, 30);
        configs.setBounds((largura_atual/2)+100, 0, 100, 30);
        item.setBounds(50,80,largura_atual/2-50,altura_atual/2);
        desc.setBounds(largura_atual/2+50,80,largura_atual/2-100,altura_atual/2);
        titulo.setBounds(0,30,largura_atual,30);
        dinheiro.setBounds(0,altura_atual-200,largura_atual,60);
        volte.setBounds(0,altura_atual-100,largura_atual,60);
    }
    }); 
        this.add(item);
        volte.addActionListener(this);
        item.setBackground(Color.lightGray);
        this.add(desc);
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
    }else  if(e.getSource()==produtos){
        this.removeAll();
        Loja loja = new Loja();
        this.add(loja);
        loja.setBounds(0,0,this.getWidth(), this.getHeight());
        this.revalidate();
        this.repaint();
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
