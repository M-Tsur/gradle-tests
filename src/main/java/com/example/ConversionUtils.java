package com.example;

public class ConversionUtils {

    public double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public double kilometersToMiles(double km) {
        return km * 0.621371;
    }

    public double milesToKilometers(double miles) {
        return miles / 0.621371;
    }

    public double kilogramsToPounds(double kg) {
        return kg * 2.20462;
    }

    public double poundsToKilograms(double pounds) {
        return pounds / 2.20462;
    }

    public String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";
        return Integer.toBinaryString(decimal);
    }

    public int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public String decimalToHex(int decimal) {
        return Integer.toHexString(decimal).toUpperCase();
    }

    public int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }

    public double litersToGallons(double liters) {
        return liters * 0.264172;
    }

    public double gallonsToLiters(double gallons) {
        return gallons / 0.264172;
    }
}
