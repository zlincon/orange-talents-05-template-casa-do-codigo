package br.com.zupacademy.lincon.casadocodigo.exceptionhandlers;

public class CategoriaAlreadyExistsException extends RuntimeException {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CategoriaAlreadyExistsException(String message) {
        super(message);
    }
}
