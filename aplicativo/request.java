import java.net.*;
import java.io.*;
public class request {
    public static void main(String[] args) throws Exception {
        //txt com as infos p/ver se é compativel
        File client = new File("teste.txt");
        String linhas;
        if (client.exists()) {
            System.out.println("teste");
        }
        //tenta se conectar com a api 
        URL url_login = new URL("http://192.168.100.34:5000/api/usuarios");
        HttpURLConnection conectar = (HttpURLConnection) url_login.openConnection();
        //ver se está conectado
        conectar.setRequestMethod("GET");
        int resposta = conectar.getResponseCode();
        System.out.println("resp: "+resposta);
        //metodo de request
        URL url_modelos = new URL("http://10.158.152.21:5000/api/modelos");
        URL url_tarefas = new URL("http://10.158.152.21:5000/api/tarefas");

        //configurações da conecção
        int tamanho = conectar.getContentLength();
        System.out.println("lenght: "+tamanho);
        conectar.setConnectTimeout(1000); // 1 secs
        conectar.setReadTimeout(1000); 
        if(client.exists()){
            System.out.println("arquivo nn existe criand ele");
            BufferedReader ler = new BufferedReader(new InputStreamReader(conectar.getInputStream()));
            try {
                FileWriter client_txt = new FileWriter("teste.txt", true);
            while ((linhas = ler.readLine()) != null) {
            client_txt.write(linhas + "\n");
            System.out.println(linhas);
        }
        client_txt.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(ler);
        }
    }
}
