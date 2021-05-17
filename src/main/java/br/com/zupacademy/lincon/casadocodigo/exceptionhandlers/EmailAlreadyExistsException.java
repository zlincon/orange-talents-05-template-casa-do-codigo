package br.com.zupacademy.lincon.casadocodigo.exceptionhandlers;

public class EmailAlreadyExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
