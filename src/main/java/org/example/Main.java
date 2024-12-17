package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static String findWord(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не может быть пустым");
        }

        String[] words = text.split("\\s+");
        String result = "";
        int maxCount = 0;

        for (String word : words) {
            int count = (int) word.chars().filter(c -> c == 'И' || c == 'и').count();
            if (count > maxCount) {
                maxCount = count;
                result = word;
            }
        }
        return result;
    }

    public static int findMaxDiagonalSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length != matrix.length) {
            throw new IllegalArgumentException("Матрица должна быть не пустой и квадратной");
        }

        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            firstSum += matrix[i][i];
            secondSum += matrix[i][matrix.length - i - 1];
        }

        return Math.max(firstSum, secondSum);
    }

    public static String getUpperLetter(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст не может быть пустым");
        }

        return Arrays.stream(text.split("\\s+"))
                .map(word -> String.valueOf(word.charAt(0)).toUpperCase())
                .collect(Collectors.joining());
    }
}