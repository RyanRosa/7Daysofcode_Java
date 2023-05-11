package entities;

import java.util.Objects;

public class Filme {
	private String id;
	private Integer rank;
	private String titulo;
	private Integer ano;
	private String imagem;
	private String diretor;
	private Double ImDbNota;

	public Filme() {

	}

	public Filme(String id, Integer rank, String titulo, Integer ano, String imagem, String diretor,
			Double imDbNota) {
		this.id = id;
		this.rank = rank;
		this.titulo = titulo;
		this.ano = ano;
		this.imagem = imagem;
		this.diretor = diretor;
		ImDbNota = imDbNota;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String gettitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getano() {
		return ano;
	}

	public void setano(Integer ano) {
		this.ano = ano;
	}

	public String getimagem() {
		return imagem;
	}

	public void setimagem(String imagem) {
		this.imagem = imagem;
	}

	public String getdiretor() {
		return diretor;
	}

	public void setdiretor(String diretor) {
		this.diretor = diretor;
	}

	public Double getImDbNota() {
		return ImDbNota;
	}

	public void setImDbNota(Double ImDbNota) {
		this.ImDbNota = ImDbNota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", rank=" + rank + ", titulo=" + titulo + ", ano=" + ano + ", imagem=" + imagem
				+ ", diretor=" + diretor + ", ImDbNota=" + ImDbNota + "]";
	}

	
}