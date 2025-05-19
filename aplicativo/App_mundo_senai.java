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
	JPanel Info_conta = new JPanel();
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
	//skip se ja tiver uma conta logada do parte do  login
    public App_mundo_senai() {
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
    public void login() {
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
	public void Menus() {
    Menu = new JPanel(); // Recria o painel de menu
    Menu.setBackground(Color.white);
    Menu.setBounds(0, 0, 1290, 28);
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

	//pagina info da conta
    public void Info_conta() {
        janela.setTitle("Projeto Mundo Senai: Treina Aí");
        janela.setMinimumSize(new Dimension(100, 100));
        janela.setSize(new Dimension(1000, 500));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null);
	Menu.setBackground(Color.white);
	Menu.setBounds(0,0,1290,28);
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
	//titulo acima
	ops_assinatura.setEditable(false);
	ops_assinatura.setFont(new Font("Arial", Font.PLAIN, 30));
	ops_assinatura.setBackground(Color.BLUE);
	ops_assinatura.setBounds(0,28,1290,30);
	//infos da conta
	janela.add(ops_assinatura);
	Info_conta.setLayout(new GridLayout());
	janela.add(Info_conta);
	Info_conta.setBackground(Color.gray);
	Info_conta.setBounds(690,0,300,600);
	//outros
        janela.getContentPane().setBackground(Color.BLACK);
        janela.setLayout(null); 
        janela.revalidate();
        janela.repaint();
    }
	//outra pagina
	public void Metas(){
		//
	}
    // Para o botão funcionar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Logar) {
            System.out.println("Logando...");
			janela.getContentPane().removeAll();
			Menus();
			Info_conta();
			janela.revalidate();
			janela.repaint();
        }if(e.getSource()==esqueceu_senha){
			//
		}if(e.getSource()==sobre_nos){
			//
			janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
			janela.getContentPane().removeAll();
			Menus();
            janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
		}if(e.getSource()==produtos){
			//
			janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
			janela.getContentPane().removeAll();
			Menus();
            janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
		}if(e.getSource()==quests){
			janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
			janela.getContentPane().removeAll();
			Menus();
            janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
			Metas();
		}if(e.getSource()==parceiros){
			//quests
			janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
			janela.getContentPane().removeAll();
			Menus();
            janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
		}if(e.getSource()==configs){
			//adicionar pra remover todos os outros itens
            janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
			janela.getContentPane().removeAll();
			Menus();
            janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
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
		}
    }
    // Inicializa o aplicativo
    public static void main(String[] args) {
        new App_mundo_senai();
    }
}
