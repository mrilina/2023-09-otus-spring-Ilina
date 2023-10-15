package ru.otus.hw;

import org.junit.jupiter.api.Test;
import ru.otus.hw.service.TestService;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Юнит тесты чтения вопросов из файла.
 *
 * @author Irina Ilina
 */
public class ReadQuestionsTest {

    /**
     * Наименование файла.
     */
    private static final String CSV_NAME = "questions.csv";

    /**
     * Тестирование чтения файла из ресурсов.
     */
    @Test
    public void testReadFileWithResource() {
        InputStream is = this.getClass().getResourceAsStream("/" + CSV_NAME);
        assertNotNull(is);
    }

    /**
     * Тестирование количества вопросов в файле.
     */
    @Test
    public void testReadQuestionsAndAnswers() {
        Scanner scanner = new Scanner(TestService.class.getResourceAsStream("/" + CSV_NAME));

        int lines = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            lines++;
        }
        assertEquals(3, lines);
    }
}
