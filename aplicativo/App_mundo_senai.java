import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class App_mundo_senai extends JFrame implements ActionListener {
    JPanel tela_configs = new JPanel();
    JPanel Top_ui = new JPanel();
    // Componentes globais
    JFrame janela = new JFrame();
    File info = new File("info.txt");
    int min_x = 700;
    int min_y = 700;
    Dimension tamanho_tela = Toolkit.getDefaultToolkit().getScreenSize();
    int largura_atual = janela.getWidth();  
    int altura_atual = janela.getHeight();
	//login
	JButton Logar = new JButton();
	JButton esqueceu_senha = new JButton();
	JButton criar_conta = new JButton();
	JTextField usuario_login = new JTextField();
	JTextField senha_login = new JTextField();
    JTextArea usuario_text = new JTextArea("Usuario");
	JTextArea senha_text = new JTextArea("Senha");
    JPanel box_login = new JPanel();
	JPanel Menu = new JPanel();
	//menus
	JButton parceiros = new JButton("Parceiros");
	JButton quests = new JButton("Metas");
	JButton produtos = new JButton("Produtos");
	JButton sobre_nos = new JButton("Sobre nos");
	JButton configs = new JButton("Configurações");
	//info contas
    JPanel cont_tela = new JPanel();
    JPanel conta = new JPanel();
    JTextArea nome_txt = new JTextArea("Usuario");
    JPanel nome = new JPanel();
    JPanel tipo_assinatura = new JPanel();
    JTextArea  tipo_assinatura_txt = new JTextArea("Assinatura");
    JPanel data_cria_conta = new JPanel();
    JTextArea data_cria_conta_txt = new JTextArea("Data da criação da conta");
     //dados da assinatura escolha
	JPanel dados_pagamento = new JPanel();
    JTextArea ops_assinatura = new JTextArea("Opções de assinatura & conta");
	JTextArea mes = new JTextArea("Mensal");
	JTextArea tres_meses = new JTextArea("3 Meses");
	JTextArea seis_meses = new JTextArea("6 Meses");
	JTextArea doze_meses = new JTextArea("12 Meses");
	JTextArea cinquentao = new JTextArea("R$:49,99");
	JTextArea cento_cinquente= new JTextArea("R$:97,99");
	JTextArea trezentos = new JTextArea("R$:152,99");
	JTextArea quinhentos_quarenta = new JTextArea("R$:273,99");
	JButton Debito = new JButton("Débito");
	JButton Pix = new JButton("Pix");
	JButton Credito = new JButton("Crédito");
	JButton Boleto = new JButton("Boleto");
    //Metas
    JTextArea metas_titulo = new JTextArea("Metas");
    JPanel Sistema_metas = new JPanel();
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
    //sobre nos
    JTextArea mais_sobre_nos = new JTextArea();
    JTextArea _sobre_nos = new JTextArea("mais sobre nos");
    JTextArea about = new JTextArea("Nossa plataforma tem como prioridade a saude de nossa clientela, por isso, disponibilizamos rotinas de treino \n para cada cliente em específico e que possa ser feito sem o uso de nenhum equipamento como máquinas e pesos.\n" + //
    "Também temos disponível a venda de produtos utilizados para o melhor desempenho em atividades físicas como camisetas esportivas \ne suplementos como creatina, proteina e vitaminas por um preço menor doque o convencional.\r\n" + //
    "Oferecemos também metas diárias e semanais que ao serem cumpridas (comprovantes são necessários) garantem aos nossos\nclientes pontos que podem ser utilizados para adquirir os produtos da nossa loja.\r\n" + //
    "Você pode comprovar o cumprimento destas tarefas com vídeos, fotos, marcapassos, laudos médicos e também por exames realizados\npor profissionais localizados em instituições parceiras do nosso serviço");
    JPanel texto = new JPanel();
    //parceiros
    JPanel parça = new JPanel();
    JTextArea instituicoes = new JTextArea("Instituições parceiras");
    JPanel academia_1 = new JPanel();
    JTextArea nome_e_dist_aca_1 = new JTextArea("academia 1");
    JTextArea endereco_aca_1 = new JTextArea("endereço rua 1 , num");
    JPanel academia_2 = new JPanel();
    JTextArea nome_e_dist_aca_2 = new JTextArea("academia 2");
    JTextArea endereco_aca_2 = new JTextArea("endereço rua 2 , num");
    JPanel academia_3 = new JPanel();
    JTextArea nome_e_dist_aca_3 = new JTextArea("academia 3");
    JTextArea endereco_aca_3 = new JTextArea("endereço rua 3 , num");
    JPanel academia_4 = new JPanel();
    JTextArea nome_e_dist_aca_4 = new JTextArea("academia 4");
    JTextArea endereco_aca_4 = new JTextArea("endereço rua 4 , num");
    JPanel academia_5 = new JPanel();
    JTextArea nome_e_dist_aca_5 = new JTextArea("academia 5");
    JTextArea endereco_aca_5 = new JTextArea("endereço rua 5 , num");
    //loja
    public App_mundo_senai(){
        if (info.exists()) {
            System.out.println("Arquivo existente");
        } else {
            System.out.println("Arquivo inexistente");
            try {
                FileWriter info = new FileWriter("info.txt");
                info.write("add info de login talvez via pipe");
                info.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String validador_login = "salvo_sim";
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(info));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.equals(validador_login)) {
                    Info_conta();
                    break;
                } else {
                    login();
                    break;
                }
            }
            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	//pagina login
    public void login(){
        janela.setTitle("Projeto Mundo Senai: Treina Aí");
        janela.setMinimumSize(new Dimension(min_x, min_y));
        janela.setSize(new Dimension(min_x, min_y));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null); 
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        System.out.println(altura_atual+" altura");
        System.out.println(largura_atual+" largura");
        box_login.setBounds((largura_atual/2)-250, 100, 500, 225);
        usuario_login.setBounds(10, 60, 480, 40);
        senha_login.setBounds(10, 150, 480, 40);  
        criar_conta.setBounds((largura_atual/2)-150, 425, 300, 50);
        Logar.setBounds((largura_atual/2)-150, 350, 300, 50);  
        esqueceu_senha.setBounds(0, 600,largura_atual,50);
        janela.repaint();
        janela.revalidate();
    }
    });
		//tela colocar info p /login
        box_login.setLayout(null);
        box_login.setBackground(Color.lightGray);
        usuario_text.setBackground(null);
        usuario_text.setEditable(false);
        usuario_text.setFont(new Font("Arial", Font.PLAIN, 30));
        box_login.add(usuario_text);
        usuario_login.setBorder(BorderFactory.createEmptyBorder());
        //ver como desativar as bordas ao redor do input
        usuario_text.setBounds(largura_atual/2, 10, 480, 60);
        usuario_login.setBackground(new Color(200, 255, 206));
        box_login.add(usuario_login);
        senha_text.setBounds(0, 100, 480, 60);
        senha_text.setBackground(null);
        senha_text.setEditable(false);
        senha_text.setFont(new Font("Arial", Font.PLAIN, 30)); 
        box_login.add(senha_text);
        senha_login.setBorder(BorderFactory.createEmptyBorder()); 
        senha_login.setBackground(new Color(200, 255, 206));
        box_login.add(senha_login);
        janela.add(box_login);
        janela.add(criar_conta);
        criar_conta.setBackground(new Color(122,159,125));
        criar_conta.setFocusable(false);
        criar_conta.setText("Criar conta");
	    //botões
		janela.add(esqueceu_senha);
        esqueceu_senha.setBackground(new Color(122,159,125));
		esqueceu_senha.setFocusable(false);
		esqueceu_senha.setText("esqueceu sua senha");
		esqueceu_senha.addActionListener(this);
        Logar.setText("Logar");
        Logar.setBackground(new Color(122,159,125));
        Logar.addActionListener(this);
        janela.add(Logar);
        janela.setVisible(true);
    }
    //resetar elementos
    public void limparJanela(){
        janela.getContentPane().removeAll();
        janela.repaint();
        janela.revalidate();
        }
	//pagina info da conta
    public void Info_conta() {
        //definindo janela
        Menu = new JPanel(); // Recria o painel de menu
        janela.add(Menu);
        janela.add(ops_assinatura);
        janela.add(cont_tela);
        janela.setMinimumSize(new Dimension(min_x, min_y));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.add(tela_configs);
        System.out.println(tamanho_tela);
        tela_configs.setSize(tamanho_tela);
        // Produtos
        produtos = new JButton("Produtos");
        produtos.addActionListener(this);
        tela_configs.add(produtos);
        // Parceiros
        parceiros = new JButton("Parceiros");
        parceiros.addActionListener(this);
        tela_configs.add(parceiros);
        // Metas (Quests)
        quests = new JButton("Metas");
        quests.addActionListener(this);
        tela_configs.add(quests);
        // Configurações
        configs = new JButton("Configurações");
        configs.addActionListener(this);
        tela_configs.add(configs);
        //
        tela_configs.setLayout(new BorderLayout());
        cont_tela.add(conta);
        cont_tela.add(dados_pagamento);
        cont_tela.setLayout(new GridLayout(1,2));
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        tela_configs.setBounds(0, 0, largura_atual, 28);
        ops_assinatura.setBounds(0,29,largura_atual,35);
        cont_tela.setBounds(0, 64, largura_atual, altura_atual-64);
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2)+100, 0, 100, 28);
        quests.setBounds((largura_atual/2), 0, 100, 28);
        sobre_nos.setBounds(0,300,largura_atual/2,30);
    }
    });
        //Menu titulo acima
        //menu do topo
        ops_assinatura.setEditable(false);
        ops_assinatura.setFont(new Font("Arial", Font.PLAIN, 30));
        ops_assinatura.setBackground(new Color(61, 153, 32));
        //infos da conta
        conta.setLayout(null);
        conta.setBounds(largura_atual,61,1000,10000);
        sobre_nos.addActionListener(this);
        conta.add(sobre_nos);
        conta.add(nome_txt);
        nome_txt.setBackground(null);
        nome_txt.setFont(new Font("arial",Font.PLAIN,30));
        nome_txt.setEditable(false);
        nome_txt.setBounds(0, 0, 120, 30);
        //num JPanel a cordenada em setBounds considera 0,0 o topo do JPanel
        conta.add(nome);
        conta.setBounds(690,60,1000,1000);
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
        //mes e valor
        dados_pagamento.add(mes);
        dados_pagamento.setBackground(Color.lightGray);
        dados_pagamento.setLayout(null);
        dados_pagamento.setBounds(0,60,1000,1000);
    	mes.setEditable(false);
        mes.setBackground(new Color(200, 255, 206));
    	mes.setFont(new Font("Arial", Font.PLAIN, 26));
    	mes.setBounds(50,100,120,50);
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
    	//pagamento
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
    	//outros
        janela.getContentPane().setBackground(Color.white);
        janela.revalidate();
        janela.repaint();
        janela.setVisible(true);
        }
	//pagina de metas
	public void Metas(){
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2), 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        metas_titulo.setBounds(0, 26, largura_atual, 35);
        Sistema_metas.setBounds(0,60,largura_atual,altura_atual-63);
    }
    }); 
        janela.add(produtos);
        janela.add(parceiros);
        janela.add(configs);
        janela.add(metas_titulo);
        metas_titulo.setEditable(false);
        metas_titulo.setBackground(Color.LIGHT_GRAY);//new Color(61, 153, 32
        //tentarei uma cor mais clara
        metas_titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        janela.add(Sistema_metas);
        Sistema_metas.setBackground(Color.white);
        Sistema_metas.setLayout(new GridLayout(3,1));
        //diarias
        Sistema_metas.add(Meta_diario);
        Meta_diario.add(Metas_diarias_txt);
        Metas_diarias_txt.setBackground(new Color(61, 153, 32));
        Metas_diarias_txt.setEditable(false);
        Metas_diarias_txt.setFont(new Font("Arial", Font.PLAIN, 30));
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
        Metas_semanais_txt.setFont(new Font("Arial", Font.PLAIN, 30));
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
        Metas_mensais_txt.setFont(new Font("Arial", Font.PLAIN, 30));
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
    //sobre o serviço
    public void sobre(){
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2), 0, 100, 28);
        quests.setBounds((largura_atual/2)-200, 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        _sobre_nos.setBounds(0,26,largura_atual,35);
        about.setBounds(0,57,largura_atual,1460);
    }
    });
    janela.add(produtos);
    janela.add(parceiros);
    janela.add(quests);
    janela.add(configs);
        //trocar o layout
        janela.setLayout(null);
        janela.add(_sobre_nos);
        janela.add(_sobre_nos);
        _sobre_nos.setEditable(false);
        _sobre_nos.setFont(new Font("arial",Font.PLAIN,30));
        mais_sobre_nos.setBounds(0,27,1550, 30);
        janela.add(about);
        about.setEditable(false);
        about.setBackground(new Color(200, 255, 206));
        _sobre_nos.setBackground(new Color(61, 153, 32));
        mais_sobre_nos.setEditable(false);
        mais_sobre_nos.setFont(new Font("arial",Font.PLAIN,30));
        mais_sobre_nos.setPreferredSize(new Dimension(1550, 30));
        about.setFont(new Font("arial",Font.PLAIN,26));
    }
    //pagina parceiro
    public void parceiro_page(){
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2)-200, 0, 100, 28);
        quests.setBounds((largura_atual/2), 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        metas_titulo.setBounds(0, 26, largura_atual, 35);
        Sistema_metas.setBounds(0,60,largura_atual,altura_atual-63);
        instituicoes.setBounds(0,26,largura_atual,35);
        parça.setBounds(0, 61, largura_atual, 1000);
    }
    }); 
        janela.add(produtos);
        janela.add(parceiros);
        janela.add(quests);
        janela.add(configs);
        janela.add(metas_titulo);
        janela.add(parça);
        parça.setBounds(0, 61, largura_atual, 1000);
        parça.setBackground(Color.lightGray);
        janela.add(instituicoes);
        instituicoes.setBackground(new Color(61, 153, 32));
        instituicoes.setEditable(false);
        instituicoes.setBounds(0,26,largura_atual,35);
        instituicoes.setFont(new Font("arial",Font.PLAIN,30));
        parça.setLayout(new GridLayout(5,1));
        //1 academia
        parça.add(academia_1);
        academia_1.setLayout(new GridLayout(2,1));
        academia_1.add(nome_e_dist_aca_1);
        nome_e_dist_aca_1.setEditable(false);
        nome_e_dist_aca_1.setFont(new Font("arial",Font.PLAIN,30));
        academia_1.add(endereco_aca_1);
        endereco_aca_1.setEditable(false);
        endereco_aca_1.setFont(new Font("arial",Font.PLAIN,30));
         //2 academia
        parça.add(academia_2);
        academia_2.setLayout(new GridLayout(2,1));
        academia_2.add(nome_e_dist_aca_2);
        nome_e_dist_aca_2.setEditable(false);
        nome_e_dist_aca_2.setFont(new Font("arial",Font.PLAIN,30));
        academia_2.add(endereco_aca_2);
        endereco_aca_2.setEditable(false);
        endereco_aca_2.setFont(new Font("arial",Font.PLAIN,30));
         //3 academia
        parça.add(academia_3);
        academia_3.setLayout(new GridLayout(2,1));
        academia_3.add(nome_e_dist_aca_3);
        nome_e_dist_aca_3.setEditable(false);
        nome_e_dist_aca_3.setFont(new Font("arial",Font.PLAIN,30));
        academia_3.add(endereco_aca_3);
        endereco_aca_3.setEditable(false);
        endereco_aca_3.setFont(new Font("arial",Font.PLAIN,30));
         //4 academia
        parça.add(academia_4);
        academia_4.setLayout(new GridLayout(2,1));
        academia_4.add(nome_e_dist_aca_4);
        nome_e_dist_aca_4.setEditable(false);
        nome_e_dist_aca_4.setFont(new Font("arial",Font.PLAIN,30));
        academia_4.add(endereco_aca_4);
        endereco_aca_4.setEditable(false);
        endereco_aca_4.setFont(new Font("arial",Font.PLAIN,30));
         //5 academia
        parça.add(academia_5);
        academia_5.setLayout(new GridLayout(2,1));
        academia_5.add(nome_e_dist_aca_5);
        nome_e_dist_aca_5.setEditable(false);
        nome_e_dist_aca_5.setFont(new Font("arial",Font.PLAIN,30));
        academia_5.add(endereco_aca_5);
        endereco_aca_5.setEditable(false);
        endereco_aca_5.setFont(new Font("arial",Font.PLAIN,30));
    }
    //pagina loja
    public void loja(){
        //
    } // Para o botão funcionar
    public void carrinho(){
        //
    }
    public void comprove(){
        //
    }
    public void descricao(){
        //
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Logar) {
            System.out.println("Logando...");
			limparJanela();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            Info_conta();
            janela.setSize(largura_atual+1,altura_atual);
            tela_configs.setBounds(0, 0, largura_atual+1, 28);
            ops_assinatura.setBounds(0,24,largura_atual+1,35);
            cont_tela.setBounds(0, 60, largura_atual+1, altura_atual-60);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            quests.setBounds((largura_atual/2), 0, 100+1, 28);
            janela.repaint();
            janela.revalidate();
        } else if (e.getSource() == esqueceu_senha) {
            
        }else if (e.getSource() == criar_conta) {
            //
        } else if (e.getSource() == sobre_nos) {
            limparJanela();
            sobre();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            System.out.println("largura: "+largura_atual);
            System.out.println("altura: "+altura_atual);
            Metas();
            janela.setSize(largura_atual+1,altura_atual);
            quests.setBounds((largura_atual/2)-200, 0, 100+1, 28);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            janela.repaint();
            janela.revalidate();
        } else if (e.getSource() == produtos) {
            limparJanela();
        } else if (e.getSource() == quests) {
			limparJanela();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            Metas();
            janela.setSize(largura_atual+1,altura_atual);
            Sistema_metas.setBounds(0, 28, largura_atual+1, 28);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            metas_titulo.setBounds(0, 26, largura_atual+1, 35);
            Sistema_metas.setBounds(0,60,largura_atual+1,altura_atual-63);
            janela.repaint();
            janela.revalidate();
        } else if (e.getSource() == parceiros) {
            limparJanela();
            janela.remove(metas_titulo);
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            parceiro_page();
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            quests.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            instituicoes.setBounds(0,26,largura_atual+1,35);
            parça.setBounds(0, 61, largura_atual+1, 1000);
        }if(e.getSource()==configs){
			//adicionar pra remover todos os outros itens
            limparJanela();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
			Info_conta();
            janela.setSize(largura_atual+1,altura_atual);
            tela_configs.setBounds(0, 0, largura_atual+1, 28);
            ops_assinatura.setBounds(0,24,largura_atual+1,35);
            cont_tela.setBounds(0, 60, largura_atual+1, altura_atual-60);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2)-200, 0, 100+1, 28);
            quests.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            janela.repaint();
            janela.revalidate();
		}//em configs parte do funcionamento
		if (e.getSource() == Debito) {
			//
		}if (e.getSource() == Pix) {
			//
		}if (e.getSource() == Credito) {
			//
		}if (e.getSource() == Boleto) {
			//
		}if(e.getSource()==comprovar_meta_diaria){
            //
        }if(e.getSource()==comprovar_meta_semanal){
            //
        }if(e.getSource()==comprovar_meta_mensal){
            //
        }
    }
         // Inicializa o aplicativo
    public static void main(String[] args) {
        new App_mundo_senai();
    }
}
