package me.dio.junit;

import org.junit.jupiter.api.*;

import javax.xml.crypto.Data;
import java.time.LocalDate;

public class ReadPersonTest {
    @BeforeAll
    static void configureConnection(){
        DatabaseConnectorManager.startConnection();
    }

    @BeforeEach
    void insertData(){
        DatabaseConnectorManager.createData(new Person("John", LocalDate.of(2000,1,1)));
    }

    @AfterEach
    void removeData(){}

    @Test
    void ValidateReturn(){
        Assertions.assertTrue(true);
    }

    @AfterAll
    static void terminateConnection(){
        DatabaseConnectorManager.endConnection();
    }
}
