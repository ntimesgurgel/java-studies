package org.eSchool.domain.student.values;

import org.eSchool.domain.student.values.Email;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
    @Test
    public void dontCreateInvalidEmail(){
        assertThrows(
                IllegalArgumentException.class,
                ()-> new Email(null)
        );
        assertThrows(
                IllegalArgumentException.class,
                ()-> new Email("")
        );
        assertThrows(
                IllegalArgumentException.class,
                ()-> new Email("emailinvalido@test")
        );
    }

    @Test
    public void createdValidEmail(){
        Email email = new Email("teste@gmail.com");
        assertEquals("teste@gmail.com", email.getEmail());
    }
}