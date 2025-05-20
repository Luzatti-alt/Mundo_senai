package aa;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class App_mundo_senai extends JFrame implements ActionListener {
    // Componentes globais
    JFrame janela = new JFrame();
    File info = new File("info.txt");
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
	JButton parceiros = new JButton();
	JButton quests = new JButton();
	JButton produtos = new JButton();
	JButton sobre_nos = new JButton();
	JButton configs = new JButton();
	//info contas
	JTextArea ops_assinatura = new JTextArea("Opções de assinatura & conta");
	JTextArea mes = new JTextArea("Mensal");
	JTextArea tres_meses = new JTextArea("3 Meses");
	JTextArea seis_meses = new JTextArea("6 Meses");
	JTextArea doze_meses = new JTextArea("12 Meses");
	JTextArea cinquentao = new JTextArea("R$:");
	JTextArea cento_cinquente= new JTextArea("R$:");
	JTextArea trezentos = new JTextArea("R$: ");
	JTextArea quinhentos_quarenta = new JTextArea("R$:");
	JButton Debito = new JButton("Débito");
	JButton Pix = new JButton("Pix");
	JButton Credito = new JButton("Crédito");
	JButton Boleto = new JButton("Boleto");
	JPanel Info_conta = new JPanel();
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
    JButton comprovar_meta_diaria = new JButton();
    JButton comprovar_meta_semanal = new JButton();
    JButton comprovar_meta_mensal = new JButton();
    //sobre nos
    JTextArea mais_sobre_nos = new JTextArea();
    JTextArea _sobre_nos = new JTextArea("mais sobre nos");
    JTextArea about = new JTextArea("Nossa plataforma tem como prioridade a saude de nossa clientela, por isso, disponibilizamos rotinas de treino \n para cada cliente em específico e que possa ser feito sem o uso de nenhum equipamento como máquinas e pesos.\n" + //
    "Também temos disponível a venda de produtos utilizados para o melhor desempenho em atividades físicas como camisetas esportivas \ne suplementos como creatina, proteina e vitaminas por um preço menor doque o convencional.\r\n" + //
    "Oferecemos também metas diárias e semanais que ao serem cumpridas (comprovantes são necessários) garantem aos nossos\nclientes pontos que podem ser utilizados para adquirir os produtos da nossa loja.\r\n" + //
    "Você pode comprovar o cumprimento destas tarefas com vídeos, fotos, marcapassos, laudos médicos e também por exames realizados\npor profissionais localizados em instituições parceiras do nosso serviço");
    JPanel texto = new JPanel();
    //parceiros

    //loja
    
    //skip se ja tiver uma conta logada do parte do  login
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
					//parte dos menus do app
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
        janela.setMinimumSize(new Dimension(100, 100));
        janela.setSize(new Dimension(1000, 500));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null); 
		//tela colocar info p /login
        box_login.setLayout(null);
        box_login.setBounds(100, 100, 500, 225);
        box_login.setBackground(Color.GRAY);
        usuario_text.setBounds(10, 10, 480, 60);
        usuario_text.setBackground(null);
        usuario_text.setEditable(false);
        usuario_text.setFont(new Font("Arial", Font.PLAIN, 30));
        box_login.add(usuario_text);
        usuario_login.setBounds(10, 50, 480, 40);
        box_login.add(usuario_login);
        senha_text.setBounds(10, 100, 480, 60);
        senha_text.setBackground(null);
        senha_text.setEditable(false);
        senha_text.setFont(new Font("Arial", Font.PLAIN, 30)); 
        box_login.add(senha_text);
        senha_login.setBounds(10, 150, 480, 40); 
        box_login.add(senha_login);
        janela.add(box_login);
        janela.add(criar_conta);
        criar_conta.setFocusable(false);
        criar_conta.setBounds(100, 430, 1000, 100);
        criar_conta.setText("Criar conta");
	    //botões
		janela.add(esqueceu_senha);
		esqueceu_senha.setFocusable(false);
		esqueceu_senha.setBounds(0,0,1350,50);
		esqueceu_senha.setText("esqueceu minha senha");
		esqueceu_senha.addActionListener(this);
        Logar.setText("Logar");
        Logar.setBounds(200, 350, 300, 50);  
        Logar.addActionListener(this);
        janela.add(Logar);
        janela.setVisible(true);
    }
	//menu em cima
    public void Menus(){
	Menu = new JPanel(); // Recria o painel de menu
    Menu.setBackground(Color.white);
    Menu.setBounds(0, 0, 1550, 28);
    Menu.setLayout(null); // Permite posicionamento absoluto
    janela.add(Menu);

    // Produtos
    produtos = new JButton("Produtos");
    produtos.setBounds(0, 0, 100, 28);
    produtos.addActionListener(this);
    Menu.add(produtos);

    // Parceiros
    parceiros = new JButton("Parceiros");
    parceiros.setBounds(100, 0, 100, 28);
    parceiros.addActionListener(this);
    Menu.add(parceiros);

    // Metas (Quests)
    quests = new JButton("Metas");
    quests.setBounds(200, 0, 100, 28);
    quests.addActionListener(this);
    Menu.add(quests);

    // Sobre Nós
    sobre_nos = new JButton("Sobre Nós");
    sobre_nos.setBounds(300, 0, 100, 28);
    sobre_nos.addActionListener(this);
    Menu.add(sobre_nos);

    // Configurações
    configs = new JButton("Configurações");
    configs.setBounds(400, 0, 120, 28);
    configs.addActionListener(this);
    Menu.add(configs);
}
	//resetar elementos
    public void limparJanela(){
    janela.getContentPane().removeAll();
    janela.repaint();
    janela.revalidate();
}
	//pagina info da conta
    public void Info_conta() {
    janela.setTitle("Projeto Mundo Senai: Treina Aí");
    janela.setMinimumSize(new Dimension(100, 100));
    janela.setSize(new Dimension(1000, 500));
    janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    janela.setLayout(null);
    Info_conta.setLayout(null);
	Info_conta.setBackground(Color.lightGray);
	//titulo acima
    janela.add(ops_assinatura);
	ops_assinatura.setEditable(false);
	ops_assinatura.setFont(new Font("Arial", Font.PLAIN, 30));
	ops_assinatura.setBackground(Color.BLUE);
	ops_assinatura.setBounds(0,26,1550,35);
    //infos da conta
    janela.add(Info_conta);
	Info_conta.setBackground(Color.gray);
	Info_conta.setBounds(550,58,1000,1000);
    //mes e valor
	janela.add(mes);
	mes.setEditable(false);
	mes.setFont(new Font("Arial", Font.PLAIN, 26));
	mes.setBounds(100,100,120,50);
	janela.add(tres_meses);
	tres_meses.setEditable(false);
	tres_meses.setFont(new Font("Arial", Font.PLAIN, 26));
	tres_meses.setBounds(100,160,120,50);
	janela.add(seis_meses);
	seis_meses.setEditable(false);
	seis_meses.setFont(new Font("Arial", Font.PLAIN, 26));
	seis_meses.setBounds(100,220,120,50);
	janela.add(doze_meses);
	doze_meses.setEditable(false);
	doze_meses.setFont(new Font("Arial", Font.PLAIN, 26));
	doze_meses.setBounds(100,280,120,50);
	janela.add(cinquentao);
	cinquentao.setEditable(false);
	cinquentao.setFont(new Font("Arial", Font.PLAIN, 26));
	cinquentao.setBounds(250,100,120,50);
	janela.add(cento_cinquente);
	cento_cinquente.setEditable(false);
	cento_cinquente.setFont(new Font("Arial", Font.PLAIN, 26));
	cento_cinquente.setBounds(250,160,120,50);
	janela.add(trezentos);
	trezentos.setEditable(false);
	trezentos.setFont(new Font("Arial", Font.PLAIN, 26));
	trezentos.setBounds(250,220,120,50);
	janela.add(quinhentos_quarenta);
	quinhentos_quarenta.setEditable(false);
	quinhentos_quarenta.setFont(new Font("Arial", Font.PLAIN, 26));
	quinhentos_quarenta.setBounds(250,280,120,50);
	//pagamento
	janela.add(Debito);
	Debito.setFocusable(false);
	Debito.setBounds(100,360,120,50);
	janela.add(Pix);
	Pix.setFocusable(false);
	Pix.setBounds(100,420,120,50);
	janela.add(Credito);
	Credito.setFocusable(false);
	Credito.setBounds(250,360,120,50);
	janela.add(Boleto);
	Boleto.setFocusable(false);
	Boleto.setBounds(250,420,120,50);
	//outros
    janela.getContentPane().setBackground(Color.gray);
    janela.revalidate();
    janela.repaint();
    }
	//pagina de metas
	public void Metas(){
        janela.add(metas_titulo);
        metas_titulo.setEditable(false);
        metas_titulo.setBackground(Color.blue);
        metas_titulo.setBounds(0, 26, 1550, 35);
        metas_titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        janela.add(Sistema_metas);
        Sistema_metas.setBackground(Color.white);
        Sistema_metas.setLayout(new GridLayout(3,1));
        Sistema_metas.setBounds(0,61,1550,400);
        //diarias
        Sistema_metas.add(Meta_diario);
        Meta_diario.add(Metas_diarias_txt);
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
        //trocar o layout
        janela.setLayout(null);
        janela.add(mais_sobre_nos);
        mais_sobre_nos.setBounds(0,27,1550,60);
        mais_sobre_nos.add(_sobre_nos);
        janela.add(about);
        about.setBounds(0,57,1550,1460);
        mais_sobre_nos.setBackground(Color.blue);
        mais_sobre_nos.setEditable(false);
        mais_sobre_nos.setFont(new Font("arial",Font.PLAIN,30));
        mais_sobre_nos.setPreferredSize(new Dimension(1550, 30));
        about.setFont(new Font("arial",Font.PLAIN,26));
    }
    //pagina parceiro
    public void parceiro_page(){
        //
    }
    //pagina loja
    public void loja(){
        //
    }
    // Para o botão funcionar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Logar) {
            System.out.println("Logando...");
			limparJanela();
            Info_conta();
			Menus();
        } else if (e.getSource() == esqueceu_senha) {
            
        }else if (e.getSource() == criar_conta) {
            //
        } else if (e.getSource() == sobre_nos) {
            limparJanela();
            Menus();
            sobre();
        } else if (e.getSource() == produtos) {
            limparJanela();
            Menus();
        } else if (e.getSource() == quests) {
			limparJanela();
			Menus();
            Metas();
        } else if (e.getSource() == parceiros) {
            limparJanela();
            Menus();
        }if(e.getSource()==configs){
			//adicionar pra remover todos os outros itens
            janela.getContentPane().setBackground(Color.gray);
            limparJanela();
			Menus();
            janela.getContentPane().setBackground(Color.gray);
			Info_conta();
		}
		//em configs
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
