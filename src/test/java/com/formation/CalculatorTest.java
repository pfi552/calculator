package com.formation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // --- Tests paramétrés ---

    @ParameterizedTest
    @DisplayName("Addition de plusieurs paires de nombres")
    @CsvSource({
        "2,  3,  5",
        "0,  0,  0",
        "-1, 1,  0",
        "100, 200, 300",
        "-5, -3, -8"
    })
    void additionParametree(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @DisplayName("Division par zéro lève toujours une exception")
    @ValueSource(ints = {1, 10, 100, -5, Integer.MAX_VALUE})
    void divisionParZeroEchoue(int numerateur) {
        assertThrows(ArithmeticException.class,
            () -> calculator.divide(numerateur, 0));
    }

    // --- Tests groupés avec assertAll ---

    @Test
    @DisplayName("Toutes les opérations de base fonctionnent")
    void toutesLesOperationsDeBase() {
        assertAll("Opérations de base",
            () -> assertEquals(5,  calculator.add(2, 3),      "add(2,3)"),
            () -> assertEquals(1,  calculator.subtract(4, 3), "subtract(4,3)"),
            () -> assertEquals(12, calculator.multiply(3, 4), "multiply(3,4)"),
            () -> assertEquals(3,  calculator.divide(9, 3),   "divide(9,3)")
        );
    }

    // --- Tests unitaires individuels ---

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
