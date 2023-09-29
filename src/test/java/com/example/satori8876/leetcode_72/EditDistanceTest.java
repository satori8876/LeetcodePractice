package com.example.satori8876.leetcode_72;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    EditDistance ed = new EditDistance();
    @Test
    void testMinDistanceForIdentical() {

        String word1 = "someword";
        String word2 = "someword";

        assertEquals(0, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForOneInsertAtEnd() {

        String word1 = "someword";
        String word2 = "someword1";

        assertEquals(1, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForOneContainsTheOther1() {

        String word1 = "someword";
        String word2 = "abcsomeword123";

        assertEquals(6, ed.minDistance(word1, word2));
    }
    @Test
    void testMinDistanceForOneContainsTheOther2() {

        String word1 = "abcsomeword123";
        String word2 = "someword";

        assertEquals(6, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForSamePrefix() {

        String word1 = "someword123";
        String word2 = "somewordabc";

        assertEquals(3, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForReplaceOnly() {

        String word1 = "someabcword123";
        String word2 = "some123wordabc";

        assertEquals(6, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForReplaceAndAppend() {

        String word1 = "someabcword12345";
        String word2 = "some123wordabc";

        assertEquals(8, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForReplaceAndDelete() {

        String word1 = "someabcword123";
        String word2 = "some123wordabcdef";

        assertEquals(9, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForRandom1() {

        String word1 = "mississippi";
        String word2 = "misspiggy";

        assertEquals(6, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForRandom2() {

        String word1 = "headoverheels";
        String word2 = "stackoverflow";

        assertEquals(9, ed.minDistance(word1, word2));
    }
    @Test
    void testMinDistanceForRandom3() {

        String word1 = "MikkaMakka";
        String word2 = "MokaMiki";

        assertEquals(5, ed.minDistance(word1, word2));
    }

    @Test
    void testMinDistanceForRandom4() {

        String word1 = "zoologicoarchaeologist";
        String word2 = "zoogeologist";

        assertEquals(10, ed.minDistance(word1, word2));
    }

}