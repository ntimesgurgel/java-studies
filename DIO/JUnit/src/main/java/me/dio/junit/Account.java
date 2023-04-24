package me.dio.junit;

public class Account {
    private String accNumber;
    private int value;

    public Account(String number, int value) {
        this.accNumber = number;
        this.value = value;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public int getValue() {
        return value;
    }
}
