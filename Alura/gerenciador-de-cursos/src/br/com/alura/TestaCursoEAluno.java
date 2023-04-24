package br.com.alura;

import java.util.*;

public class TestaCursoEAluno {
    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando Java Collections", "Nathan");
        // javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList",21));
        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList",21));
        javaColecoes.adiciona(new Aula("Criando uma aula",20));
        javaColecoes.adiciona(new Aula("Modelando com colecoes",22));

        Aluno a1 = new Aluno("Nathan Gurgel", 34672);
        Aluno a2 = new Aluno("Guilherme Silveira", 5617);
        Aluno a3 = new Aluno("Rayanne Karla", 1403);

        javaColecoes.matriculaAluno(a1);
        javaColecoes.matriculaAluno(a2);
        javaColecoes.matriculaAluno(a3);

        System.out.println("Todos os alunos matriculados: ");

        Set<Aluno> alunos = javaColecoes.getAlunos();
        Iterator<Aluno> iterador = alunos.iterator();
        while(iterador.hasNext()){
            Aluno proximo = iterador.next();
            System.out.println(proximo);
        }

/*        System.out.println("O aluno " + a1 + "est� matriculado?");
        System.out.println(javaColecoes.estaMatriculado(a1));

        Aluno Nathan = new Aluno("Nathan Gurgel", 34672);
        System.out.println(javaColecoes.estaMatriculado(Nathan));

        System.out.println("O a1 eh igual a Nathan?");
        System.out.println(a1.equals(Nathan));*/
    }
}
