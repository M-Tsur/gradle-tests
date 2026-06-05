package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    private DateUtils dateUtils;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
    }

    @Test
    void isLeapYearTrue() {
        assertTrue(dateUtils.isLeapYear(2024));
    }

    @Test
    void isLeapYearFalse() {
        assertFalse(dateUtils.isLeapYear(2023));
    }

    @Test
    void isLeapYearCentury() {
        assertFalse(dateUtils.isLeapYear(1900));
    }

    @Test
    void isLeapYear400() {
        assertTrue(dateUtils.isLeapYear(2000));
    }

    @Test
    void daysInMonthJanuary() {
        assertEquals(31, dateUtils.daysInMonth(2024, 1));
    }

    @Test
    void daysInMonthFebruaryLeap() {
        assertEquals(29, dateUtils.daysInMonth(2024, 2));
    }

    @Test
    void daysInMonthFebruaryNonLeap() {
        assertEquals(28, dateUtils.daysInMonth(2023, 2));
    }

    @Test
    void daysInMonthInvalid() {
        assertThrows(IllegalArgumentException.class, () -> dateUtils.daysInMonth(2024, 13));
    }

    @Test
    void daysBetweenSameDay() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        assertEquals(0, dateUtils.daysBetween(date, date));
    }

    @Test
    void daysBetweenOneWeek() {
        LocalDate from = LocalDate.of(2024, 1, 1);
        LocalDate to = LocalDate.of(2024, 1, 8);
        assertEquals(7, dateUtils.daysBetween(from, to));
    }

    @Test
    void isWeekendSaturday() {
        assertTrue(dateUtils.isWeekend(LocalDate.of(2024, 1, 6)));
    }

    @Test
    void isWeekendSunday() {
        assertTrue(dateUtils.isWeekend(LocalDate.of(2024, 1, 7)));
    }

    @Test
    void isWeekendMonday() {
        assertFalse(dateUtils.isWeekend(LocalDate.of(2024, 1, 8)));
    }

    @Test
    void isWeekdayTrue() {
        assertTrue(dateUtils.isWeekday(LocalDate.of(2024, 1, 8)));
    }

    @Test
    void addBusinessDaysFive() {
        LocalDate start = LocalDate.of(2024, 1, 8); // Monday
        LocalDate expected = LocalDate.of(2024, 1, 15); // Next Monday
        assertEquals(expected, dateUtils.addBusinessDays(start, 5));
    }

    @Test
    void addBusinessDaysOverWeekend() {
        LocalDate start = LocalDate.of(2024, 1, 5); // Friday
        LocalDate expected = LocalDate.of(2024, 1, 8); // Monday
        assertEquals(expected, dateUtils.addBusinessDays(start, 1));
    }

    @Test
    void formatDateIso() {
        LocalDate date = LocalDate.of(2024, 3, 15);
        assertEquals("2024-03-15", dateUtils.formatDate(date, "yyyy-MM-dd"));
    }

    @Test
    void getQuarterQ1() {
        assertEquals(1, dateUtils.getQuarter(LocalDate.of(2024, 2, 1)));
    }

    @Test
    void getQuarterQ4() {
        assertEquals(4, dateUtils.getQuarter(LocalDate.of(2024, 12, 1)));
    }

    @Test
    void getStartOfWeek() {
        LocalDate wednesday = LocalDate.of(2024, 1, 10);
        assertEquals(LocalDate.of(2024, 1, 8), dateUtils.getStartOfWeek(wednesday));
    }

    @Test
    void getEndOfMonth() {
        LocalDate date = LocalDate.of(2024, 2, 15);
        assertEquals(LocalDate.of(2024, 2, 29), dateUtils.getEndOfMonth(date));
    }
}
