package br.com.zupacademy.lincon.casadocodigo.exceptionhandlers;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
