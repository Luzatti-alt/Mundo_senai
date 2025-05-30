import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Configuracoes extends JPanel implements ActionListener, ComponentListener{
    JTextArea titulo = new JTextArea();
    JPanel Menu = new JPanel();
    JPanel tela_configs = new JPanel();
    JPanel conta = new JPanel();
    JPanel dados_pagamento = new JPanel();
    JTextArea nome_txt = new JTextArea("Usuario");
    JPanel nome = new JPanel();
    JPanel tipo_assinatura = new JPanel();
    JTextArea  tipo_assinatura_txt = new JTextArea("Assinatura");
    JPanel data_cria_conta = new JPanel();
    JTextArea data_cria_conta_txt = new JTextArea("Data da criação da conta");
    JTextArea mes = new JTextArea("Mensal");
	JTextArea tres_meses = new JTextArea("3 Meses");
	JTextArea seis_meses = new JTextArea("6 Meses");
	JTextArea doze_meses = new JTextArea("12 Meses");
	JTextArea cinquentao = new JTextArea("R$:49,99");
	JTextArea cento_cinquente= new JTextArea("R$:97,99");
	JTextArea trezentos = new JTextArea("R$:152,99");
	JTextArea quinhentos_quarenta = new JTextArea("R$:273,99");
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
	JButton sobre_nos = new JButton("Sobre nos");
	JButton configs = new JButton("Configurações");
    JButton Debito = new JButton("Débito");
	JButton Pix = new JButton("Pix");
	JButton Credito = new JButton("Crédito");
	JButton Boleto = new JButton("Boleto");
    Dimension tamanho_tela = Toolkit.getDefaultToolkit().getScreenSize();
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
    public Configuracoes() {
        configuracoes();
        this.addComponentListener(this);
    }
    public void configuracoes(){
        this.setLayout(null);
        int largura_atual = this.getWidth();
        int altura_atual = this.getHeight();
        tela_configs.setBounds(0, 0, largura_atual, 28);
        titulo.setBounds(0,29,largura_atual,35);
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2)+100, 0, 100, 28);
        quests.setBounds((largura_atual/2), 0, 100, 28);
        sobre_nos.setBounds(0,300,largura_atual/2,30);
        this.add(Menu);
        this.add(titulo);
        titulo.setText("Opções de assinatura & conta");
        this.add(conta);
        this.add(dados_pagamento);
        this.setMinimumSize(new Dimension(600, 300));
        this.setLayout(null);
        this.add(tela_configs);
        tela_configs.setSize(tamanho_tela);
        produtos.addActionListener(this);
        tela_configs.add(produtos);
        parceiros.addActionListener(this);
        tela_configs.add(parceiros);
        quests.addActionListener(this);
        tela_configs.add(quests);
        configs.addActionListener(this);
        tela_configs.add(configs);
        tela_configs.setLayout(new BorderLayout());
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        produtos.setIcon(Loja_icon);
        titulo.setEditable(false);
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        titulo.setBackground(new Color(61, 153, 32));
        conta.setLayout(null);
        conta.setBounds(0,61,largura_atual/2,altura_atual-61 );
        sobre_nos.addActionListener(this);
        conta.add(sobre_nos);
        conta.add(nome_txt);
        nome_txt.setBackground(null);
        nome_txt.setFont(new Font("arial",Font.PLAIN,30));
        nome_txt.setEditable(false);
        nome_txt.setBounds(0, 0, 120, 30);
        //num JPanel a cordenada em setBounds considera 0,0 o topo do JPanel
        conta.add(nome);
        nome.setBackground(new Color(122,159,125));
        nome.setBounds(0, 30, 1000, 60);
        conta.add(tipo_assinatura_txt);
        tipo_assinatura_txt.setBackground(null);
        tipo_assinatura_txt.setFont(new Font("arial",Font.PLAIN,30));
        tipo_assinatura_txt.setBounds(0, 90,1000,30);
        tipo_assinatura_txt.setEditable(false);
        conta.add(tipo_assinatura);
        tipo_assinatura.setBackground(new Color(122,159,125));
        tipo_assinatura.setBounds(0, 120,1000,60);
        conta.add(data_cria_conta_txt);
        data_cria_conta_txt.setBackground(null);
        data_cria_conta_txt.setFont(new Font("arial",Font.PLAIN,30));
        data_cria_conta_txt.setBounds(0,180,1000,30);
        data_cria_conta_txt.setEditable(false);
        conta.add(data_cria_conta);
        data_cria_conta.setBackground(new Color(122,159,125));
        data_cria_conta.setBounds(0,200,1000,60);
        dados_pagamento.add(mes);
        dados_pagamento.setBackground(Color.lightGray);
        dados_pagamento.setLayout(null);
        dados_pagamento.setBounds(largura_atual/2,61,largura_atual/2,altura_atual-61);
    	mes.setEditable(false);
        mes.setBackground(new Color(200, 255, 206));
    	mes.setFont(new Font("Arial", Font.PLAIN, 26));
    	dados_pagamento.add(tres_meses);
    	tres_meses.setEditable(false);
        tres_meses.setBackground(new Color(200, 255, 206));
    	tres_meses.setFont(new Font("Arial", Font.PLAIN, 26));
    	tres_meses.setBounds(50,160,120,50);
    	dados_pagamento.add(seis_meses);
    	seis_meses.setEditable(false);
        seis_meses.setBackground(new Color(200, 255, 206));
    	seis_meses.setFont(new Font("Arial", Font.PLAIN, 26));
    	seis_meses.setBounds(50,220,120,50);
    	dados_pagamento.add(doze_meses);
    	doze_meses.setEditable(false);
        doze_meses.setBackground(new Color(200, 255, 206));
    	doze_meses.setFont(new Font("Arial", Font.PLAIN, 26));
    	doze_meses.setBounds(50,280,120,50);
    	dados_pagamento.add(cinquentao);
    	cinquentao.setEditable(false);
        cinquentao.setBackground(new Color(122,159,125));
	    cinquentao.setFont(new Font("Arial", Font.PLAIN, 26));
    	cinquentao.setBounds(250,100,120,50);
	    dados_pagamento.add(cento_cinquente);
	    cento_cinquente.setEditable(false);
        cento_cinquente.setBackground(new Color(122,159,125));
	    cento_cinquente.setFont(new Font("Arial", Font.PLAIN, 26));
	    cento_cinquente.setBounds(250,160,120,50);
    	dados_pagamento.add(trezentos);
	    trezentos.setEditable(false);
        trezentos.setBackground(new Color(122,159,125));
    	trezentos.setFont(new Font("Arial", Font.PLAIN, 26));
	    trezentos.setBounds(250,220,120,50);
    	dados_pagamento.add(quinhentos_quarenta);
	    quinhentos_quarenta.setEditable(false);
        quinhentos_quarenta.setBackground(new Color(122,159,125));
    	quinhentos_quarenta.setFont(new Font("Arial", Font.PLAIN, 26));
        quinhentos_quarenta.setBounds(250,280,120,50);
    	dados_pagamento.add(Debito);
        Debito.setBackground(new Color(73, 207, 78));
    	Debito.setFocusable(false);
    	Debito.setBounds(50,360,120,50);
    	dados_pagamento.add(Pix);
        Pix.setBackground(new Color(73, 207, 78));
    	Pix.setFocusable(false);
    	Pix.setBounds(50,420,120,50);
    	dados_pagamento.add(Credito);
        Credito.setBackground(new Color(73, 207, 78));
    	Credito.setFocusable(false);
    	Credito.setBounds(250,360,120,50);
    	dados_pagamento.add(Boleto);
        Boleto.setBackground(new Color(73, 207, 78));
    	Boleto.setFocusable(false);
    	Boleto.setBounds(250,420,120,50);
        this.setVisible(true);   
        this.repaint();
        this.revalidate();
    }
    @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = this.getWidth();
        int altura_atual = this.getHeight();
        tela_configs.setBounds(0, 0, largura_atual, 28);
        titulo.setBounds(0,29,largura_atual,35);
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2)+100, 0, 100, 28);
        quests.setBounds((largura_atual/2), 0, 100, 28);
        sobre_nos.setBounds(0,300,largura_atual/2,30);
        conta.setBounds(0,61,largura_atual/2,altura_atual-61);
        dados_pagamento.setBounds(largura_atual/2,61,largura_atual/2,altura_atual-61);
        mes.setBounds(50,100,120,50);
        }
    @Override
public void actionPerformed(ActionEvent e) {}

@Override
public void componentMoved(ComponentEvent e) {}

@Override
public void componentShown(ComponentEvent e) {
}
@Override
public void componentHidden(ComponentEvent e) {
}
public static void main(String[] args) {
        Configuracoes configuracoes = new Configuracoes();
        configuracoes.configuracoes();
    }
}
