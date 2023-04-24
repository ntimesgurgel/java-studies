package br.com.alura.tdd.test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;

public class BonusServiceTest {

    @Test
    void bonusDeveriaLançarExceptionParaFuncionarioComSalarioAcimaDeDezMil(){
        BonusService bonusService = new BonusService();
        //Assertions.assertThrows(IllegalArgumentException.class,
        //        () -> bonusService.calcularBonus(new Funcionario("Nathan", LocalDate.now(),new BigDecimal("25000"))));

        try {
            bonusService.calcularBonus(new Funcionario("Nathan", LocalDate.now(),new BigDecimal("25000")));
            Assertions.fail("Nao deu a exception!");
        } catch (Exception e){
            Assertions.assertEquals("Funcionario com salario maior que R$10.000,00 nao pode receber bonus", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Nathan", LocalDate.now(),new BigDecimal("2500")));

        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorcentoParaSalarioDeDezMilReais(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Nathan", LocalDate.now(),new BigDecimal("10000")));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
