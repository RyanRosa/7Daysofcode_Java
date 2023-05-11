package api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ResquestApi {

	//faz a chamada da api
	public static HttpResponse<String> response() {
		try {
			HttpRequest request = HttpRequest.newBuilder().GET()
					.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_5qyczg7n")).build();
			HttpClient httpClient = HttpClient.newBuilder().build();
			return httpClient.send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			throw new ApiException();
		}
	}
}
