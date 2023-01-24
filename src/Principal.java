import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {

	public static void main(String[] args) throws Exception {

		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_5qyczg7n")).build();
		HttpClient httpClient = HttpClient.newBuilder().build();
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		String json = response.body();
		String[] filmes = parsearJson(json);
		ArrayList<String>titulos = new ArrayList<String>();
		ArrayList<String>urlImagens = new ArrayList<String>();
		
		urlImagens = parsearUrl(filmes);
		for (String string : urlImagens) {
			System.out.println(string);
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
	public static ArrayList<String> parsearUrl(String[]filmes){
		ArrayList<String> urlFilmes = new ArrayList<String>();
		String regex = "https([:a-zA-Z0-9.@\\-/_])+";
		Pattern pattern = Pattern.compile(regex);
		for(int i= 0; i < filmes.length;i++) {
			Matcher matcher = pattern.matcher(filmes[i]);
			if(matcher.find())
			urlFilmes.add(matcher.group());
		}
		return urlFilmes;
	}
	
	

}
