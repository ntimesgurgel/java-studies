package me.dio.junit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class OrderingTests {

    @DisplayName("A")
    @Order(4)
    @Test
    void validateFlux(){
        Assertions.assertTrue(true);
    }

    @Order(3)
    @Test
    void validateFluxB(){
        Assertions.assertTrue(true);
    }

    @Order(2)
    @Test
    void validateFluxC(){
        Assertions.assertTrue(true);
    }

    @Order(1)
    @Test
    void validateFluxD(){
        Assertions.assertTrue(true);
    }
}
