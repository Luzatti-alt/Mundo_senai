import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class App_mundo_senai extends JFrame implements ActionListener, AdjustmentListener {
    // adjustamentlistener usado no scroll bar
    JFrame janela = new JFrame();
    File info = new File("info.txt");
    JScrollBar scroll_bar = new JScrollBar();// add em loja e carrinho
    int largura_atual = this.getWidth();
    int altura_atual = this.getHeight();
    public App_mundo_senai() {
        if (info.exists()) {
        } else {
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
                    Configuracoes configuracoesPanel = new Configuracoes();
                    this.setContentPane(configuracoesPanel);
                    this.setSize(new Dimension(700, 700));
                    this.setVisible(true);
                    break;
                } else {
                    Login logando = new Login();
                    this.setContentPane(logando);
                    this.setSize(new Dimension(700, 700));
                    this.setVisible(true);
                    break;
                }
            }
            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // funcionamento de scrollbar
    @Override
    public void adjustmentValueChanged(AdjustmentEvent arg0) {
        System.out.println("scrollbar: " + scroll_bar.getValue());
    }
    @Override
public void actionPerformed(ActionEvent e) {
    // Lógica a ser executada quando uma ação ocorrer
    System.out.println("Ação realizada: " + e.getActionCommand());
}
    public static void main(String[] args) {
        new App_mundo_senai();
    }
}
