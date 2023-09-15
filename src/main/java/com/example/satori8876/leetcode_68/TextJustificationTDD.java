package com.example.satori8876.leetcode_68;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationTDD {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> output = new ArrayList();
        int wordCount = 1;
        int index=0;
        while (index < words.length) {
            int sum = words[index].length();
            while (canAddMoreWords(words, maxWidth,
                    sum, index+wordCount, wordCount-1)) {
                sum += words[index+wordCount].length();
                wordCount++;
            }
            if (wordCount == 1)
                output.add(generateLineWithOneWord(words[index], maxWidth));
            else
                output.add(generateLineWithMoreWords(words, index, wordCount, maxWidth-sum));

            index += wordCount;
            wordCount = 1;
        }
        return output;
    }

    private boolean canAddMoreWords(String[] words, int maxWidth,
                                    int sum, int nextIndex, int numSpaces) {

        if (nextIndex >= words.length) return false;
        int currentMinWidth = sum + words[nextIndex].length() + numSpaces;
        return currentMinWidth < maxWidth;
    }

    private String generateLineWithOneWord(String word, int maxWidth) {

        StringBuffer sb = new StringBuffer();
        sb.append(word).append(" ".repeat(maxWidth - word.length()));
        return sb.toString();
    }

    private String generateLineWithMoreWords(String[] words, int index, int wordCount, int spaces) {

        StringBuffer sb = new StringBuffer();

        int numSpaces = wordCount-1;
        int spaceWidth = spaces / numSpaces;
        int widerSpaces = spaces % numSpaces;

        for (int j=0; j<wordCount-1; j++) {
            sb.append(words[index+j]);
            sb.append(" ".repeat(spaceWidth));
            if (j<widerSpaces) sb.append(" ");
        }
        sb.append(words[index+wordCount-1]);

        return sb.toString();
    }
}
