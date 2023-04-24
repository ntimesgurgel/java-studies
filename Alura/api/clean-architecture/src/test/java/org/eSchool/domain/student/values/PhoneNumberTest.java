package org.eSchool.domain.student.values;

import org.eSchool.domain.student.values.PhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    void dontCreateInvalidNumber() {
        assertThrows(
                NullPointerException.class,
                () -> new PhoneNumber(null, null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("123", null)
        );
        assertThrows(
                NullPointerException.class,
                () -> new PhoneNumber("84", null)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("84", "123456789")
        );
    }

    @Test
    void getNumero() {
    }
}