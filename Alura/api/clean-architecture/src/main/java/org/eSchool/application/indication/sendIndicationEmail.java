package org.eSchool.application.indication;

import org.eSchool.domain.student.Student;

public interface sendIndicationEmail {
    void sendTo(Student indication);
}

