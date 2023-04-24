package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.Ouvinte;
import br.com.alura.escola.dominio.Evento;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {
    @Override
    public void reageAo(Evento evento){
        String momentoFormatado = ((AlunoMatriculado) evento).getMomento().format(
                DateTimeFormatter.ofPattern("DD/MM/YYYY"));
        System.out.println(
                String.format(
                    "Aluno com CPF %f em %s",
                        ((AlunoMatriculado) evento).getCpfDoAluno(),
                        momentoFormatado
                )
        );
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
