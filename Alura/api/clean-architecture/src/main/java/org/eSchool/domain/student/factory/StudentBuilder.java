package org.eSchool.domain.student.factory;

import org.eSchool.domain.student.values.CPF;
import org.eSchool.domain.student.values.Email;
import org.eSchool.domain.student.Student;

public class StudentBuilder {
    public static StudentFactory withNameCpfEmail(String name, String cpf, String email){
        Student student = new Student(name, new CPF(cpf), new Email(email));
        return new StudentFactory(student);
    }
}
