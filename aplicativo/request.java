import java.net.*;
import java.io.*;
public class request {
    public static void main(String[] args) throws Exception {
        //txt com as infos p/ver se é compativel
        File client = new File("teste.txt");
        //tenta se conectar com a api 
        URL url_login = new URL("http://10.158.152.21:5000/api/usuarios");
        HttpURLConnection conectar = (HttpURLConnection) url_login.openConnection();
        conectar.setRequestMethod("GET");
        URL url_modelos = new URL("http://10.158.152.21:5000/api/modelos");
        URL url_tarefas = new URL("http://10.158.152.21:5000/api/tarefas");
        Socket lado_cliente = new Socket("10.158.152.21",5000);//servidor + porta
        //configurações da conecção
        conectar.setConnectTimeout(50000); // 50 secs
        conectar.setReadTimeout(50000); 
        //ver se está conectado
        int resposta = conectar.getResponseCode();
        //401 nn foi autorizado deu 

        //conectar.setRequestMethod(null);
        //key e value para pooder ter acesso a api

        //conectar.setRequestProperty("chave", "valor");
        System.out.println("resp: "+resposta);
        //leitor de dados por enquanto preciso da  chave
        BufferedReader ler = new BufferedReader(new InputStreamReader(conectar.getInputStream()));
        System.out.println(ler);
        if (client.exists()) {
            System.out.println("teste");
            FileWriter client_txt = new FileWriter("teste.txt");
            client_txt.write(ler.readLine());
            client_txt.close();
        } else {
            try {
                FileWriter client_txt = new FileWriter("teste.txt");
                client_txt.write("aaa" + ler);
                client_txt.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(conectar.getContent());
    }
}
