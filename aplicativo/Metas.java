import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Metas extends JPanel implements ActionListener,ComponentListener{
    int largura_atual = this.getWidth();
    int altura_atual = this.getHeight();
    JPanel fundo = new JPanel();
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
    JPanel Sistema_metas = new JPanel();
    //Metas
    JPanel Meta_diario = new JPanel();
    JPanel Meta_semanal = new JPanel();
    JPanel Meta_mensal = new JPanel();
    JTextArea Metas_diarias_txt = new JTextArea("Diarias");
    JTextArea Qual_diaria = new JTextArea("adicionar a metas diaria");
    JTextArea Metas_semanais_txt = new JTextArea("Semanais");
    JTextArea Qual_semanal = new JTextArea("adicionar a semanal");
    JTextArea Metas_mensais_txt = new JTextArea("Mensais");
    JTextArea Qual_mensal = new JTextArea("adicionar a mensal");
    JTextArea pnts_e_comprovacao_diaria = new JTextArea("pontos");
    JTextArea pnts_e_comprovacao_semanal= new JTextArea("pontos");
    JTextArea pnts_e_comprovacao_mensal= new JTextArea("pontos");
    JPanel dividir_dia = new JPanel();
    JPanel dividir_semana = new JPanel();
    JPanel dividir_mes = new JPanel();
    JButton comprovar_meta_diaria = new JButton("Comprovar meta");
    JButton comprovar_meta_semanal = new JButton("Comprovar meta");
    JButton comprovar_meta_mensal = new JButton("Comprovar meta");
    JButton vid = new JButton("Vídeo");
    JButton laudo = new JButton("Laudo médico");
    JButton cons_profi = new JButton("Confirmação profisional parceiro da plataforma");
    public void Metas(){
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = this.getWidth();
        int altura_atual = this.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
        parceiros.setBounds((largura_atual/2), 0, 100+1, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
        titulo.setBounds(0, 26, largura_atual+1, 35);
        Sistema_metas.setBounds(0,60,largura_atual+1,altura_atual-63);
    }
    }); 
        this.add(produtos);
        this.add(parceiros);
        this.add(configs);
        this.add(titulo);
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        produtos.setIcon(Loja_icon);
        quests.setIcon(Metas_icon);
        titulo.setText("Metas");
        titulo.setEditable(false);
        titulo.setBackground(new Color(61, 153, 32));//new Color(61, 153, 32)
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        this.add(Sistema_metas);
        Sistema_metas.setBackground(Color.white);
        Sistema_metas.setLayout(new GridLayout(3,1));
        //diarias
        Sistema_metas.add(Meta_diario);
        Meta_diario.add(Metas_diarias_txt);
        Metas_diarias_txt.setBackground(new Color(61, 153, 32));
        Metas_diarias_txt.setEditable(false);
        Metas_diarias_txt.setFont(new Font("Arial", Font.PLAIN, 60));
        Meta_diario.setLayout(new GridLayout(3,1));
        Meta_diario.add(Qual_diaria);
        Qual_diaria.setEditable(false);
        pnts_e_comprovacao_diaria.setEditable(false);
        Meta_diario.add(dividir_dia);
        dividir_dia.setLayout(new GridLayout(1,2));
        dividir_dia.add(pnts_e_comprovacao_diaria);
        dividir_dia.add(comprovar_meta_diaria);
        comprovar_meta_diaria.setFocusable(false);
        comprovar_meta_diaria.addActionListener(this);
        //semanal
        Sistema_metas.add(Meta_semanal);
        Meta_semanal.add(Metas_semanais_txt);
        Metas_semanais_txt.setBackground(new Color(61, 153, 32));
        Metas_semanais_txt.setEditable(false);
        Metas_semanais_txt.setFont(new Font("Arial", Font.PLAIN, 60));
        Meta_semanal.setLayout(new GridLayout(3,1));
        Meta_semanal.add(Qual_semanal);
        Qual_semanal.setEditable(false);
        pnts_e_comprovacao_semanal.setEditable(false);
        Meta_semanal.add(dividir_semana);
        dividir_semana.setLayout(new GridLayout(1,2));
        dividir_semana.add(pnts_e_comprovacao_semanal);
        dividir_semana.add(comprovar_meta_semanal);
        comprovar_meta_semanal.setFocusable(false);
        comprovar_meta_semanal.addActionListener(this);
        //mensal
        Sistema_metas.add(Meta_mensal);
        Meta_mensal.add(Metas_mensais_txt);
        Metas_mensais_txt.setBackground(new Color(61, 153, 32));
        Metas_mensais_txt.setEditable(false);
        Metas_mensais_txt.setFont(new Font("Arial", Font.PLAIN, 60));
        Meta_mensal.setLayout(new GridLayout(3,1));
        Meta_mensal.add(Qual_mensal);
        Qual_mensal.setEditable(false);
        pnts_e_comprovacao_mensal.setEditable(false);
        Meta_mensal.add(dividir_mes);
        dividir_mes.setLayout(new GridLayout(1,2));
        dividir_mes.add(pnts_e_comprovacao_mensal);
        dividir_mes.add(comprovar_meta_mensal);
        comprovar_meta_mensal.setFocusable(false);
        comprovar_meta_mensal.addActionListener(this);
	}
    public void comprove(){
        this.add(titulo);
        titulo.setText("Métodos de comprovantes");
        titulo.setBackground(Color.green);
        this.setBackground(Color.lightGray);
        this.add(vid);
        vid.setBackground(Color.green);
        this.add(laudo);
        laudo.setBackground(Color.green);
        this.add(cons_profi);
        cons_profi.setBackground(Color.green);
        this.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = this.getWidth();
        int altura_atual = this.getHeight();
        titulo.setBounds(0,30,largura_atual,30);
        fundo.setBounds(0,60,largura_atual,altura_atual-60);
        vid.setBounds(100,altura_atual-500,largura_atual/2,50);
        laudo.setBounds(100,altura_atual-400,largura_atual/2,50);
        cons_profi.setBounds(100,altura_atual-300,largura_atual/2,50);
    }
    });
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==produtos){
        //
    }else  if(e.getSource()==quests){
        //
    }else  if(e.getSource()==parceiros){
        //
    }else  if(e.getSource()==configs){
        this.removeAll();
        Configuracoes configuracoes = new Configuracoes();
        this.add(configuracoes);
        configuracoes.setBounds(0,0,this.getWidth(), this.getHeight());
        this.revalidate();
        this.repaint();
    }

}
@Override
public void componentMoved(ComponentEvent e) {}
@Override
public void componentShown(ComponentEvent e) {}
@Override
public void componentHidden(ComponentEvent e) {}
    public static void main(String[]args){
        //
    }
}