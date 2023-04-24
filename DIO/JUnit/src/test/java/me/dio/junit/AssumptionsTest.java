package me.dio.junit;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTest {

    @Test
    void validateOnlyWhenUserIsSpecific(){
        Assumptions.assumeTrue("Willyam".equals(System.getenv("USER")));

    }
}
