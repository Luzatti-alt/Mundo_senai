import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class App_mundo_senai extends JFrame implements ActionListener{
	//salvo_sim //skip de login acima(tem que estar em info.txt)
	//componentes globais
	JFrame janela = new JFrame();
	JButton Logar = new JButton();
	File info = new File("info.txt");
	JTextField usuario_login = new JTextField("digite seu usuario");
	JTextField senha_login = new JTextField("digite sua senha");
	JTextArea usuario_text = new JTextArea("");
	JTextArea senha_text = new JTextArea("");
	JPanel box_login = new JPanel();
	JPanel Deco = new JPanel();//painel onde ficara a parte visial do Login
	JPanel dados = new JPanel();//painel para por infos para Logar

	//código do aplicativo
	public App_mundo_senai() {
		//obj ⬆️ para inicializar
		//add save de info de login em info.txt e assim na inicialização
		//verificar se o arquivo de informações existe cria se não tiver
		if(info.exists()){
            System.out.println("arquivo existente");
        }else{
			System.out.println("arquivo inexistente");
            try{
                FileWriter info = new FileWriter("info.txt");
                //cria o arquuvo
                info.write("add info de login talvez via pipe");//na parte com o server
                info.close();//metodo de fechar o arquivo e salvar 
                //é necessario sair do arquivo para q o conteudo esteja nele
            }catch (IOException e) {
            e.printStackTrace();//sem o catch nn vai funcionar a craição do arquivo
        }}
		//se ja tiver informação de login salva pular metodo de login
			String validador_login = "salvo_sim";
			//palavra no arquivo que se está lá ja pula pra página principal
			try {
            BufferedReader leitor = new BufferedReader(new FileReader(info));
            String linha;
			//o login_state tem que estar na primeira linha
            while ((linha = leitor.readLine()) != null) {
                if (linha.equals(validador_login)) {
					menu();
                    break; 
                }else{
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
		janela.setTitle("Projeto Mundo Senai: AAAAAAA");
		janela.setMinimumSize(new Dimension(100,100));
		janela.setSize(new Dimension(1000, 500));
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setLayout(null);
		//aspectos da janela 
		janela.add(box_login);
		box_login.setBackground(Color.gray);
		box_login.setBounds(100,100,500,500);
		box_login.add(usuario_text);
		box_login.add(usuario_login);
		box_login.add(senha_text);
		box_login.add(senha_login);
		janela.add(Deco);
		//onde fica as informações p/Login
		janela.add(Logar);
		//Logar.setBounds();
		//criar metodo que centralize em x conforme tamanho horizontal da tela
		//configurando o tamanho
		Logar.setFocusable(false);
		Logar.setText("Logar");
		Logar.setSize(100,100);
		Logar.addActionListener(this);
		//visibilidade de tudo
		janela.setVisible(true);
	}
a
	public void menu(){
		//metodo ⬆️ para o menu
		//aspectos da janela 
		janela.setTitle("Projeto Mundo Senai: AAAAAAA");
		janela.setMinimumSize(new Dimension(100,100));
		janela.setSize(new Dimension(1000, 500));
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.getContentPane().removeAll();
		// reset layout e background
		janela.getContentPane().setBackground(Color.BLACK);
		janela.setLayout(null);//trocar qnd desing for enviado
		// reseta a janela
		janela.revalidate();
		janela.repaint();
	}

	//para o botão funcionar tem que estar no mesmo arquivo e ser em java sumida esta com a parte do backend mas está parte é do frontend 
	//pois tenho que adicionar a funcionalidade pelo frontend o mesmo pro skip da parte de login se estiver salvo na máquina funcionamento do botão
	//funcionamento de botões
	@Override
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == Logar){
			//apertar botão logar e adicionat condição valido pra fazer isto
			System.out.println("logando");
			janela.remove(box_login);
			janela.remove(Logar);
			janela.getContentPane().setBackground(Color.BLACK);
			//atualiza/refresh na janela sem isso congela(visualmente) o botão
			janela.revalidate();
			janela.repaint();
			//dos ir pro menu
			menu();
		}
	}

	//inicializa o aplicativo
	public static void main(String[]args) {
		new App_mundo_senai();
	}
}
