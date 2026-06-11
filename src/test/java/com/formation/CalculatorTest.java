package com.formation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires de Calculator.
 * Chaque opération est testée individuellement,
 * y compris le cas limite de la division par zéro.
 */
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void additionnerDeuxNombresPositifs() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void soustraireDeuxNombres() {
        assertEquals(1, calculator.subtract(4, 3));
    }

    @Test
    void multiplierDeuxNombres() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void diviserDeuxNombres() {
        assertEquals(3, calculator.divide(9, 3));
    }

    @Test
    void diviserParZeroLeveException() {
        ArithmeticException ex = assertThrows(
            ArithmeticException.class,
            () -> calculator.divide(10, 0)
        );
        assertEquals("Division par zéro impossible", ex.getMessage());
    }
}
