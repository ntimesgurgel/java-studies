package me.dio.bank;

import java.math.BigDecimal;

public abstract class Account {
    protected final String agency;
    protected final String accNumber;
    protected BigDecimal balance;

    public Account(String agency, String accNumber, BigDecimal balance) {
        this.agency = agency;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    public void deposit(BigDecimal value){
        this.balance = this.balance.add(value);
    }

    public void transfer(Account another, BigDecimal value){
        if(value.compareTo(this.balance) > -1){
            this.withdraw(value);
            another.deposit(value);
        }
    }
}
