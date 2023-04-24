package br.com.alura.tdd;

public class CalculadoraTestes {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        int soma = calc.somar(1,2);
        System.out.println(soma);
    }
}
