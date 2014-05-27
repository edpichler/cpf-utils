package com.edpichler.generators.common;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    /**
     * eg: number = 1234, returns { 1, 2, 3, 4 }
     *
     * @param number a long, see Long.MAX_VALUE and Long.MIN_VALUE
     * @return one array of digits
     */
    public static int[] longToArray(final long number) {
        long n = number;
        List<Long> list = new ArrayList<Long>(10);
        do {
            list.add(n % 10);
            n /= 10;
        } while (n != 0);
        int length = list.size();
        int[] digits = new int[length];
        for (int i = length - 1, j = 0; i >= 0; i--, j++)
            digits[j] = list.get(i).intValue();
        return digits;
    }

    public static String arrayToString(int[] digits) {
        StringBuffer buf = new StringBuffer(digits.length);
        for (int i = 0; i < digits.length; i++) {
            buf.append(digits[i]);
        }
        return buf.toString();
    }
}