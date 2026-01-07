package com.personal.toolkit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ZohoServiceTest {

    @InjectMocks
    private ZohoService zohoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculateTimeLeft_WithValidTime_ReturnsCorrectTimeLeft() {
        // Test normal case
        String result1 = zohoService.calculateTimeLeft("4:30");
        assertEquals("3 hours 30 minutes", result1);

        // Test exactly 8 hours (no time left)
        String result2 = zohoService.calculateTimeLeft("8:00");
        assertEquals("0 hour 0 minute", result2);

        // Test 0 hours (full day left)
        String result3 = zohoService.calculateTimeLeft("0:00");
        assertEquals("8 hours 0 minute", result3);
    }

    @Test
    void calculateTimeLeft_WithInvalidFormat_ReturnsErrorMessage() {
        // Test invalid time format
        String result = zohoService.calculateTimeLeft("invalid-time");
        assertEquals("Invalid time format", result);
    }

    @Test
    void sortString_WithValidInput_ReturnsSortedNumbers() {
        // Test normal case
        String result1 = zohoService.sortString("5,2,8,3,1,6,4");
        assertEquals("1,2,3,4,5,6,8", result1);

        // Test single number
        String result2 = zohoService.sortString("42");
        assertEquals("42", result2);

        // Test already sorted
        String result3 = zohoService.sortString("1,2,3,4,5");
        assertEquals("1,2,3,4,5", result3);

        // Test reverse sorted
        String result4 = zohoService.sortString("5,4,3,2,1");
        assertEquals("1,2,3,4,5", result4);
    }

    @Test
    void sortString_WithEmptyInput_ThrowsNumberFormatException() {
        // Test empty input
        assertThrows(NumberFormatException.class, () -> {
            zohoService.sortString("");
        });
    }

    @Test
    void sortString_WithSingleNumber_ReturnsSameNumber() {
        String result = zohoService.sortString("42");
        assertEquals("42", result);
    }

    @Test
    void sortString_WithNegativeNumbers_ReturnsSortedNumbers() {
        String result = zohoService.sortString("-5,2,-8,0,1");
        assertEquals("-8,-5,0,1,2", result);
    }
}
