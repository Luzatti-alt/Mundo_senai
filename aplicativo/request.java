import java.net.*;
import java.io.*;
public class request {
    public static void main(String[] args) throws Exception {
        //txt com as infos p/ver se é compativel
        File client = new File("teste.txt");
        //tenta se conectar com a api 
        URL url_login = new URL("http://10.158.152.21:5000/api/usuarios");
        HttpURLConnection conectar = (HttpURLConnection) url_login.openConnection();
        //ver se está conectado
        int resposta = conectar.getResponseCode();
        System.out.println("resp: "+resposta);
        //metodo de request
        conectar.setRequestMethod("GET");
        //URL url_modelos = new URL("http://10.158.152.21:5000/api/modelos");
        //URL url_tarefas = new URL("http://10.158.152.21:5000/api/tarefas");

        //configurações da conecção
        int tamanho = conectar.getContentLength();
        System.out.println("lenght: "+tamanho);
        conectar.setConnectTimeout(1000); // 1 secs
        conectar.setReadTimeout(1000); 
        //401 nn foi autorizado deu 
        //agr foi 200 agr deu
        //leitor de dados por enquanto preciso da  chave
        BufferedReader ler = new BufferedReader(new InputStreamReader(conectar.getInputStream()));
        System.out.println(ler);
        if (client.exists()) {
            System.out.println("teste");
        } else {
            try {
                FileWriter client_txt = new FileWriter("teste.txt");
                String info = ler.readLine();
                String info2 = ler.readLine()+1;
                client_txt.write(info);
                client_txt.write(info2);
                client_txt.close();
            System.out.println(info);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
