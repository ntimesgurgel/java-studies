package br.com.alura.java.io.teste;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;
//import java.util.Arrays;
import java.util.Scanner;

public class TesteLeitura2 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("contas.csv"), "UTF-8");

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            System.out.println(linha);

            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useLocale(Locale.US);
            linhaScanner.useDelimiter(",");

            String tipoDaConta = linhaScanner.next();
            int agencia = linhaScanner.nextInt();
            int conta = linhaScanner.nextInt();
            String titular = linhaScanner.next();
            BigDecimal valor = linhaScanner.nextBigDecimal();

            String formatado = String.format(new Locale("pt", "BR"), "%s %04d-%d %s: %.2f", tipoDaConta, agencia, conta,
                    titular,
                    valor);
            System.out.println(formatado);
            linhaScanner.close();
            // String[] valores = linha.split(",");
            // System.out.println(Arrays.toString(valores));
        }

        scanner.close();

    }
}
