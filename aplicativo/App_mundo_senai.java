import javax.swing.*;
import java.awt.*;
public class App_mundo_senai extends JFrame{
	public static void main(String[]args) {
		JFrame janela = new JFrame();
		janela.setMinimumSize(new Dimension(100,100));
		janela.setSize(new Dimension(1000, 500));
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}