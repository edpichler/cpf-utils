package com.edpichler.generators;

import com.edpichler.generators.cpf.CPFGenerator;
import com.edpichler.generators.cnpj.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratorsUtil {
    private static final String CPF_INVÁLIDO = "CPF inválido.";

    private GeneratorsUtil() {

    }

    public static String gerarCNPJ(){
        return CNPJGenerator.generate();
    }

    /**
     * @return Return n Brazilian CPFs generated.
     */
    public static List<String> gerarCPF(int quantity) {
        if (quantity < 1) {
            return Collections.emptyList();
        }
        ArrayList<String> result = new ArrayList<String>(quantity);

        for (int i = 0; i < quantity; i++) {
            String generated = CPFGenerator.generate();
            result.add(generated);
        }
        return result;
    }

    /**
     * @return a Brazilian CPF generated.
     */
    public static String gerarCPF() {
        return CPFGenerator.generate();
    }

    /**
     * Validate a CPF.
     *
     * @param cpf only numbers.
     * @throws IllegalArgumentException if the checked CPF is invalid.
     */
    public static void validateCPF(String cpf) throws IllegalArgumentException {
        cpf = cpf.trim();
        if (cpf.length() != 11) {
            throw new IllegalArgumentException(CPF_INVÁLIDO); //$NON-NLS-1$
        }

        int d1, d2;
        int soma1 = 0;
        int soma2 = 0;
        try {
            for (int i = 0; i < 9; i++) {
                soma1 += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
                soma2 += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
            }
            d1 = 11 - (soma1 % 11);
            if (d1 > 9) {
                d1 = 0;
            }

            d2 = 11 - ((soma2 + (d1 * 2)) % 11);
            if (d2 > 9) {
                d2 = 0;
            }

            if (cpf.substring(9, 11).equals("" + d1 + d2)) { //$NON-NLS-1$
                // valid
                return;
            } else {
                // invalid
                throw new IllegalArgumentException(CPF_INVÁLIDO); //$NON-NLS-1$
            }
        } catch (Throwable e) {
            // any problem, invalid CPF
            throw new IllegalArgumentException(CPF_INVÁLIDO, e); //$NON-NLS-1$
        }
    }
}