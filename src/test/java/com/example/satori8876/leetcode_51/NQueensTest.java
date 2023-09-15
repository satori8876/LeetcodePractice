package com.example.satori8876.leetcode_51;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTest {

    private NQueens nq = new NQueens();

    @Test
    public void test1Queen() {
        List<List<String>> expected = new ArrayList();
        List<String> list = new ArrayList();
        list.add("Q");
        expected.add(list);

        List<List<String>> actual = nq.solveNQueens(1);

        assertEquals(expected, actual);
    }

    @Test
    public void test2Queens() {
        List<List<String>> expected = new ArrayList();
        List<List<String>> actual = nq.solveNQueens(2);

        assertEquals(expected, actual);
    }

    @Test
    public void test3Queens() {
        List<List<String>> expected = new ArrayList();
        List<List<String>> actual = nq.solveNQueens(3);

        assertEquals(expected, actual);
    }

    @Test
    public void test4Queens() {

        List<List<String>> expected = new ArrayList();

        expected.add(Arrays.asList(new String[]{".Q..","...Q","Q...","..Q."}));
        expected.add(Arrays.asList(new String[]{"..Q.","Q...","...Q",".Q.."}));

        List<List<String>> actual = nq.solveNQueens(4);

        assertEquals(expected, actual);
    }

    @Test
    public void test5Queens() {

        List<List<String>> expected = new ArrayList();

        expected.add(Arrays.asList(".Q...", "...Q.", "Q....", "..Q..", "....Q"));
        expected.add(Arrays.asList("..Q..", "Q....", "...Q.", ".Q...", "....Q"));
        expected.add(Arrays.asList("..Q..", "....Q", ".Q...", "...Q.", "Q...."));
        expected.add(Arrays.asList("...Q.", ".Q...", "....Q", "..Q..", "Q...."));
        expected.add(Arrays.asList("....Q", ".Q...", "...Q.", "Q....", "..Q.."));
        expected.add(Arrays.asList("....Q", "..Q..", "Q....", "...Q.", ".Q..."));
        expected.add(Arrays.asList("Q....", "..Q..", "....Q", ".Q...", "...Q."));
        expected.add(Arrays.asList("Q....", "...Q.", ".Q...", "....Q", "..Q.."));
        expected.add(Arrays.asList(".Q...", "....Q", "..Q..", "Q....", "...Q."));
        expected.add(Arrays.asList("...Q.", "Q....", "..Q..", "....Q", ".Q..."));

        List<List<String>> actual = nq.solveNQueens(5);

        assertEquals(expected, actual);
    }

    @Test
    public void test6Queens() {
        List<List<String>> expected = new ArrayList();
        expected.add(List.of(".Q....", "...Q..", ".....Q", "Q.....", "..Q...", "....Q."));
        expected.add(List.of("...Q..", "Q.....", "....Q.", ".Q....", ".....Q", "..Q..."));
        expected.add(List.of("..Q...", ".....Q", ".Q....", "....Q.", "Q.....", "...Q.."));
        expected.add(List.of("....Q.", "..Q...", "Q.....", ".....Q", "...Q..", ".Q...."));

        List<List<String>> actual = nq.solveNQueens(6);

        assertEquals(expected, actual);
    }

    @Test
    public void test7Queens() {
        List<List<String>> actual = nq.solveNQueens(7);

        assertEquals(40, actual.size());
    }

    @Test
    public void test8Queens() {
        List<List<String>> actual = nq.solveNQueens(8);

        assertEquals(92, actual.size());
    }

    @Test
    public void test9Queens() {
        List<List<String>> actual = nq.solveNQueens(9);

        assertEquals(352, actual.size());
    }

}
