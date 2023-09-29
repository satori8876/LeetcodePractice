package com.example.satori8876.leetcode_72;

/**
 * 72. Edit Distance
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *     Insert a character
 *     Delete a character
 *     Replace a character
 */

public class EditDistance {

    public int minDistance(String word1, String word2) {

        if (word1.equals(word2)) return 0;

        if (word2.contains(word1))
            return word2.length()-word1.length();
        if (word1.contains(word2))
            return word1.length()-word2.length();

        int[][] distance = initializeDistance(word1, word2);

        for (int i=1; i<word1.length(); i++) {

            char c1 = word1.charAt(i);
            for (int j=1; j<word2.length(); j++) {

                if (c1 != word2.charAt(j))
                    distance[i][j] = previousMin(distance, i, j) +1;
                else
                    distance[i][j] = distance[i-1][j-1];
            }
        }


        return distance[word1.length()-1][word2.length()-1];
    }

    int previousMin(int[][] distance, int i, int j) {
        int tmp = Math.min(distance[i - 1][j - 1], distance[i - 1][j]);
        return Math.min(distance[i][j - 1], tmp);
    }

    int[][] initializeDistance(String word1, String word2) {
        int[][] distance = new int[word1.length()][word2.length()];

        char c1 = word1.charAt(0);
        char c2 = word2.charAt(0);

        boolean found = (c1 == c2);
        if (c1 == c2) distance[0][0] = 0;
        else distance[0][0] = 1;

        for (int i=1; i<word1.length(); i++) {
            if (found || c2 != word1.charAt(i))
                distance[i][0] = distance[i-1][0] +1;
            else {
                distance[i][0] = distance[i-1][0];
                found = true;
            }
        }
        found = (c1 == c2);
        for (int i=1; i<word2.length(); i++) {
            if (found || c1 != word2.charAt(i))
                distance[0][i] = distance[0][i-1] +1;
            else {
                distance[0][i] = distance[0][i-1];
                found = true;
            }
        }
        return distance;
    }
}
