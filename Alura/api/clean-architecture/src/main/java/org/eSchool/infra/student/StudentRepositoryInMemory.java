package org.eSchool.infra.student;

import org.eSchool.domain.student.Student;
import org.eSchool.domain.student.StudentRepository;
import org.eSchool.domain.student.exceptions.StudentNotFound;
import org.eSchool.domain.student.values.CPF;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> enrolled = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrolled.add(student);
    }

    @Override
    public Student findByCpf(CPF cpf) {
        return this.enrolled.stream()
                .filter(
                        student -> student.getCpf().equals(cpf.getValue())
                ).findFirst().orElseThrow(()-> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return this.enrolled;
    }
}
