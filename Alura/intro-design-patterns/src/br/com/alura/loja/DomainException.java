package br.com.alura.loja;

public class DomainException extends RuntimeException {
    private static final long SerialVersionUID = 1L;
    public DomainException(String s) {
        super(s);
    }
}
