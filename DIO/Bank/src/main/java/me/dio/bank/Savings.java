package me.dio.bank;

import java.math.BigDecimal;

public class Savings extends Account{
    public Savings(String agency, String accNumber, BigDecimal balance) {
        super(agency, accNumber, balance);
    }
}
