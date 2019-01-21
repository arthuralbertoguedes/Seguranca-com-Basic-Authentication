import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class Cliente {
	
	private static final String url_servidor = "http://localhost:8080/etiqueta/pesquisar-etiqueta/3";
		
	public static void main(String[] args) {
			
			//Informacoes do usuario
			String usuario = "arthuralbertoguedes";
			String senha = "ara@123555J";
			String infosCodificadas = usuario + ":" + senha;
			
			//Codificando informacoes do usuario
			String encodedString = Base64.getEncoder().encodeToString(infosCodificadas.getBytes());
					
			try {
			
				URL url = new URL(url_servidor);
				URLConnection conexao = url.openConnection();
				
				//Adicionando Http basic authentication
				conexao.addRequestProperty("Basic", encodedString);
				conexao.connect();
				
				//Lendo resposta do servidor
				BufferedReader buffer = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
							
				String linha = "";
				while((linha = buffer.readLine()) != null)
				System.out.println("O resultado do servidor eh : \n" + linha);
							
				buffer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
				
	}

}
