package ua.lviv.iot.algo.part1.lab5.readers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReaderTest {

    @Test
    void testReadFromConsole() {
        String expected = "text to test input from console";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        String actual = Reader.readFromConsole();
        assertEquals(expected, actual);
    }
}