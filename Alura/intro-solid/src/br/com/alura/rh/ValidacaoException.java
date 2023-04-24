package br.com.alura.rh;

public class ValidacaoException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    public ValidacaoException(String mensagem){
        super(mensagem);
    }
}
