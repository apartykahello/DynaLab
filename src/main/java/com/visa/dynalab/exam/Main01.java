package com.visa.dynalab.exam;

import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) {

        // Zadanie 4
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .sum();

        System.out.println(sum);
    }
}
