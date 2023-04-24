package br.com.alura;

public class TesteBuscaAlunosNoCurso {
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

        javaColecoes.buscaMatriculado(5617);
    }
}
