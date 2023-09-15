package com.example.satori8876.leetcode_68;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextJustificationTDDTest {

    TextJustificationTDD ts = new TextJustificationTDD();

    @Test
    void fullJustifyOneWordNoSpaces() {

        String[] words = new String[]{"example"};

        String[] tmp = new String[]{"example"};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 7));
    }

    @Test
    void fullJustifyOneWordWithSpaces() {

        String[] words = new String[]{"example"};

        String[] tmp = new String[]{"example   "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 10));
    }

    @Test
    void fullJustifyTwoWordsOnTwoLines() {

        String[] words = new String[]{"example", "justification"};

        String[] tmp = new String[]{"example        ", "justification  "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 15));
    }

    @Test
    void fullJustifyThreeWordsOnTwoLines() {

        String[] words = new String[]{"my", "example", "justification"};

        String[] tmp = new String[]{"my      example", "justification  "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 15));
    }

    @Test
    void fullJustifyFiveWordsOnThreeLines() {

        String[] words = new String[]{"This", "is", "another", "text", "justification"};

        String[] tmp = new String[]{"This        is", "another   text", "justification "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 14));
    }

    @Test
    void fullJustifySevenWordsOnThreeLines17() {

        String[] words = new String[]{"This", "is", "another", "example", "of", "text", "justification"};

        String[] tmp = new String[]{"This  is  another", "example  of  text", "justification    "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 17));
    }

    @Test
    void fullJustifySevenWordsOnThreeLines18() {

        String[] words = new String[]{"This", "is", "another", "example", "of", "text", "justification"};

        String[] tmp = new String[]{"This   is  another", "example   of  text", "justification     "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 18));
    }

    @Test
    void fullJustifySevenWordsOnThreeLines19() {

        String[] words = new String[]{"This", "is", "another", "example", "of", "text", "justification"};

        String[] tmp = new String[]{"This   is   another", "example   of   text", "justification      "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 19));
    }

    @Test
    void fullJustifySevenWordsOnTwoLines() {

        String[] words = new String[]{"This", "is", "another", "example", "of", "text", "justification"};

        String[] tmp = new String[]{"This is another example", "of  text  justification"};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 23));
    }

}
