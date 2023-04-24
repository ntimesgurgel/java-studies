package br.com.alura.java.io.teste;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEEncoding {
    public static void main(String[] args) {
        String s = "CCCC";
        System.out.println(s.codePointAt(0));

        Charset c = Charset.defaultCharset();
        System.out.println(c.displayName());

        byte[] bytes = s.getBytes();
        System.out.println(bytes.length + " UTF-8");

        String sNovo = new String(bytes);
        System.out.println(sNovo);

        bytes = s.getBytes(StandardCharsets.UTF_16);
        System.out.println(bytes.length + " UTF-16");
    }
}
