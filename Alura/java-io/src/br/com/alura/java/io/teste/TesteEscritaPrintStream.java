package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintWriter;

public class TesteEscritaPrintStream {
    public static void main(String[] args) throws IOException {
        // OutputStream fos = new FileOutputStream("lorem2.txt");
        // Writer osw = new OutputStreamWriter(fos);
        // BufferedWriter bw = new BufferedWriter(osw);

        // PrintStream ps = new PrintStream("lorem2.txt");

        PrintWriter pw = new PrintWriter("lorem2.txt");

        pw.println("Lorem Ipsum dolor sit amet");
        pw.println("");
        pw.println("jajajaj");

        // bw.write("Lorem Ipsum dolor sit amet");
        // bw.write(System.lineSeparator());
        // bw.write("\n");
        // bw.write("jajajaja");

        pw.close();
    }
}
