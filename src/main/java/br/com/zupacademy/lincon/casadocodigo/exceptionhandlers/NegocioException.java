package br.com.zupacademy.lincon.casadocodigo.exceptionhandlers;

public class NegocioException extends RuntimeException {
    public NegocioException(String message) {
        super(message);
    }
}
