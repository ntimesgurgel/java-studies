package br.com.alura.escola.dominio.aluno;

public class QuantidadeMaximaDeNumeros extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QuantidadeMaximaDeNumeros() {
        super("O aluno já possui 2 números");
    }
}
