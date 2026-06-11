package com.formation;

/**
 * Calculatrice simple — classe métier du projet.
 * Les 4 opérations de base seront testées et analysées
 * par les outils de qualité dans les modules suivants.
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }
}
