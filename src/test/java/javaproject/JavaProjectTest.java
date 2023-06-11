package main.java.javaproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaProjectTest {
    private final InputStream originalInputStream = System.in;
    private final PrintStream originalPrintStream = System.out;

    private ByteArrayInputStream testInputStream;
    private ByteArrayOutputStream testOutputStream;

    @BeforeEach
    public void setUp() {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalInputStream);
        System.setOut(originalPrintStream);
    }

    @Test
    public void testMainWithValidInput() {
        String input = "John\n25\n";
        testInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInputStream);

        JavaProject.main(new String[]{});

        String expectedOutput = "Enter your name: Enter your age: Name: John\nAge: 25\n";
        assertEquals(expectedOutput, testOutputStream.toString());
    }

    @Test
    public void testMainWithInvalidAgeInput() {
        String input = "Jane\ninvalid\n";
        testInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInputStream);

        JavaProject.main(new String[]{});

        String expectedOutput = "Enter your name: Enter your age: Invalid age input. Please enter a valid number.\n";
        assertEquals(expectedOutput, testOutputStream.toString());
    }
}
