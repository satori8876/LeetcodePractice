package com.example.satori8876.leetcode_68;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> output = new ArrayList();
        int sum = 0;
        int startIndex = 0;
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<words.length; i++) {

            int minspaces = i-1-startIndex; // minimum # of spaces
            if (sum + words[i].length() + minspaces +1 > maxWidth) {

                int nw = minspaces+1;  // # of words

                if (nw==1) {
                    sb.append(words[i-1]);
                    sb.append(" ".repeat(maxWidth - words[i - 1].length()));
                }

                else {
                    int sw = (maxWidth-sum) / (nw-1); // space width -- +1 for the first loop
                    int ws = (maxWidth-sum) % (nw-1); // # of wider spaces

                    for (int j=startIndex; j<i-1; j++) {
                        sb.append(words[j]);
                        sb.append(" ".repeat(sw));
                        if (j<startIndex+ws) sb.append(" ");
                    }
                    sb.append(words[i-1]);
                }
                output.add(sb.toString());
                sb = new StringBuffer();
                startIndex = i;
                sum = 0;
            }
            sum += words[i].length();
        }
        sb = new StringBuffer();
        sb.append(words[startIndex]);
        for (int i=startIndex+1; i<words.length; i++) {
            sb.append(" ").append(words[i]);
        }
        sb.append(" ".repeat(maxWidth - sb.length()));
        output.add(sb.toString());
        return output;
    }

}
