package com.example.satori8876.leetcode_65;

/**
 * A valid number can be split up into these components (in order):
 *
 *     A decimal number or an integer.
 *     (Optional) An 'e' or 'E', followed by an integer.
 *
 * A decimal number can be split up into these components (in order):
 *
 *     (Optional) A sign character (either '+' or '-').
 *     One of the following formats:
 *         One or more digits, followed by a dot '.'.
 *         One or more digits, followed by a dot '.', followed by one or more digits.
 *         A dot '.', followed by one or more digits.
 *
 * An integer can be split up into these components (in order):
 *
 *     (Optional) A sign character (either '+' or '-').
 *     One or more digits.
 *
 * Given a string s, return true if s is a valid number.
 */

public class ValidNumber {


    public boolean isNumber(String s) {
        if (s.indexOf('e')>=0) {
            String[] sa = s.split("e");
            if (sa.length != 2)
                return false;
            if (s.indexOf('e') != s.lastIndexOf('e'))
                return false;
            return isDecimal(sa[0]) && isSignedInt(sa[1]);
        }
        if (s.indexOf('E')>=0) {
            String[] sa = s.split("E");
            if (sa.length != 2)
                return false;
            if (s.indexOf('E') != s.lastIndexOf('E'))
                return false;
            return isDecimal(sa[0]) && isSignedInt(sa[1]);
        }
        return isDecimal(s);
    }

    boolean isDecimal(String s) {

        if (s.indexOf('.')>=0) {

            if (s.startsWith("."))
                return isInteger(s.substring(1));

            if (s.startsWith("+.") || s.startsWith("-."))
                return isInteger(s.substring(2));

            if (s.endsWith("."))
                return isSignedInt(s.substring(0, s.length()-1));

            String[] sa = s.split("\\.");
            if (sa.length == 2)
                return isSignedInt(sa[0]) && isInteger(sa[1]);

            return false;
        }
        return isSignedInt(s);
    }

    boolean isSignedInt(String s) {

        if (s.isEmpty()) return false;
        char[] ca = s.toCharArray();
        if ("+-0123456789".indexOf(ca[0])<0)
            return false;

        if (ca[0]=='+'|| ca[0]=='-')
            if (ca.length==1) return false;

        for (int i=1; i<ca.length; i++)
            if (ca[i] < '0' || ca[i] > '9')
                return false;

        return true;
    }

    boolean isInteger(String s) {

        if (s.isEmpty()) return false;
        char[] ca = s.toCharArray();
        for (char c : ca)
            if (c < '0' || c > '9')
                return false;

        return true;
    }
}
