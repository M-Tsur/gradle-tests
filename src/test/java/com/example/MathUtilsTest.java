package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    void isPrimeTrueForTwo() {
        assertTrue(mathUtils.isPrime(2));
    }

    @Test
    void isPrimeTrueForLargePrime() {
        assertTrue(mathUtils.isPrime(97));
    }

    @Test
    void isPrimeFalseForOne() {
        assertFalse(mathUtils.isPrime(1));
    }

    @Test
    void isPrimeFalseForComposite() {
        assertFalse(mathUtils.isPrime(15));
    }

    @Test
    void fibonacciZero() {
        assertEquals(0, mathUtils.fibonacci(0));
    }

    @Test
    void fibonacciOne() {
        assertEquals(1, mathUtils.fibonacci(1));
    }

    @Test
    void fibonacciTen() {
        assertEquals(55, mathUtils.fibonacci(10));
    }

    @Test
    void fibonacciNegativeThrows() {
        assertThrows(IllegalArgumentException.class, () -> mathUtils.fibonacci(-1));
    }

    @Test
    void gcdNormal() {
        assertEquals(6, mathUtils.gcd(12, 18));
    }

    @Test
    void gcdWithZero() {
        assertEquals(5, mathUtils.gcd(5, 0));
    }

    @Test
    void lcmNormal() {
        assertEquals(12, mathUtils.lcm(4, 6));
    }

    @Test
    void lcmWithZero() {
        assertEquals(0, mathUtils.lcm(0, 5));
    }

    @Test
    void averageNormal() {
        assertEquals(3.0, mathUtils.average(List.of(1.0, 2.0, 3.0, 4.0, 5.0)), 0.001);
    }

    @Test
    void averageEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> mathUtils.average(List.of()));
    }

    @Test
    void medianOddCount() {
        assertEquals(3.0, mathUtils.median(List.of(1.0, 3.0, 5.0)), 0.001);
    }

    @Test
    void medianEvenCount() {
        assertEquals(2.5, mathUtils.median(List.of(1.0, 2.0, 3.0, 4.0)), 0.001);
    }

    @Test
    void standardDeviationNormal() {
        double sd = mathUtils.standardDeviation(List.of(2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0));
        assertEquals(2.138, sd, 0.01);
    }

    @Test
    void standardDeviationTooFewThrows() {
        assertThrows(IllegalArgumentException.class, () -> mathUtils.standardDeviation(List.of(1.0)));
    }

    @Test
    void isPerfectSquareTrue() {
        assertTrue(mathUtils.isPerfectSquare(16));
    }

    @Test
    void isPerfectSquareFalse() {
        assertFalse(mathUtils.isPerfectSquare(15));
    }

    @Test
    void isPerfectSquareNegative() {
        assertFalse(mathUtils.isPerfectSquare(-4));
    }

    @Test
    void sumOfDigitsNormal() {
        assertEquals(15, mathUtils.sumOfDigits(12345));
    }

    @Test
    void sumOfDigitsNegative() {
        assertEquals(15, mathUtils.sumOfDigits(-12345));
    }

    @Test
    void sumOfDigitsZero() {
        assertEquals(0, mathUtils.sumOfDigits(0));
    }
}
