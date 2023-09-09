package com.example.satori8876.leetcode_60;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PermSequenceTest {

    PermSequence ps = new PermSequence();

    @ParameterizedTest(name=" when k={index}")
    @CsvSource({"1,12", "2,21"})
    public void testN2(int k, String expected) {

        assertEquals(expected, ps.getPermutation(2, k));
    }

    @ParameterizedTest(name=" when k={index}")
    @CsvSource({"1,123", "2,132", "3,213", "4,231", "5,312", "6,321"})
    public void testN3(int k, String expected) {

        assertEquals(expected, ps.getPermutation(3, k));
    }

    @ParameterizedTest(name=" when k={index}")
    @CsvSource({"1,1234", "2,1243", "3,1324", "4,1342", "5,1423",
            "6,1432", "7,2134", "8,2143", "9,2314", "10,2341",
            "11,2413", "12,2431", "13,3124", "14,3142", "15,3214",
            "16,3241", "17,3412", "18,3421", "19,4123", "20,4132",
            "21,4213", "22,4231", "23,4312", "24,4321"})
    public void testN4(int k, String expected) {

        assertEquals(expected, ps.getPermutation(4, k));
    }

    @ParameterizedTest(name=" when n={index}")
    @CsvSource({"1,1", "2,12", "3,123", "4,1234", "5,12345",
             "6,123456", "7,1234567", "8,12345678", "9,123456789"})
    public void testK1(int n, String expected) {

        assertEquals(expected, ps.getPermutation(n, 1));
    }


}