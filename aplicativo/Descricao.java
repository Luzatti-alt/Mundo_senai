import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Descricao extends JPanel implements ActionListener, ComponentListener{
    JTextArea titulo = new JTextArea();
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
	JButton configs = new JButton("Configurações");
    JPanel item = new JPanel();
    JPanel desc = new JPanel();
    JButton dinheiro = new JButton("Comprar");
    JButton volte = new JButton("voltar");
    public void descricao(){
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
        //item.add();//imagem do item
        this.add(desc);
        desc.setBackground(Color.gray);
        //desc.add();//descrição do produto
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
