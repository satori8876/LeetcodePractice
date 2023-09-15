package com.example.satori8876.leetcode_68;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextJustificationTest {

    TextJustification ts = new TextJustification();

    @Test
    void fullJustifyCase1() {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        String[] tmp = new String[]{"This    is    an","example  of text","justification.  "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 16));
    }

    @Test
    void fullJustifyCase2() {
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};

        String[] tmp = new String[]{"What   must   be","acknowledgment  ","shall be        "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 16));
    }

    @Test
    void fullJustifyCase3() {
        String[] words = new String[]{"Science","is","what","we","understand","well","enough",
                "to","explain","to","a","computer.","Art","is","everything","else","we","do"};

        String[] tmp = new String[]{"Science  is  what we","understand      well","enough to explain to",
                "a  computer.  Art is","everything  else  we","do                  "};
        List<String> expected = Arrays.asList(tmp);

        assertEquals(expected, ts.fullJustify(words, 20));
    }
}
