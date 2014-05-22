package com.edpichler.cpf;

/**
 * Random generator of numbers.
 */
public class NumberGenerator {

    // TODO generate array with range

    public static int[] generateArray(int size) {
        int[] retorno = new int[size];
        for (int i = 0; i < size; i++) {
            retorno[i] = (int) (Math.random() * 10);
        }
        return retorno;
    }
}