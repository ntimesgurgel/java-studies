package br.com.alura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaAluno {
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>();
        alunos.add("Nathan");
        alunos.add("Bezerra");
        alunos.add("Gurgel");

        for (String aluno : alunos){
            System.out.println(aluno);
        }

        alunos.forEach(System.out::println);

        boolean nathanMatriculado = alunos.contains("Nathan");
        System.out.println(nathanMatriculado);
        alunos.remove("Bezerra");

        System.out.println(alunos);

        List<String> alunosEmLista = new ArrayList<>(alunos);
    }
}
