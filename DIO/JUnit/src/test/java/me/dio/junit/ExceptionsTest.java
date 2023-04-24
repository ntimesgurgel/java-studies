package me.dio.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

    @Test
    void validateTransferExceptionScenario(){
        Account origin = new Account("123456", 0);
        Account destiny = new Account("22356", 0);

        Assertions.assertThrows(
                IllegalArgumentException.class, ()->
                        Transference.transfer(origin, destiny, -1)
        );
    }
}
