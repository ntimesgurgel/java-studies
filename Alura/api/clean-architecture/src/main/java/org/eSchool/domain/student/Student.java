package org.eSchool.domain.student;

import org.eSchool.domain.student.values.CPF;
import org.eSchool.domain.student.values.Email;
import org.eSchool.domain.student.values.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final CPF cpf;
    private final String name;
    private final Email email;
    private final List<PhoneNumber> phoneNumber = new ArrayList<>();
    private String password;

    public Student(String name, CPF cpf, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber.add(phoneNumber);
    }

    public String getCpf() {
        return cpf.getValue();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumber;
    }
}
