package org.eSchool.domain.student.values;

public class Email {
    private final String email;
    public Email(String email) {
        if (email == null || !email.matches("[a-zA-Z0-9._]+@[a-zA-Z0-9]+[.][a-zA-Z]+")){
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
