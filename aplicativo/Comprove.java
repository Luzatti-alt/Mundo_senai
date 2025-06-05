import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Comprove extends JFrame implements ActionListener, ComponentListener{
    int largura_atual = this.getWidth();
    int altura_atual = this.getHeight();
    JPanel fundo = new JPanel();
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
    JPanel Sistema_metas = new JPanel();
    JTextArea titulo = new JTextArea();
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
	JButton configs = new JButton("Configurações");
    JButton vid = new JButton("Vídeo");
    JButton laudo = new JButton("Laudo médico");
    JButton cons_profi = new JButton("Confirmação profisional parceiro da plataforma");
    public Comprove() {
        comprove();
        this.addComponentListener(this);
    }
    public void comprove(){
        this.setMinimumSize(new Dimension(900,600));
        this.add(titulo);
        this.setLayout(null);
        titulo.setText("Métodos de comprovantes");
        this.setBackground(Color.lightGray);
        titulo.setBackground(Color.green);
        this.setBackground(Color.lightGray);
        this.add(vid);
        vid.setBackground(Color.green);
        this.add(laudo);
        laudo.setBackground(Color.green);
        this.add(cons_profi);
        cons_profi.setBackground(Color.green);
        this.add(produtos);
        produtos.addActionListener(this);
        this.add(parceiros);
        parceiros.addActionListener(this);
        this.add(configs);
        configs.addActionListener(this);
        this.add(titulo);
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        produtos.setIcon(Loja_icon);
        quests.setIcon(Metas_icon);
        vid.addActionListener(this);
        laudo.addActionListener(this);
        cons_profi.addActionListener(this);
    }
    @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = this.getWidth();
        int altura_atual = this.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2), 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        titulo.setBounds(0, 28, largura_atual, 35);
        Sistema_metas.setBounds(0,60,largura_atual,altura_atual-63);
        vid.setBounds((altura_atual/2)-100,altura_atual-500,largura_atual/2,50);
        laudo.setBounds((altura_atual/2)-100,altura_atual-400,largura_atual/2,50);
        cons_profi.setBounds((altura_atual/2)-100,altura_atual-300,largura_atual/2,50);
    }
@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==produtos){
    new Loja().setVisible(true);
    this.dispose();
}else if(e.getSource()==quests){
    new Metas().setVisible(true);
    this.dispose();
}else if(e.getSource()==parceiros){
    new Parceiros().setVisible(true);
    this.dispose();
}else if(e.getSource()==configs){
    new Configuracoes().setVisible(true);
    this.dispose();
}else if(e.getSource()==vid){
        JOptionPane.showMessageDialog(this,"enviando o video para a comprovação");
    }else if(e.getSource()==laudo){
        JOptionPane.showMessageDialog(this,"enviando o laudo para a comprovação");
    }else if(e.getSource()==cons_profi){
        JOptionPane.showMessageDialog(this,"entrando em consulta profissional para a comprovação");
    }
}
@Override
public void componentMoved(ComponentEvent e) {}
@Override
public void componentShown(ComponentEvent e) {}
@Override
public void componentHidden(ComponentEvent e) {}
}
