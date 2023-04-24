import java.util.*;
import java.util.stream.Collectors;

class Curso{
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos){
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAlunos() {
        return this.alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python",45));
        cursos.add(new Curso("Javascript",150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C",55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));

        cursos.forEach(c->System.out.println(c.getNome()));

        int sum = cursos.stream()
                .filter(c-> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(sum);

        //Optional<Curso> optionalCurso = cursos.stream().filter(c->c.getAlunos()>=150).findAny();

        //optionalCurso.ifPresent(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c->c.getAlunos()>=100)
                .findAny()
                .ifPresent(c-> System.out.println(c.getNome()));

//        cursos = cursos.stream()
//                .filter(c -> c.getAlunos() >= 100)
////                .collect(Collectors.toList());
    }

    private static void accept(String nome, Integer alunos) {
        System.out.println(nome + " tem " + alunos + " alunos");
    }
}
