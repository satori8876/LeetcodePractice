package com.example.satori8876.leetcode_60;

/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all the permutations in order, we get the following sequence for n = 3:
 *
 *     "123"
 *     "132"
 *     "213"
 *     "231"
 *     "312"
 *     "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Intuition:
 *
 * To get the first digit in the permutation, we can divide k by (n-1)!,
 * for example if n=3, (n-1)!=2; observe that
 *      the 1st two permutations start with 1,
 *      the 2nd two permutations start with 2,
 *      the 3rd two permutations start with 3.
 * This way we obtained the first digit in the permutation.
 *
 * Every next digit is obtained by repeating this process with a set of digits
 * excluding the ones we already used, with n being the number of remaining digits,
 * and k is the remainder of the previous division (dividing k by (n-1)!).
 *
 */
public class PermSequence {

    public String getPermutation(int n, int k) {
        int[] nfac = new int[]{ 1, 1, 2, 6, 24, 120, 720,
                                5040, 40320, 362880, 3628800 };
        if (k>nfac[n]) return "";

        if (k==1) {
            char[] result = new char[n];
            for (int i=1; i<=n; i++)
                result[i-1] = (char)(i+48);
            return new String(result);
        }

        int[] indices = new int[n];
        int tmp = k-1;

        for (int i=0; i<n-1; i++) {
            int next = nfac[n-i-1];
            indices[i] = tmp / next;
            tmp = tmp % next;
        }

        return translateToPermutation(indices);
    }

    String translateToPermutation(int[] indices) {

        char[] translator = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] res = new char[indices.length];
        int ind = 0;
        for (int nth : indices) {
            // get the nth non-zero element and set it to zero
            int i=0, j=0;
            while (j <= nth) {
                if (translator[i] == 0) {
                    i++;
                    continue;
                }
                i++;
                j++;
            }
            res[ind++] = translator[i-1];
            translator[i-1] = 0;
        }

        return new String(res);
    }
}