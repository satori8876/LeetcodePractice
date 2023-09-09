package com.example.satori8876.leetcode_65;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


// For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.",
// "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
// while the following are not valid numbers: [".", "+E3", "abc", "1a", "1e", "e3", "1e23e",
// "99e2.5", "--6", "-+3", "95a54e53"].
class ValidNumberTest {

    ValidNumber vn = new ValidNumber();


    @ParameterizedTest
    @ValueSource(strings = {"", ".", "e", "E", "1e2e", "3E4E", "+E3", "abc",
            "1a", "1e", "e3", "1e23e", "99e2.5", "--6", "-+3", "95a54e53"})
    void isNumberShouldReturnFalse(String s) {
        assertFalse(vn.isNumber(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10",
            "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"})
    void isNumberShouldReturnTrue(String s) {
        assertTrue(vn.isNumber(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ".", "e", "abc", "1a", "1e",
            "e3", "2e10", "-90E3", "12.23.45"})
    void isDecimalShouldReturnFalse(String s) {
        assertFalse(vn.isDecimal(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01", "4.", "-.9", "1", "1.2",
            "+12.3",  "-1.234", "-56789."})
    void isDecimalShouldReturnTrue(String s) {
        assertTrue(vn.isDecimal(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ".", "e", "abc", "1a", "1e", "e3",
            "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3"})
    void isSignedIntShouldReturnFalse(String s) {
        assertFalse(vn.isSignedInt(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01", "1", "12", "+123", "-1234", "-56789"})
    void isSignedIntShouldReturnTrue(String s) {
        assertTrue(vn.isSignedInt(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ".", "e", "abc", "1a", "1e", "e3", "-0.1",
            "+3.14", "4.", "-.9", "2e10", "-90E3"})
    void isIntegerShouldReturnFalse(String s) {
        assertFalse(vn.isInteger(s));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "01", "1", "12", "123", "1234", "56789"})
    void isIntegerShouldReturnTrue(String s) {
        assertTrue(vn.isInteger(s));
    }
}