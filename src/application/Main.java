package application;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import api.ResquestApi;
import entities.Filme;
import resources.FilmeResource;

public class Main {
	public static void main(String[] args) throws Exception {
		
		//instacialziação do metodo através de chamda de outra classe
		HttpResponse<String> response = ResquestApi.response();
		String json = response.body();	
		String[] lista = FilmeResource.parsearMovies(json);
		
		//parseamento dos atributos em listas
		List<String> ids = FilmeResource.parsearId(lista);
		List<String> ranks = FilmeResource.parsearRank(lista);
		List<String> titulos = FilmeResource.parsearTitulo(lista);
		List<String> ano = FilmeResource.parsearAno(lista);
		List<String> imagens = FilmeResource.parsearImagem(lista);
		List<String> diretores = FilmeResource.parsearDiretor(lista);
		List<String> imDbNotas = FilmeResource.parsearImDbNota(lista);
		
		//Inserção em uma lista de filmes
		List<Filme> filmes = new ArrayList<Filme>();
		for(int i = 0;i<lista.length;i++) {
			filmes.add(new Filme(ids.get(i),
					Integer.parseInt(ranks.get(i)),
					titulos.get(i),
					Integer.parseInt(ano.get(i)),
					imagens.get(i),
					diretores.get(i),
					Double.parseDouble(imDbNotas.get(i))));
		}

		for (Filme filme : filmes) {
			System.out.println(filme);
		}
	}

}
