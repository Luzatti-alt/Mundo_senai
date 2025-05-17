import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class App_mundo_senai extends JFrame implements ActionListener{
	//componentes globais
	JFrame janela = new JFrame();
	JButton Logar = new JButton();

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
	}
	public App_mundo_senai() {
		//obj ⬆️ para inicializar
		//add save de info de login e assim na inicialização
		//se ja tiver informação de login salva pular metodo de login
		
		/*if(){
		Menu();
		}else if(){
		login();}
		 */

		login();
	}
	//para o botão funcionar tem que estar no mesmo arquivo e ser em java
	//sumida esta com a parte do backend mas está parte é do frontend 
	//pois tenho que adicionar a funcionalidade pelo front

	//funcionamento do botão
	@Override
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == Logar){
			//apertar botão logar e adicionat condição valido pra fazer isto
			System.out.println("logando");
			janela.remove(Logar);
			//atualiza/refresh na janela sem isso congela
			//visualmente
			janela.revalidate();
			janela.repaint();
			//muda do parte do login p/a parte principal
		}
	}
	//inicializa o aplicativo
	public static void main(String[]args) {
		new App_mundo_senai();
	}
}
