import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class App_mundo_senai extends JFrame implements ActionListener{
	//componentes globais
	JFrame janela = new JFrame();
	JButton Logar = new JButton();
	File info = new File("info.txt");

	public void login(){
		//metodo ⬆️ para o sistema de login 

		//adicionar parte do login (salvar em um arquivo txt e sempre que iniciar)
		//ler este arquivo e ver se login foi salvo
		///se sim ja pula este metodo e vai direto pro app
		/// se não manter na tela de login
		/// usar java.io para isso
		/// o resto da funcionalidade em python que o sumida vai fazer
		
		//aspectos da janela
		janela.setTitle("Projeto Mundo Senai: AAAAAAA");
		janela.setMinimumSize(new Dimension(100,100));
		janela.setSize(new Dimension(1000, 500));
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setLayout(null);//definir layout após miguel mandar o desing

		//adicionando o botão de login
		Logar.setFocusable(false);
		Logar.setText("Logar");
		janela.add(Logar);
		Logar.setBounds(100,100,100,100);
		Logar.addActionListener(this);

		//visibilidade de tudo
		janela.setVisible(true);
	}
	public void menu(){
		//metodo ⬆️ para o menu
		janela.setTitle("Projeto Mundo Senai: AAAAAAA");
		janela.setMinimumSize(new Dimension(100,100));
		janela.setSize(new Dimension(1000, 500));
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setLayout(null);
	}
	public App_mundo_senai() {
		//obj ⬆️ para inicializar
		//add save de info de login em info.txt e assim na inicialização
		//se ja tiver informação de login salva pular metodo de login

		//verificar se o arquivo de informações existe
		//cria se não tiver
		if(info.exists()){
            System.out.println("arquivo existente");
        }else{System.out.println("arquivo inexistente");
            try{
                FileWriter novo_arquivo = new FileWriter("info.txt");
                //cria o arquuvo
                novo_arquivo.write("add info de login talvez via pipe");
                novo_arquivo.close();//metodo de fechar o arquivo e salvar 
                //é necessario sair do arquivo para q o conteudo esteja nele
            }catch (IOException e) {
            e.printStackTrace();//sem o catch nn vai funcionar a craição do arquivo
        }}
		//adicionar a verificação de existir um login salvo na máquina
		/*if(){
		Menu();
		}else{
		login();}
		 */
		//temporario ⬇️
		login();
	}
	//para o botão funcionar tem que estar no mesmo arquivo e ser em java
	//sumida esta com a parte do backend mas está parte é do frontend 
	//pois tenho que adicionar a funcionalidade pelo frontend
	//o mesmo pro skip da parte de login se estiver salvo na máquina
	
	//funcionamento do botão
	@Override
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == Logar){
			//apertar botão logar e adicionat condição valido pra fazer isto
			System.out.println("logando");
			janela.remove(Logar);
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
