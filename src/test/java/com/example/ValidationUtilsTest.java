package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    private ValidationUtils validationUtils;

    @BeforeEach
    void setUp() {
        validationUtils = new ValidationUtils();
    }

    @Test
    void isValidEmailTrue() {
        assertTrue(validationUtils.isValidEmail("user@example.com"));
    }

    @Test
    void isValidEmailFalse() {
        assertFalse(validationUtils.isValidEmail("not-an-email"));
    }

    @Test
    void isValidEmailNull() {
        assertFalse(validationUtils.isValidEmail(null));
    }

    @Test
    void isValidEmailWithSubdomain() {
        assertTrue(validationUtils.isValidEmail("user@mail.example.com"));
    }

    @Test
    void isValidPhoneTrue() {
        assertTrue(validationUtils.isValidPhone("+1234567890"));
    }

    @Test
    void isValidPhoneFalse() {
        assertFalse(validationUtils.isValidPhone("123"));
    }

    @Test
    void isValidPhoneNull() {
        assertFalse(validationUtils.isValidPhone(null));
    }

    @Test
    void isValidIpv4True() {
        assertTrue(validationUtils.isValidIpv4("192.168.1.1"));
    }

    @Test
    void isValidIpv4False() {
        assertFalse(validationUtils.isValidIpv4("999.999.999.999"));
    }

    @Test
    void isValidIpv4Null() {
        assertFalse(validationUtils.isValidIpv4(null));
    }

    @Test
    void isValidIpv4Localhost() {
        assertTrue(validationUtils.isValidIpv4("127.0.0.1"));
    }

    @Test
    void isInRangeTrue() {
        assertTrue(validationUtils.isInRange(5, 1, 10));
    }

    @Test
    void isInRangeFalse() {
        assertFalse(validationUtils.isInRange(15, 1, 10));
    }

    @Test
    void isInRangeBoundary() {
        assertTrue(validationUtils.isInRange(10, 1, 10));
    }

    @Test
    void isValidPasswordTrue() {
        assertTrue(validationUtils.isValidPassword("P@ssw0rd!"));
    }

    @Test
    void isValidPasswordTooShort() {
        assertFalse(validationUtils.isValidPassword("P@1a"));
    }

    @Test
    void isValidPasswordNoSpecial() {
        assertFalse(validationUtils.isValidPassword("Password1"));
    }

    @Test
    void isValidPasswordNull() {
        assertFalse(validationUtils.isValidPassword(null));
    }

    @Test
    void isValidUrlTrue() {
        assertTrue(validationUtils.isValidUrl("https://example.com/path"));
    }

    @Test
    void isValidUrlFalse() {
        assertFalse(validationUtils.isValidUrl("ftp://example.com"));
    }

    @Test
    void isValidUrlNull() {
        assertFalse(validationUtils.isValidUrl(null));
    }

    @Test
    void isAlphanumericTrue() {
        assertTrue(validationUtils.isAlphanumeric("abc123"));
    }

    @Test
    void isAlphanumericFalse() {
        assertFalse(validationUtils.isAlphanumeric("abc 123!"));
    }

    @Test
    void isAlphanumericEmpty() {
        assertFalse(validationUtils.isAlphanumeric(""));
    }

    @Test
    void isValidHexColorTrue() {
        assertTrue(validationUtils.isValidHexColor("#FF00AA"));
    }

    @Test
    void isValidHexColorShortTrue() {
        assertTrue(validationUtils.isValidHexColor("#F0A"));
    }

    @Test
    void isValidHexColorFalse() {
        assertFalse(validationUtils.isValidHexColor("#GGGGGG"));
    }

    @Test
    void isValidHexColorNull() {
        assertFalse(validationUtils.isValidHexColor(null));
    }
}
