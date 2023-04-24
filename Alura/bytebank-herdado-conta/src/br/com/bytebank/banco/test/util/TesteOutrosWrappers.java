package br.com.bytebank.banco.test.util;

//import java.util.ArrayList;
//import java.util.List;

public class TesteOutrosWrappers {

    public static void main(String[] args) {
        Integer idadeRef = Integer.valueOf(29);
        System.out.println(idadeRef.intValue());

        Double dRef = Double.valueOf(3.2);
        System.out.println(dRef.doubleValue());

        Boolean bRef = Boolean.TRUE;
        System.out.println(bRef.booleanValue());

        // Number refNumero = Float.valueOf(2.9f);

        // List<Number> number = new ArrayList<Number>();
    }
}
