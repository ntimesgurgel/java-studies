package me.dio.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class PersonTest {

    @Test
    void validateYear(){
        Person person = new Person("julia", LocalDate.of(2020,1,1));

        Assertions.assertEquals(2, person.getAge());
    }

    @Test
    void returnIfIsUnderOrUpperAge(){
        Person john = new Person("john", LocalDate.of(2020, 1, 1));

        Assertions.assertFalse(john.isOfAge());

        Person martha = new Person("martha", LocalDate.of(1995,1,1));

        Assertions.assertTrue(martha.isOfAge());

        List<Person> persons = List.of(
                new Person("mary", LocalDate.now()),
                new Person("jack", LocalDate.now())
        );

        Assertions.assertAll("persons",
                ()->Assertions.assertFalse(persons.get(0).isOfAge()),
                ()->Assertions.assertFalse(persons.get(1).isOfAge())
        );
    }
}
