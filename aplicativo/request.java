import java.net.*;
import java.io.*;
public class request {
    public static void main(String[] args) throws Exception {
        File client = new File("teste.txt");
        URL url = new URL("http://10.158.152.21:5000/api/usuarios");
        HttpURLConnection conectar = (HttpURLConnection) url.openConnection();
        conectar.setRequestMethod("GET");
        conectar.setConnectTimeout(50000); // 50 secs
        conectar.setReadTimeout(50000); 
        int resposta = conectar.getResponseCode();//nn foi autorizado deu 401
        conectar.setRequestMethod(null);
        conectar.setRequestProperty("chave", "valor");
        System.out.println(resposta);
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