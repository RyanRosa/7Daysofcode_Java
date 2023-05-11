package resources;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilmeResource {

	//parsea por filme, retirando as chaves
	public static String[] parsearMovies(String json) {
		String parseado = retirarComecoEFim(json);
		String[] lista = parseado.split("},");
		for (int i = 0; i < lista.length; i++) {
			lista[i] = lista[i].replace("{", "");
		}
		return lista;
	}

	// Realiza a limpeza inicial do json deixando o json uniforme
	private static String retirarComecoEFim(String json) {
		String parseado = json.replace("{\"items\":[{", "");
		String parseado2 = parseado.replace("}],\"errorMessage\":\"\"}", "");
		return parseado2;
	}

	public static List<String> parsearValores(String[] moviesArray, int pos) {
		return Stream.of(moviesArray).map(e -> e.split("\",\"")[pos]).map(e -> e.split(":\"")[1])
				.map(e -> e.replaceAll("\"", "")).collect(Collectors.toList());
	}

	// implementações do parseamento de valor para os respectivos campos
	public static List<String> parsearId(String[] moviesArray) {
		return parsearValores(moviesArray, 0);
	}

	public static List<String> parsearRank(String[] moviesArray) {
		return parsearValores(moviesArray, 1);
	}

	public static List<String> parsearTitulo(String[] moviesArray) {
		return parsearValores(moviesArray, 2);
	}

	public static List<String> parsearAno(String[] moviesArray) {
		return parsearValores(moviesArray, 4);
	}

	public static List<String> parsearImagem(String[] moviesArray) {
		return parsearValores(moviesArray, 5);
	}

	public static List<String> parsearDiretor(String[] moviesArray) {
		return parsearValores(moviesArray, 6);
	}

	public static List<String> parsearImDbNota(String[] moviesArray) {
		return parsearValores(moviesArray, 7);
	}

}
