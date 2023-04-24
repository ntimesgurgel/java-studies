package me.dio.bank;

import java.math.BigDecimal;

public class Checking extends Account {
    public Checking(String agency, String accNumber, BigDecimal balance) {
        super(agency, accNumber, balance);
    }
}
