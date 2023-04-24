package org.eSchool.domain.student.exceptions;

import org.eSchool.domain.student.values.CPF;

public class StudentNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public StudentNotFound(CPF cpf) {
        super("Student with CPF " + cpf.getValue() + "not found");
    }
}
