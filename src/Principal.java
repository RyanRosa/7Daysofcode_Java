import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Principal {

	public static void main(String[] args) throws Exception {

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_5qyczg7n")).build();
		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());

		String json = response.body();
		String[] filmes = parsearJson(json);

		for (String filme : filmes) {
			System.out.println(filme);
		}
	}

	public static String[] parsearJson(String json) {
		String[] filmes = json.split("},");
		for (int i = 0; i < filmes.length; i++) {
			filmes[i] = filmes[i].replaceAll("\\{", "");
		}
		filmes[249] = filmes[249].replaceAll("}],\"errorMessage\":\"\"}", "");
		filmes[0] = filmes[0].replaceAll("\"items\":\\[", "");
		return filmes;
	}

}
