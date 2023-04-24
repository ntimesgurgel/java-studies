package org.eSchool.domain.indication;

import org.eSchool.domain.student.Student;

import java.time.LocalDateTime;

public class Indication {
    private Student indicador;
    private Student indicado;
    private LocalDateTime indicationDate;

    public Indication(Student indicador, Student indicado) {
        this.indicador = indicador;
        this.indicado = indicado;
        this.indicationDate = LocalDateTime.now();
    }
}
