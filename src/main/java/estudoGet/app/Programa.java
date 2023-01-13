package estudoGet.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Programa {

	public static final String URL_GET = "http://httpbin.org/get";
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
		HttpClient cliente = HttpClient.newHttpClient();
		
		HttpRequest requisicao = HttpRequest.newBuilder().GET()
				.timeout(Duration.ofSeconds(10)).uri(URI.create(URL_GET))
				.build();
		HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(resposta.statusCode());
		System.out.println(resposta.body());
		
	}
}
