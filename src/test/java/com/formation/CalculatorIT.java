package com.formation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests d'intégration — exécutés par maven-failsafe-plugin (mvn verify).
 * Convention : suffixe IT (Integration Test).
 */
class CalculatorIT {

    @Test
    @DisplayName("Intégration : chaîne de calculs successifs")
    void chaineDeCalculs() {
        Calculator calc = new Calculator();

        // Simuler un workflow : (10 + 5) * 2 / 5 - 1
        int etape1 = calc.add(10, 5);       // 15
        int etape2 = calc.multiply(etape1, 2); // 30
        int etape3 = calc.divide(etape2, 5);   // 6
        int resultat = calc.subtract(etape3, 1); // 5

        assertEquals(5, resultat);
    }

    @Test
    @DisplayName("Intégration : limite des valeurs Integer")
    void limitesInteger() {
        Calculator calc = new Calculator();

        // Integer.MAX_VALUE + 1 provoque un overflow en Java — comportement documenté
        int overflow = calc.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, overflow);
    }
}
