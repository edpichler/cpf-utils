package com.edpichler.cpf;

/**
 * Brazilian CPF generator.
 */
public class CPFGenerator {

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


    /**
     * Put zeros in the beginning if the cpf has less than 11 digits.
     *
     * @return "###.###.###-##"
     */
    public static String format(Long cpf) {
        String str = cpf.toString();
        if (str.length() < 11)
            for (int i = str.length(); i < 11; i++)
                str = "0" + str;
        return str.substring(0, 3) + "." + str.substring(3, 6) + "."
                + str.substring(6, 9) + "-" + str.substring(9);
    }

    /**
     * Put zeros in the beginning if the cpf has less than 11 digits.
     *
     * @return "###.###.###-##"
     */
    public static String format(String cpf) {
        Long valor = Long.valueOf(cpf);
        return format(valor);
    }
}