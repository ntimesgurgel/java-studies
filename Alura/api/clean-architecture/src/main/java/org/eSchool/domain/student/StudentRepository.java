package org.eSchool.domain.student;

import org.eSchool.domain.student.values.CPF;

import java.util.List;

public interface StudentRepository {
    void enroll(Student student);

    Student findByCpf(CPF cpf);

    List<Student> listAllEnrolledStudents();
}
