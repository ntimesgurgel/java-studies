package me.dio.junit;

public class Transference {
    public static void transfer(Account origin, Account destiny, int value){
        if(value <= 0){
            throw new IllegalArgumentException("valor deve ser maior que zero");
        }
    }
}
