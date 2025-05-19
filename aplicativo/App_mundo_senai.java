import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class App_mundo_senai extends JFrame implements ActionListener {
    // Componentes globais
    JFrame janela = new JFrame();
    JButton Logar = new JButton();
    File info = new File("info.txt");
	//login
    JTextField usuario_login = new JTextField();
    JTextField senha_login = new JTextField();
    JTextArea usuario_text = new JTextArea("Usuario");
    JTextArea senha_text = new JTextArea("Senha");
    JPanel box_login = new JPanel();
	JPanel inv = new JPanel();
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
	// Código do aplicativo
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
    public void login() {
        janela.setTitle("Projeto Mundo Senai: Treina Aí");
        janela.setMinimumSize(new Dimension(100, 100));
        janela.setSize(new Dimension(1000, 500));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null); 
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
        Logar.setText("Logar");
        Logar.setBounds(200, 350, 300, 50);  
        Logar.addActionListener(this);
        janela.add(Logar);
        janela.setVisible(true);
    }

    public void Info_conta() {
        janela.setTitle("Projeto Mundo Senai: Treina Aí");
        janela.setMinimumSize(new Dimension(100, 100));
        janela.setSize(new Dimension(1000, 500));
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        janela.setLayout(null);
		inv.setBackground(Color.white);
		inv.setBounds(0,0,1290,30);
		inv.setLayout(new GridLayout(1,5));
		janela.add(inv);
		janela.add(mes);
		mes.setBounds(100,100,120,50);
		janela.add(tres_meses);

		tres_meses.setBounds(100,160,120,50);
		janela.add(seis_meses);

		seis_meses.setBounds(100,220,120,50);
		janela.add(doze_meses);

		doze_meses.setBounds(100,280,120,50);
		janela.add(cinquentao);

		cinquentao.setBounds(250,100,120,50);
		janela.add(cento_cinquente);

		cento_cinquente.setBounds(250,160,120,50);
		janela.add(trezentos);

		trezentos.setBounds(250,220,120,50);
		janela.add(quinhentos_quarenta);

		quinhentos_quarenta.setBounds(250,280,120,50);

		ops_assinatura.setEditable(false);
		ops_assinatura.setFont(new Font("Arial", Font.PLAIN, 20));
		ops_assinatura.setBackground(Color.BLUE);
		ops_assinatura.setBounds(0,31,1290,20);
		janela.add(ops_assinatura);
        janela.getContentPane().setBackground(Color.BLACK);
        janela.setLayout(null); 
        janela.revalidate();
        janela.repaint();
    }
    // Para o botão funcionar
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Logar) {
            System.out.println("Logando...");
            janela.remove(box_login);
            janela.remove(Logar);
            janela.getContentPane().setBackground(Color.BLACK);
            janela.revalidate();
            janela.repaint();
            Info_conta();
        }
    }
    // Inicializa o aplicativo
    public static void main(String[] args) {
        new App_mundo_senai();
    }
}
