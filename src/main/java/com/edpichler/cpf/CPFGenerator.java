package com.edpichler.cpf;

/**
 * Brazilian CPF generator.
 */
class CPFGenerator {

    public static String generate() {
        int[] digits = NumberGenerator.generateArray(11);
        // First digit
        int total = 0;
        for (int i = 1, j = 10; i <= 9; i++, j--)
            total += digits[i - 1] * j;

        int rest = total % 11;
        if (rest < 2)
            digits[9] = 0;
        else
            digits[9] = 11 - rest;
        // Second digit
        total = 0;
        for (int i = 1, j = 11; i <= 10; i++, j--)
            total += digits[i - 1] * j;
        rest = total % 11;
        if (rest < 2)
            digits[10] = 0;
        else
            digits[10] = 11 - rest;
        return Util.arrayToString(digits);
    }
}