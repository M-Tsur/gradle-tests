package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionUtilsTest {

    private ConversionUtils conversionUtils;

    @BeforeEach
    void setUp() {
        conversionUtils = new ConversionUtils();
    }

    @Test
    void celsiusToFahrenheitFreezing() {
        assertEquals(32.0, conversionUtils.celsiusToFahrenheit(0), 0.01);
    }

    @Test
    void celsiusToFahrenheitBoiling() {
        assertEquals(212.0, conversionUtils.celsiusToFahrenheit(100), 0.01);
    }

    @Test
    void celsiusToFahrenheitNegative() {
        assertEquals(-40.0, conversionUtils.celsiusToFahrenheit(-40), 0.01);
    }

    @Test
    void fahrenheitToCelsiusFreezing() {
        assertEquals(0.0, conversionUtils.fahrenheitToCelsius(32), 0.01);
    }

    @Test
    void fahrenheitToCelsiusBoiling() {
        assertEquals(100.0, conversionUtils.fahrenheitToCelsius(212), 0.01);
    }

    @Test
    void kilometersToMilesOne() {
        assertEquals(0.621, conversionUtils.kilometersToMiles(1), 0.01);
    }

    @Test
    void kilometersToMilesTen() {
        assertEquals(6.214, conversionUtils.kilometersToMiles(10), 0.01);
    }

    @Test
    void milesToKilometersOne() {
        assertEquals(1.609, conversionUtils.milesToKilometers(1), 0.01);
    }

    @Test
    void kilogramsToPoundsOne() {
        assertEquals(2.205, conversionUtils.kilogramsToPounds(1), 0.01);
    }

    @Test
    void poundsToKilogramsOne() {
        assertEquals(0.4536, conversionUtils.poundsToKilograms(1), 0.01);
    }

    @Test
    void decimalToBinaryZero() {
        assertEquals("0", conversionUtils.decimalToBinary(0));
    }

    @Test
    void decimalToBinaryTen() {
        assertEquals("1010", conversionUtils.decimalToBinary(10));
    }

    @Test
    void decimalToBinary255() {
        assertEquals("11111111", conversionUtils.decimalToBinary(255));
    }

    @Test
    void binaryToDecimalTen() {
        assertEquals(10, conversionUtils.binaryToDecimal("1010"));
    }

    @Test
    void binaryToDecimal255() {
        assertEquals(255, conversionUtils.binaryToDecimal("11111111"));
    }

    @Test
    void decimalToHex255() {
        assertEquals("FF", conversionUtils.decimalToHex(255));
    }

    @Test
    void decimalToHexZero() {
        assertEquals("0", conversionUtils.decimalToHex(0));
    }

    @Test
    void hexToDecimalFF() {
        assertEquals(255, conversionUtils.hexToDecimal("FF"));
    }

    @Test
    void hexToDecimalCaseInsensitive() {
        assertEquals(255, conversionUtils.hexToDecimal("ff"));
    }

    @Test
    void litersToGallonsOne() {
        assertEquals(0.264, conversionUtils.litersToGallons(1), 0.01);
    }

    @Test
    void gallonsToLitersOne() {
        assertEquals(3.785, conversionUtils.gallonsToLiters(1), 0.01);
    }
}
