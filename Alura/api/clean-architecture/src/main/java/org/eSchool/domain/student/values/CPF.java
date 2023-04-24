package org.eSchool.domain.student.values;

public class CPF {
    private final String value;
    public CPF(String value) {
        if(value == null || !value.matches("(\\d{3}[.]{1}){2}\\d{3}[-]\\d{2}")){
            throw new IllegalArgumentException("CPF inválido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
