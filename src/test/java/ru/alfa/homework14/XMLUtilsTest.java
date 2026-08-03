package ru.alfa.homework14;

import org.junit.jupiter.api.Test;
import ru.alfa.homework14.part2.XMLUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLUtilsTest {
    @Test
    public void testCreateEmptyElement_ValidTag() {
        String tagName = "user";
        String expected = "<user></user>";

        String result = XMLUtils.createEmptyElement(tagName);

        assertEquals(expected, result,
                "Ошибка: для тега 'user' ожидался результат '<user></user>', но получен '" + result + "'");
    }

    @Test
    public void testCreateEmptyElement_NullTag() {
        String tagName = null;
        String expected = "<invalid/>";

        String result = XMLUtils.createEmptyElement(tagName);

        assertEquals(expected, result,
                "Ошибка: для null ожидался результат '<invalid/>', но получен '" + result + "'");
    }

    @Test
    public void testCreateEmptyElement_EmptyString() {
        String tagName = "";
        String expected = "<invalid/>";

        String result = XMLUtils.createEmptyElement(tagName);

        assertEquals(expected, result,
                "Ошибка: для пустой строки ожидался результат '<invalid/>', но получен '" + result + "'");
    }
}
