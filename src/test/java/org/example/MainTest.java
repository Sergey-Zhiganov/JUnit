package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class MainTest {
    @BeforeEach
    void setUp() {
        System.out.println("Начинаем тест...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен.");
    }

    @Test
    @DisplayName("Тест findWord")
    void findWordTest() {
        String text = "Этот текст содержит слово с одной буквой \"и\"";
        String expected = "содержит";

        String actual = Main.findWord(text);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3|4,5,6|7,8,9', 15",
            "'5,0,-5|-1,3,1|9,2,6', 14",
            "'10,10,10|10,10,10|10,10,10', 30"
    })
    @DisplayName("Тест findMaxDiagonalSum")
    void findMaxDiagonalSumTest(String text, int expected) {
        String[] rows = text.split("\\|");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] values = rows[i].split(",");
            matrix[i] = new int[values.length];
            for (int j = 0; j < values.length; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        int actual = Main.findMaxDiagonalSum(matrix);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест getUpperLetter")
    void getUpperLetterTest() {
        assertThrows(IllegalArgumentException.class, () -> Main.getUpperLetter(null));
    }

    @Test
    @DisplayName("Тест таймаут getUpperLetter")
    void getUpperLetterTestTimeout() {
        String text = "Ваше мнение очень важно для нас";

        assertTimeout(Duration.ofMillis(1000), () -> Main.getUpperLetter(text));
    }
}