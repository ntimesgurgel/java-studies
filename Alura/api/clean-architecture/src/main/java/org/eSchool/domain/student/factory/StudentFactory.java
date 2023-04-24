package org.eSchool.domain.student.factory;

import org.eSchool.domain.student.Student;
import org.eSchool.domain.student.values.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class StudentFactory {
    private final Student student;
    private final List<PhoneNumber> phoneNumberNumbers = new ArrayList<>();
    public StudentFactory(Student student){
        this.student = student;
    }

    public StudentFactory withPhone(String ddd, String numero){
        PhoneNumber phoneNumber = new PhoneNumber(ddd, numero);
        this.student.addPhoneNumber(phoneNumber);

        return this;
    }

    public Student build(){
        return this.student;
    }
}
