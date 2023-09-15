package com.example.satori8876.leetcode_51;

import java.util.*;

/**
 * The n-queens puzzle is the problem of placing n queens
 * on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        if (n<4) return edgeCases(n);

        boolean[][] table = new boolean[n][n];
        for (boolean[] row: table)
            Arrays.fill(row, true);

        Set<List<String>> solSet = new HashSet();
        List<Integer> iList = new ArrayList();
        backTrack(table, solSet, 0, n, iList);

        return new ArrayList(solSet);
    }

    List<List<String>> edgeCases(int n) {
        List<List<String>> output = new ArrayList();
        if (n==1) {
            List<String> list = new ArrayList();
            list.add("Q");
            output.add(list);
        }
        return output;
    }

    void backTrack(boolean[][] table, Set<List<String>> solSet, int k, int n, List<Integer> list) {

        if (k == n) {
            solSet.add(generateSolution(list));
            return;
        }
        for (int i=0; i<n; i++)
            if (table[i][k]) {
                list.add(i);
                boolean[][] newTable = clone2D(table);
                addToTable(newTable, i, k, n);
                backTrack(newTable, solSet, k+1, n, list);
                table[i][k] = false;
                list.remove(list.size()-1);
            }
    }

    List<String> generateSolution(List<Integer> list) {
        List<String> sList = new ArrayList();
        for (Integer elem : list) {
            char[] ca = new char[list.size()];
            for (int i=0; i<list.size(); i++)
                if (elem.equals(i))
                    ca[i] = 'Q';
                else ca[i] = '.';
            sList.add(new String(ca));
        }
        return sList;
    }

    void addToTable(boolean[][] table, int i, int k, int n) {

        for (int j=0; j<n; j++) {
            table[i][j] = false;
            table[j][k] = false;
            if (i>=j && k>=j)
                table[i-j][k-j] = false;
            if (i>=j && k+j<n)
                table[i-j][k+j] = false;
            if (i+j<n && k>=j)
                table[i+j][k-j] = false;
            if (i+j<n && k+j<n)
                table[i+j][k+j] = false;
        }
    }

    boolean[][] clone2D(boolean[][] table) {
        int n = table.length;
        boolean[][] newTable = new boolean[n][n];
        for (int ii=0; ii<n; ii++)
            System.arraycopy(table[ii], 0, newTable[ii], 0, n);
        return newTable;
    }
}
