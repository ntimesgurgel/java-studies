package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
    public static void main(String[] args) {
        String aula1 = "conhecendo mais de listas";
        String aula2 = "modelando a classe aula";
        String aula3 = "trabalhando com cursos e sets";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        System.out.println(aulas);

        for(int i = 0; i < aulas.size(); i++){
            System.out.println(aulas.get(i));
        }

        aulas.remove(1);

        aulas.forEach(aula -> {
            System.out.println("percorrendo:");
            System.out.println("Aula: " + aula);
        });

        aulas.add("Aumentando nosso conhecimento");

        System.out.println(aulas);

        Collections.sort(aulas);
        System.out.println("Depois de ordenado: ");
        System.out.println(aulas);


    }
}
