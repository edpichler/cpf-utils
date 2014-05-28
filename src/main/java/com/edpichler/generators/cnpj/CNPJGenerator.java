package com.edpichler.generators.cnpj;

import com.edpichler.generators.common.MyUtil;
import com.edpichler.generators.common.NumberGenerator;

/**
 * Created by eduardo.pichler on 27/05/2014.
 */
public class CNPJGenerator {

    public static String generate() {
        int[] digits = NumberGenerator.generateArray(14);
        digits[12] = 0;
        digits[13] = 0;
        // First digit
        int[] weight = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int total = 0;
        for (int i = 0; i < 12; i++)
            total += digits[i] * weight[i + 1];
        int rest = total % 11;
        if (rest < 2)
            digits[12] = 0;
        else
            digits[12] = 11 - rest;
        // Second digit
        total = 0;
        for (int i = 0; i < 13; i++)
            total += digits[i] * weight[i];
        rest = total % 11;
        if (rest < 2)
            digits[13] = 0;
        else
            digits[13] = 11 - rest;

        return MyUtil.arrayToString(digits);
    }
}
