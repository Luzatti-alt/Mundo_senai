import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Sobre extends JPanel implements ActionListener, ComponentListener{
    int largura_atual = this.getWidth();
    int altura_atual = this.getHeight();
    ImageIcon carrinho_original = new ImageIcon(getClass().getResource("imagens/Carrinho-removebg.png"));
    Image carrinho_img = carrinho_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Carrinho_icon = new ImageIcon(carrinho_img);
    ImageIcon Config_original = new ImageIcon(getClass().getResource("imagens/Configs-removebg.png"));
    Image Config_img = Config_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Config_icon = new ImageIcon(Config_img);
    ImageIcon Metas_original = new ImageIcon(getClass().getResource("imagens/Metas-removebg.png"));
    Image Metas_img = Metas_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Metas_icon = new ImageIcon(Metas_img);
    ImageIcon Parca_original = new ImageIcon(getClass().getResource("imagens/Parceiros-removebg.png"));
    Image Parca_img = Parca_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Parca_icon = new ImageIcon(Parca_img);
    ImageIcon Loja_original = new ImageIcon(getClass().getResource("imagens/logo_loja.png"));
    Image Loja_img = Loja_original.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    ImageIcon Loja_icon = new ImageIcon(Loja_img);
    JTextArea titulo = new JTextArea();
    JButton produtos = new JButton("Produtos");
    JButton quests = new JButton("Metas");
    JButton parceiros = new JButton("Parceiros");
	JButton configs = new JButton("Configurações");
    JTextArea mais_sobre_nos = new JTextArea();
    JTextArea about = new JTextArea(
    "Nossa plataforma tem como prioridade a saúde de nossos clientes.\n Por isso, disponibilizamos rotinas de treino personalizadas para cada cliente,\n" + "que podem ser feitas sem o uso de equipamentos como máquinas e pesos.\n" +
    "Também oferecemos a venda de produtos voltados para o melhor desempenho em atividades físicas,\n como camisetas esportivas e suplementos (creatina, proteína e vitaminas) por preços acessíveis.\n" +
    "Oferecemos metas diárias e semanais. Ao serem cumpridas (com comprovação),\n os clientes ganham pontos que podem ser utilizados para adquirir produtos em nossa loja.\n" +
    "Você pode comprovar o cumprimento das tarefas com vídeos, fotos, marcapassos, laudos médicos\n ou exames realizados por profissionais de instituições parceiras do nosso serviço.\n Catálogo de Recompensas por Pontos:\n" + 
    "1. Produtos Fitness (Físicos):\n - Garrafa térmica personalizada – Mantém a bebida gelada e vem com o nome do usuário.\n - Camiseta de treino – Respirável, com frases motivacionais.\n - Faixa elástica & corda de pular – Ideais para treinos em casa e cardio.\n - Toalha & shaker – Práticos e com a marca do app.\n" + " - Bandagens/luvas & mochila esportiva – Proteção e estilo na academia.\n\n" +
    "2. Vantagens no App:\n - Acesso Premium (7 ou 30 dias) – Funções exclusivas liberadas.\n - Treino personalizado com IA – Adaptado ao seu objetivo.\n - Avaliação de progresso avançada – Gráficos e comparações.\n - Missões exclusivas com bônus – Ganhe mais pontos!\n" +
    "3. Itens Virtuais & Motivacionais:\n - Medalhas & troféus digitais – Reconhecimento por conquistas.\n - Papéis de parede & avatares customizados – Personalização visual.\n" +
    "4. Parcerias & Cupons:\n - Descontos em lojas de suplemento.\n - Aulas em academias (spinning, yoga etc.).\n - Consultorias com nutricionistas ou personal trainers (online).\n Extras e Gamificação:\n - Recompensas por nível: iniciante, intermediário, avançado.\n - Sistema de raridade: comum, raro, épico.\n - Resgates via baús surpresa e missões especiais."
);
public Sobre() {
        sobre();
        this.addComponentListener(this);
    }
    public void sobre(){
    this.setLayout(null);
    this.add(produtos);
    this.add(parceiros);
    this.add(quests);
    this.add(configs);
    produtos.setIcon(Loja_icon);
    this.setLayout(null);
    this.add(titulo);
    titulo.setText("Mais sobre nós");
    this.add(titulo);
    titulo.setEditable(false);
    titulo.setFont(new Font("arial",Font.PLAIN,30));
    mais_sobre_nos.setBounds(0,27,1550, 30);
    this.add(about);
    about.setEditable(false);
    about.setBackground(new Color(200, 255, 206));
    titulo.setBackground(new Color(61, 153, 32));
    mais_sobre_nos.setEditable(false);
    mais_sobre_nos.setFont(new Font("arial",Font.PLAIN,30));
    mais_sobre_nos.setPreferredSize(new Dimension(1550, 30));
    }
     @Override
        public void componentResized(ComponentEvent e) {
        int largura_atual = this.getWidth();
        int altura_atual = this.getHeight();
        produtos.setBounds((largura_atual/2)-100, 0, 100, 28);
        parceiros.setBounds((largura_atual/2), 0, 100, 28);
        quests.setBounds((largura_atual/2)-200, 0, 100, 28);
        configs.setBounds((largura_atual/2)+100, 0, 100, 28);
        titulo.setBounds(0,26,largura_atual,35);
        about.setBounds(0,62,largura_atual,1460);
        about.setFont(new Font("arial",Font.PLAIN,altura_atual/55));
        this.revalidate();
        this.repaint();
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==produtos){
        //
    }else  if(e.getSource()==quests){
        this.removeAll();
        Metas metas = new Metas();
        this.add(metas);
        metas.setBounds(0,0,this.getWidth(), this.getHeight());
        this.revalidate();
        this.repaint();
    }else  if(e.getSource()==parceiros){
        //
    }else  if(e.getSource()==configs){
        this.removeAll();
        Configuracoes configuracoes = new Configuracoes();
        this.add(configuracoes);
        configuracoes.setBounds(0,0,this.getWidth(), this.getHeight());
        this.revalidate();
        this.repaint();
    }
}
@Override
public void componentMoved(ComponentEvent e) {}
@Override
public void componentShown(ComponentEvent e) {}
@Override
public void componentHidden(ComponentEvent e) {}
public static void main(String[] args) {
    Sobre sobre = new Sobre();
    sobre.sobre();
    }
}
