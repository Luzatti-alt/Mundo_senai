import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Parceiros extends JFrame implements ActionListener, ComponentListener{
    int largura_atual = this.getWidth();
    int altura_atual = this.getHeight();
    JTextArea titulo = new JTextArea();
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
	JButton configs = new JButton("Configurações");
    JPanel parça = new JPanel();
    JPanel academia_1 = new JPanel();
    JTextArea nome_e_dist_aca_1 = new JTextArea("academia 1");
    JTextArea endereco_aca_1 = new JTextArea("Rua principal, 1000");
    JPanel academia_2 = new JPanel();
    JTextArea nome_e_dist_aca_2 = new JTextArea("academia 2");
    JTextArea endereco_aca_2 = new JTextArea("Rua principal, 1200");
    JPanel academia_3 = new JPanel();
    JTextArea nome_e_dist_aca_3 = new JTextArea("academia 3");
    JTextArea endereco_aca_3 = new JTextArea("Rua fitness, 508");
    JPanel academia_4 = new JPanel();
    JTextArea nome_e_dist_aca_4 = new JTextArea("academia 4");
    JTextArea endereco_aca_4 = new JTextArea("Rua Sesi, 41");
    JPanel academia_5 = new JPanel();
    JTextArea nome_e_dist_aca_5 = new JTextArea("academia 5");
    JTextArea endereco_aca_5 = new JTextArea("Rua centro, 97");
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
    public Parceiros(){
        parceiros();
        this.addComponentListener(this);
    }
    public void parceiros(){
        this.setSize(700,700);
        this.setMinimumSize(new Dimension(700,700));
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = Parceiros.this.getWidth();
        int altura_atual = Parceiros.this.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        quests.setBounds((largura_atual/2), 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        titulo.setBounds(0, 33, largura_atual, 35);
        parça.setBounds(0, 68, largura_atual, altura_atual-68);
        nome_e_dist_aca_1.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        nome_e_dist_aca_2.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        nome_e_dist_aca_3.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        nome_e_dist_aca_4.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        nome_e_dist_aca_5.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        endereco_aca_1.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        endereco_aca_2.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        endereco_aca_3.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        endereco_aca_4.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
        endereco_aca_5.setFont(new Font("arial",Font.PLAIN,altura_atual/20));
    }
    }); 
        titulo.setText("Instituições parceiras");
        this.add(produtos);
        produtos.addActionListener(this);
        this.add(quests);
        quests.addActionListener(this);
        this.add(configs);
        configs.addActionListener(this);
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
        titulo.setFont(new Font("arial",Font.PLAIN,30));
        parça.setLayout(new GridLayout(5,1));
        //1 academia
        parça.add(academia_1);
        academia_1.setLayout(new GridLayout(2,1));
        academia_1.add(nome_e_dist_aca_1);
        nome_e_dist_aca_1.setEditable(false);
        academia_1.add(endereco_aca_1);
        endereco_aca_1.setEditable(false);
         //2 academia
        parça.add(academia_2);
        academia_2.setLayout(new GridLayout(2,1));
        academia_2.add(nome_e_dist_aca_2);
        nome_e_dist_aca_2.setEditable(false);
        academia_2.add(endereco_aca_2);
        endereco_aca_2.setEditable(false);
         //3 academia
        parça.add(academia_3);
        academia_3.setLayout(new GridLayout(2,1));
        academia_3.add(nome_e_dist_aca_3);
        nome_e_dist_aca_3.setEditable(false);
        academia_3.add(endereco_aca_3);
        endereco_aca_3.setEditable(false);
         //4 academia
        parça.add(academia_4);
        academia_4.setLayout(new GridLayout(2,1));
        academia_4.add(nome_e_dist_aca_4);
        nome_e_dist_aca_4.setEditable(false);
        academia_4.add(endereco_aca_4);
        endereco_aca_4.setEditable(false);
         //5 academia
        parça.add(academia_5);
        academia_5.setLayout(new GridLayout(2,1));
        academia_5.add(nome_e_dist_aca_5);
        nome_e_dist_aca_5.setEditable(false);
        academia_5.add(endereco_aca_5);
        endereco_aca_5.setEditable(false);
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==produtos){
        new Loja().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==quests){
        this.removeAll();
        new Metas().setVisible(true);;
        this.dispose();
    }else  if(e.getSource()==configs){
        this.removeAll();
        new Configuracoes().setVisible(true);;
        this.dispose();
    }
}
@Override
public void componentResized(ComponentEvent e) {}
@Override
public void componentMoved(ComponentEvent e) {}
@Override
public void componentShown(ComponentEvent e) {}
@Override
public void componentHidden(ComponentEvent e) {}
public static void main(){}
}
