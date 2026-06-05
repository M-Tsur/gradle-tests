package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void reverseNormal() {
        assertEquals("olleh", stringUtils.reverse("hello"));
    }

    @Test
    void reverseNull() {
        assertNull(stringUtils.reverse(null));
    }

    @Test
    void reverseEmpty() {
        assertEquals("", stringUtils.reverse(""));
    }

    @Test
    void isPalindromeTrue() {
        assertTrue(stringUtils.isPalindrome("racecar"));
    }

    @Test
    void isPalindromeFalse() {
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    @Test
    void isPalindromeWithSpaces() {
        assertTrue(stringUtils.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void isPalindromeNull() {
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    void countVowelsNormal() {
        assertEquals(2, stringUtils.countVowels("hello"));
    }

    @Test
    void countVowelsNone() {
        assertEquals(0, stringUtils.countVowels("xyz"));
    }

    @Test
    void countVowelsNull() {
        assertEquals(0, stringUtils.countVowels(null));
    }

    @Test
    void capitalizeNormal() {
        assertEquals("Hello", stringUtils.capitalize("hello"));
    }

    @Test
    void capitalizeEmpty() {
        assertEquals("", stringUtils.capitalize(""));
    }

    @Test
    void capitalizeNull() {
        assertNull(stringUtils.capitalize(null));
    }

    @Test
    void truncateShortString() {
        assertEquals("hi", stringUtils.truncate("hi", 5));
    }

    @Test
    void truncateLongString() {
        assertEquals("hel...", stringUtils.truncate("hello world", 3));
    }

    @Test
    void wordCountNormal() {
        assertEquals(3, stringUtils.wordCount("one two three"));
    }

    @Test
    void wordCountEmpty() {
        assertEquals(0, stringUtils.wordCount(""));
    }

    @Test
    void wordCountNull() {
        assertEquals(0, stringUtils.wordCount(null));
    }

    @Test
    void repeatNormal() {
        assertEquals("abcabcabc", stringUtils.repeat("abc", 3));
    }

    @Test
    void repeatZeroTimes() {
        assertEquals("", stringUtils.repeat("abc", 0));
    }

    @Test
    void isBlankTrue() {
        assertTrue(stringUtils.isBlank("   "));
    }

    @Test
    void isBlankFalse() {
        assertFalse(stringUtils.isBlank("hello"));
    }

    @Test
    void isBlankNull() {
        assertTrue(stringUtils.isBlank(null));
    }

    @Test
    void camelToSnakeNormal() {
        assertEquals("my_variable_name", stringUtils.camelToSnake("myVariableName"));
    }

    @Test
    void snakeToCamelNormal() {
        assertEquals("myVariableName", stringUtils.snakeToCamel("my_variable_name"));
    }
}
