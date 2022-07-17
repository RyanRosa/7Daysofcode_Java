import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Principal {

	public static void main(String[] args) throws Exception {

		HttpRequest request = HttpRequest.newBuilder().GET()

				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_2u4vtzp4")).build();

		HttpClient httpClient = HttpClient.newBuilder().build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

		System.out.println(response.body());
	}

}
