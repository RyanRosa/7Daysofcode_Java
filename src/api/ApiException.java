package api;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiException() {
		super("Erro na API");
	}
}
