package org.eSchool.domain.student.values;

public class PhoneNumber {
    private String ddd;
    private String number;

    public PhoneNumber(String ddd, String number) {
        if(ddd == null){
        }

        if(!ddd.matches("\\d{2}")){
            throw new IllegalArgumentException("DDD deve possuir só 2 números");
        }
        this.ddd = ddd;

        if(number == null){
            throw new NullPointerException("O número não pode ser nulo");
        }

        if(!number.matches("^9?\\d{8}$")){
            throw new IllegalArgumentException("O número deve possuir de 8 a 9 digitos");
        }
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}
