package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void addNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    void addZero() {
        assertEquals(7, calculator.add(7, 0));
    }

    @Test
    void subtractPositiveNumbers() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void subtractResultNegative() {
        assertEquals(-3, calculator.subtract(2, 5));
    }

    @Test
    void multiplyPositiveNumbers() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void multiplyByZero() {
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    void multiplyNegativeNumbers() {
        assertEquals(6, calculator.multiply(-2, -3));
    }

    @Test
    void divideNormal() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
    }

    @Test
    void divideByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }

    @Test
    void moduloNormal() {
        assertEquals(1, calculator.modulo(7, 3));
    }

    @Test
    void moduloByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calculator.modulo(7, 0));
    }

    @Test
    void powerPositive() {
        assertEquals(8.0, calculator.power(2, 3), 0.001);
    }

    @Test
    void powerZeroExponent() {
        assertEquals(1.0, calculator.power(5, 0), 0.001);
    }

    @Test
    void factorialZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void factorialFive() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void factorialNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }

    @Test
    void absPositive() {
        assertEquals(5, calculator.abs(5));
    }

    @Test
    void absNegative() {
        assertEquals(5, calculator.abs(-5));
    }

    @Test
    void maxReturnsLarger() {
        assertEquals(10, calculator.max(5, 10));
    }

    @Test
    void minReturnsSmaller() {
        assertEquals(3, calculator.min(3, 8));
    }
}
