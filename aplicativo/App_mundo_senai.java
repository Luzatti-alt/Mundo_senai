import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class App_mundo_senai extends JFrame implements ActionListener, AdjustmentListener {
    JPanel tela_configs = new JPanel();
    //adjustamentlistener usado no scroll bar
    JPanel Top_ui = new JPanel();
    //ImageIcon nome = new ImageIcon(path);
    //imagem tem que estar numa mesma pasta que src/código esta se o codigo esta numa parte e a img tbm vai dar erro
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
    JFrame janela = new JFrame();
    File info = new File("info.txt");
    JScrollBar scroll_bar = new JScrollBar();//add em loja e carrinho
    Dimension tamanho_tela = Toolkit.getDefaultToolkit().getScreenSize();
    int largura_atual = janela.getWidth();  
    int altura_atual = janela.getHeight();
    JTextArea titulo = new JTextArea();
    JPanel dados_pagamento = new JPanel();
    JPanel conta = new JPanel();
    JPanel fundo = new JPanel();
    JPanel box_login = new JPanel();
    JButton parceiros = new JButton("Parceiros");
	JButton quests = new JButton("Metas");
	JButton produtos = new JButton("Produtos");
	JButton sobre_nos = new JButton("Sobre nos");
	JButton configs = new JButton("Configurações");
    JButton Logar = new JButton();
	JButton esqueceu_senha = new JButton();
	JButton criar_conta = new JButton();
    JButton Debito = new JButton("Débito");
	JButton Pix = new JButton("Pix");
	JButton Credito = new JButton("Crédito");
	JButton Boleto = new JButton("Boleto");
    JButton comprovar_meta_diaria = new JButton("Comprovar meta");
    JButton comprovar_meta_semanal = new JButton("Comprovar meta");
    JButton comprovar_meta_mensal = new JButton("Comprovar meta");
    JButton Carrinho_bot = new JButton("carrinho");
    JButton criar_nova_conta_botao = new JButton("Criar conta");
    JButton dinheiro = new JButton("Comprar");
    JButton volte = new JButton("voltar");
    JButton vid = new JButton("Vídeo");
    JButton laudo = new JButton("Laudo médico");
    JButton cons_profi = new JButton("Confirmação profisional parceiro da plataforma");
    //componentes abaixo podem ser alterados ou substituidos //menos os JButtons por conta de como funcionam
	JTextField usuario_login = new JTextField();
	JTextField senha_login = new JTextField();
    JTextArea usuario_text = new JTextArea("Usuario");
	JTextArea senha_text = new JTextArea("Senha");
	JPanel Menu = new JPanel();
    JPanel Sistema_metas = new JPanel();
	//info contas
    JPanel cont_tela = new JPanel();
    JTextArea nome_txt = new JTextArea("Usuario");
    JPanel nome = new JPanel();
    JPanel tipo_assinatura = new JPanel();
    JTextArea  tipo_assinatura_txt = new JTextArea("Assinatura");
    JPanel data_cria_conta = new JPanel();
    JTextArea data_cria_conta_txt = new JTextArea("Data da criação da conta");
     //dados da assinatura escolha
	JTextArea mes = new JTextArea("Mensal");
	JTextArea tres_meses = new JTextArea("3 Meses");
	JTextArea seis_meses = new JTextArea("6 Meses");
	JTextArea doze_meses = new JTextArea("12 Meses");
	JTextArea cinquentao = new JTextArea("R$:49,99");
	JTextArea cento_cinquente= new JTextArea("R$:97,99");
	JTextArea trezentos = new JTextArea("R$:152,99");
	JTextArea quinhentos_quarenta = new JTextArea("R$:273,99");
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
    //sobre nos
    JTextArea mais_sobre_nos = new JTextArea();
    JTextArea about = new JTextArea(
    "Nossa plataforma tem como prioridade a saúde de nossos clientes.\n" +
    "Por isso, disponibilizamos rotinas de treino personalizadas para cada cliente,\n" +
    "que podem ser feitas sem o uso de equipamentos como máquinas e pesos.\n\n" +
    "Também oferecemos a venda de produtos voltados para o melhor desempenho em atividades físicas,\n" +
    "como camisetas esportivas e suplementos (creatina, proteína e vitaminas) por preços acessíveis.\n\n" +
    "Oferecemos metas diárias e semanais. Ao serem cumpridas (com comprovação),\n" +
    "os clientes ganham pontos que podem ser utilizados para adquirir produtos em nossa loja.\n" +
    "Você pode comprovar o cumprimento das tarefas com vídeos, fotos, marcapassos, laudos médicos\n" +
    "ou exames realizados por profissionais de instituições parceiras do nosso serviço.\n\n" +
    "Catálogo de Recompensas por Pontos:\n" +
    "1. Produtos Fitness (Físicos):\n" +
    " - Garrafa térmica personalizada – Mantém a bebida gelada e vem com o nome do usuário.\n" +
    " - Camiseta de treino – Respirável, com frases motivacionais.\n" +
    " - Faixa elástica & corda de pular – Ideais para treinos em casa e cardio.\n" +
    " - Toalha & shaker – Práticos e com a marca do app.\n" +
    " - Bandagens/luvas & mochila esportiva – Proteção e estilo na academia.\n\n" +
    "2. Vantagens no App:\n" +
    " - Acesso Premium (7 ou 30 dias) – Funções exclusivas liberadas.\n" +
    " - Treino personalizado com IA – Adaptado ao seu objetivo.\n" +
    " - Avaliação de progresso avançada – Gráficos e comparações.\n" +
    " - Missões exclusivas com bônus – Ganhe mais pontos!\n\n" +
    "3. Itens Virtuais & Motivacionais:\n" +
    " - Medalhas & troféus digitais – Reconhecimento por conquistas.\n" +
    " - Papéis de parede & avatares customizados – Personalização visual.\n\n" +
    "4. Parcerias & Cupons:\n" +
    " - Descontos em lojas de suplemento.\n" +
    " - Aulas em academias (spinning, yoga etc.).\n" +
    " - Consultorias com nutricionistas ou personal trainers (online).\n\n" +
    "Extras e Gamificação:\n" +
    " - Recompensas por nível: iniciante, intermediário, avançado.\n" +
    " - Sistema de raridade: comum, raro, épico.\n" +
    " - Resgates via baús surpresa e missões especiais."
);
    //parceiros
    JPanel parça = new JPanel();
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
    JTextField pesquisa = new JTextField("pesquise aqui o seu produto");
    JTextArea pontuacao = new JTextArea("Pontos");
    //criar conta
    JPanel conta_criando = new JPanel();
    JTextArea nome_conta = new JTextArea("digite seu nome: ");
    JTextField entrar_nome = new JTextField();
    JTextArea email = new JTextArea("digite seu email:");
    JTextField entrar_email = new JTextField();
    JTextArea senha_criar = new JTextArea("digite sua senha:");
    JTextField entrar_senha_criando = new JTextField();
    JTextArea confirmar_senha = new JTextArea("confirme sua senha:");
    JTextField entrar_confirma_senha = new JTextField();
    //descrição
    JPanel item = new JPanel();
    JPanel desc = new JPanel();
    //carrinho
    JTextArea valor_a_pagar = new JTextArea("Total a pagar: ");
    //temporario
    JButton temp = new JButton();
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
                    janela.setSize(new Dimension(700, 700));
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
    public void login(){
        janela.setTitle("Projeto Mundo Senai: Treina Aí");
        janela.setMinimumSize(new Dimension(600, 300));
        janela.setSize(new Dimension(700, 700));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null); 
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
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
		janela.add(esqueceu_senha);
        esqueceu_senha.setBackground(new Color(122,159,125));
		esqueceu_senha.setFocusable(false);
		esqueceu_senha.setText("esqueceu sua senha");
		esqueceu_senha.addActionListener(this);
        Logar.setText("Logar");
        criar_conta.addActionListener(this);
        Logar.setBackground(new Color(122,159,125));
        Logar.addActionListener(this);
        janela.add(Logar);
        janela.setVisible(true);
    }
    public void limparJanela(){
        janela.getContentPane().removeAll();
        janela.repaint();
        janela.revalidate();
        }
    public void Info_conta() {
        //definindo janela
        janela.add(Menu);
        janela.add(titulo);
        titulo.setText("Opções de assinatura & conta");
        janela.add(cont_tela);
        janela.setMinimumSize(new Dimension(600, 300));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.add(tela_configs);
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
        cont_tela.add(conta);
        cont_tela.add(dados_pagamento);
        cont_tela.setLayout(new GridLayout(1,2));
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        tela_configs.setBounds(0, 0, largura_atual, 28);
        titulo.setBounds(0,29,largura_atual,35);
        cont_tela.setBounds(0, 64, largura_atual, altura_atual-64);
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2)+100, 0, 100, 28);
        quests.setBounds((largura_atual/2), 0, 100, 28);
        sobre_nos.setBounds(0,300,largura_atual/2,30);
    }
    });
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        produtos.setIcon(Loja_icon);
        titulo.setEditable(false);
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        titulo.setBackground(new Color(61, 153, 32));
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
        janela.getContentPane().setBackground(Color.white);
        janela.revalidate();
        janela.repaint();
        janela.setVisible(true);
        }
	public void Metas(){
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
        parceiros.setBounds((largura_atual/2), 0, 100+1, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
        titulo.setBounds(0, 26, largura_atual+1, 35);
        Sistema_metas.setBounds(0,60,largura_atual+1,altura_atual-63);
    }
    }); 
        janela.add(produtos);
        janela.add(parceiros);
        janela.add(configs);
        janela.add(titulo);
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        produtos.setIcon(Loja_icon);
        quests.setIcon(Metas_icon);
        titulo.setText("Metas");
        titulo.setEditable(false);
        titulo.setBackground(new Color(61, 153, 32));//new Color(61, 153, 32)
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        janela.add(Sistema_metas);
        Sistema_metas.setBackground(Color.white);
        Sistema_metas.setLayout(new GridLayout(3,1));
        //diariasx
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
    public void sobre(){
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2), 0, 100, 28);
        quests.setBounds((largura_atual/2)-200, 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        titulo.setBounds(0,26,largura_atual,35);
        about.setBounds(0,62,largura_atual,1460);
        about.setFont(new Font("arial",Font.PLAIN,altura_atual/55));
    }
    });
    janela.add(produtos);
    janela.add(parceiros);
    janela.add(quests);
    janela.add(configs);
    produtos.setIcon(Loja_icon);
    janela.setLayout(null);
    janela.add(titulo);
    titulo.setText("Mais sobre nós");
    janela.add(titulo);
    titulo.setEditable(false);
    titulo.setFont(new Font("arial",Font.PLAIN,30));
    mais_sobre_nos.setBounds(0,27,1550, 30);
    janela.add(about);
    about.setEditable(false);
    about.setBackground(new Color(200, 255, 206));
    titulo.setBackground(new Color(61, 153, 32));
    mais_sobre_nos.setEditable(false);
    mais_sobre_nos.setFont(new Font("arial",Font.PLAIN,30));
    mais_sobre_nos.setPreferredSize(new Dimension(1550, 30));
    }
    public void parceiro_page(){
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        quests.setBounds((largura_atual/2), 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        titulo.setBounds(0, 26, largura_atual, 35);
        fundo.setBounds(0,60,largura_atual,altura_atual-63);
        titulo.setBounds(0,26,largura_atual,35);
        parça.setBounds(0, 61, largura_atual, 1000);
    }
    }); 
        titulo.setText("Instituições parceiras");
        janela.add(produtos);
        janela.add(quests);
        janela.add(configs);
        janela.add(titulo);
        janela.add(parça);
        produtos.setIcon(Loja_icon);
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        parça.setBounds(0, 61, largura_atual, 1000);
        parça.setBackground(Color.lightGray);
        janela.add(titulo);
        titulo.setBackground(new Color(61, 153, 32));
        titulo.setEditable(false);
        titulo.setFont(new Font("arial",Font.PLAIN,30));
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
    public void Criar_nova_conta(){
        janela.add(criar_nova_conta_botao);
        janela.add(conta_criando);
        conta_criando.setBackground(Color.lightGray);
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        criar_nova_conta_botao.setBounds(0,altura_atual-200,largura_atual,50);
        conta_criando.setBounds((largura_atual/3)-50, 100, (largura_atual/2), altura_atual/2);
    }
    });
    conta_criando.setLayout(new GridLayout(8,1));//nome email senha confirma_senha
    conta_criando.add(nome_conta);
    nome_conta.setEditable(false);
    conta_criando.add(entrar_nome);
    nome_conta.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(email);
    email.setEditable(false);
    email.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_email);
    conta_criando.add(senha_criar);
    senha_criar.setEditable(false);
    senha_criar.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_senha_criando);
    conta_criando.add(confirmar_senha);
    confirmar_senha.setEditable(false);
    confirmar_senha.setFont(new Font("Arial", Font.PLAIN, 30));
    conta_criando.add(entrar_confirma_senha);
    criar_nova_conta_botao.setBackground(Color.green);
    }
    public void loja(){
        janela.add(temp);
        temp.addActionListener(this);
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        scroll_bar.setBounds(0,90,largura_atual/15,altura_atual-90);
        temp.setBounds((largura_atual/2)+200, 500, 100, 30);
        produtos.setBounds((largura_atual/2)-100, 0, 100, 30);
        parceiros.setBounds((largura_atual/2)+300, 0, 100, 30);
        quests.setBounds((largura_atual/2), 0, 100, 30);
        configs.setBounds((largura_atual/2)+100, 0, 100, 30);
        pesquisa.setBounds(0,90,largura_atual,30);
        pontuacao.setBounds(largura_atual/2,60,largura_atual/2,30);
        Carrinho_bot.setBounds(0,60,largura_atual/2,30);
        titulo.setBounds(0,30,largura_atual,30);
    }
    });
        janela.add(produtos);
        janela.add(quests);
        janela.add(configs);
        janela.add(titulo);
        produtos.setIcon(Loja_icon);
        janela.add(Carrinho_bot);
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        Carrinho_bot.setIcon(Carrinho_icon);
        janela.add(titulo);
        titulo.setEditable(false);
        titulo.setText("Produtos a venda");
        titulo.setBackground(Color.green);
        Carrinho_bot.addActionListener(this);
        janela.add(pesquisa);
        janela.add(pontuacao);
        fundo.setBackground(Color.blue);
        janela.add(scroll_bar);
        scroll_bar.addAdjustmentListener(this);
        pontuacao.setEditable(false);
    }
    public void carrinho(){
        //arrumar qnd vai a esta parte
        configs.setIcon(Config_icon);
        parceiros.setIcon(Parca_icon);
        quests.setIcon(Metas_icon);
        produtos.setIcon(Loja_icon);
        Carrinho_bot.setIcon(Carrinho_icon);
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
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
        janela.add(produtos);
        janela.add(parceiros);
        janela.add(quests);
        janela.add(configs);
        janela.add(titulo);
        janela.add(fundo);
        fundo.setBackground(Color.LIGHT_GRAY);
        janela.add(valor_a_pagar);
        valor_a_pagar.setBackground(Color.green);
        valor_a_pagar.setFont(new Font("Arial", Font.PLAIN, 56));
        janela.add(volte);
        janela.add(dinheiro);
        titulo.setBackground(Color.green);
        titulo.setText("carrinho");
    }
    public void comprove(){
        janela.add(titulo);
        titulo.setText("Métodos de comprovantes");
        titulo.setBackground(Color.green);
        janela.getContentPane().setBackground(Color.lightGray);
        janela.add(vid);
        vid.setBackground(Color.green);
        janela.add(laudo);
        laudo.setBackground(Color.green);
        janela.add(cons_profi);
        cons_profi.setBackground(Color.green);
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
        titulo.setBounds(0,30,largura_atual,30);
        fundo.setBounds(0,60,largura_atual,altura_atual-60);
        vid.setBounds(100,altura_atual-500,largura_atual/2,50);
        laudo.setBounds(100,altura_atual-400,largura_atual/2,50);
        cons_profi.setBounds(100,altura_atual-300,largura_atual/2,50);
    }
    });
    }
    public void descricao(){
        //add funcionalidade para produtos especificos
        janela.add(produtos);
        janela.add(quests);
        janela.add(configs);
        janela.add(titulo);
        janela.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = janela.getWidth();
        int altura_atual = janela.getHeight();
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
        janela.add(item);
        volte.addActionListener(this);
        item.setBackground(Color.lightGray);
        //item.add();//imagem do item
        janela.add(desc);
        desc.setBackground(Color.gray);
        //desc.add();//descrição do produto
        janela.add(dinheiro);
        janela.add(titulo);
        titulo.setBackground(Color.green);
        titulo.setText("Descrição do produto");
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        titulo.setEditable(false);
        janela.add(volte);
    }
    //funcionamento de scrollbar
    @Override
    public void adjustmentValueChanged(AdjustmentEvent arg0){
        System.out.println("scrollbar: "+scroll_bar.getValue());
        //criar o efeito de scroll
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Logar) {
			limparJanela();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            Info_conta();
            janela.setSize(largura_atual+1,altura_atual);
            tela_configs.setBounds(0, 0, largura_atual+1, 28);
            titulo.setBounds(0,24,largura_atual+1,35);
            cont_tela.setBounds(0, 60, largura_atual+1, altura_atual-60);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            quests.setBounds((largura_atual/2), 0, 100+1, 28);
        } else if (e.getSource() == esqueceu_senha) {
            //
        }else if (e.getSource() == criar_conta) {
            limparJanela();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            System.out.println("largura: "+largura_atual);
            System.out.println("altura: "+altura_atual);
            criar_nova_conta_botao.setBounds(0,altura_atual-200,largura_atual,50);
            conta_criando.setBounds((largura_atual/3)-50, 100, (largura_atual/2), altura_atual/2);
            Criar_nova_conta();
        } else if (e.getSource() == sobre_nos) {
            limparJanela();
            sobre();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
            System.out.println("largura: "+largura_atual);
            System.out.println("altura: "+altura_atual);
            janela.setSize(largura_atual+1,altura_atual);
            quests.setBounds((largura_atual/2)-200, 0, 100+1, 28);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
        } else if (e.getSource() == produtos) {
            limparJanela();
            loja();
            int largura_atual = janela.getWidth();  
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2)-200, 0, 100+1, 28);
            quests.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            pesquisa.setBounds(0,90,(largura_atual)+1,30);
            titulo.setBounds(0,30,largura_atual+1,30);
            pontuacao.setBounds(largura_atual/2,60,(largura_atual/2)+1,30);
            Carrinho_bot.setBounds(0,60,(largura_atual/2)+1,30);
            scroll_bar.setBounds(0,90,(largura_atual)-largura_atual/15,altura_atual-90);
            //temporario
            temp.setBounds((largura_atual/2)-100, 500, 100+1, 30);
        } else if (e.getSource() == quests) {
			limparJanela();
            int largura_atual = janela.getWidth(); 
            int altura_atual = janela.getHeight();
            Metas();
            janela.setSize(largura_atual+1,altura_atual);
            Sistema_metas.setBounds(0,60,largura_atual+1,altura_atual-63);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            titulo.setBounds(0, 26, largura_atual+1, 35);
            fundo.setBounds(0,60,largura_atual+1,altura_atual);
        } else if (e.getSource() == parceiros) {
            limparJanela();
            int largura_atual = janela.getWidth();  
            parceiro_page();
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            quests.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
            titulo.setBounds(0,26,largura_atual+1,35);
            parça.setBounds(0, 61, largura_atual+1, 1000);
        }if(e.getSource()==configs){
            limparJanela();
            int largura_atual = janela.getWidth();  
            int altura_atual = janela.getHeight();
			Info_conta();
            janela.setSize(largura_atual+1,altura_atual);
            tela_configs.setBounds(0, 0, largura_atual+1, 28);
            titulo.setBounds(0,24,largura_atual+1,35);
            cont_tela.setBounds(0, 60, largura_atual+1, altura_atual-60);
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 28);
            parceiros.setBounds((largura_atual/2)-200, 0, 100+1, 28);
            quests.setBounds((largura_atual/2), 0, 100+1, 28);
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 28);
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
            limparJanela();
            comprove();
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            titulo.setBounds(0,30,largura_atual,30);
            vid.setBounds(100,altura_atual-500,largura_atual/2,50);
            laudo.setBounds(100,altura_atual-400,largura_atual/2,50);
            cons_profi.setBounds(100,altura_atual-300,largura_atual/2,50);
        }if(e.getSource()==comprovar_meta_semanal){
            limparJanela();
            comprove();
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            titulo.setBounds(0,30,largura_atual,30);
            vid.setBounds(100,altura_atual-500,largura_atual/2,50);
            laudo.setBounds(100,altura_atual-400,largura_atual/2,50);
            cons_profi.setBounds(100,altura_atual-300,largura_atual/2,50);
        }if(e.getSource()==comprovar_meta_mensal){
            limparJanela();
            comprove();
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            titulo.setBounds(0,30,largura_atual,30);
            vid.setBounds(100,altura_atual-500,largura_atual/2,50);
            laudo.setBounds(100,altura_atual-400,largura_atual/2,50);
            cons_profi.setBounds(100,altura_atual-300,largura_atual/2,50);
        }if(e.getSource()==Carrinho_bot){
            limparJanela();
            carrinho();
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            produtos.setBounds((largura_atual/2)-100, 0, 100+1, 30);
            parceiros.setBounds((largura_atual/2)-200, 0, 100+1, 30);
            quests.setBounds((largura_atual/2), 0, 100+1, 30);//+1
            configs.setBounds((largura_atual/2)+100, 0, 100+1, 30);
            titulo.setBounds(0, 31, largura_atual+1, 30);
            volte.setBounds(0,altura_atual-100,largura_atual+1,60);
            dinheiro.setBounds(0,altura_atual-175,largura_atual+1,60);
            valor_a_pagar.setBounds(0, altura_atual-250, largura_atual+1, 60);
            scroll_bar.setBounds(0,90,largura_atual/15+1,altura_atual-90);
            janela.repaint();
            janela.revalidate();
        }if(e.getSource()==temp){
            limparJanela();
            descricao();
            int largura_atual = janela.getWidth();
            int altura_atual = janela.getHeight();
            produtos.setBounds((largura_atual/2)-100, 0, 100, 30);
            parceiros.setBounds((largura_atual/2)-200, 0, 100, 30);
            quests.setBounds((largura_atual/2), 0, 100, 30);
            configs.setBounds((largura_atual/2)+100, 0, 100, 30);
            item.setBounds(50,80,largura_atual/2-50,altura_atual/2);
            desc.setBounds(largura_atual/2+50,80,largura_atual/2-100,altura_atual/2);
            titulo.setBounds(0,30,largura_atual,30);
            dinheiro.setBounds(0,altura_atual-200,largura_atual,60);
            volte.setBounds(0,altura_atual-100,largura_atual,60);
            janela.repaint();
            janela.revalidate();
        }else if(e.getSource()==volte){
        limparJanela();
        loja();}
    }
    public static void main(String[] args) {
        new App_mundo_senai();
    }
}
