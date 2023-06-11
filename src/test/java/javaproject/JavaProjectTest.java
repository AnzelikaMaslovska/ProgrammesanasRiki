package main.java.javaproject;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaProjectTest {

    @Test
    public void testMainWithValidInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {"John", "25"};
        JavaProject.main(args);

        String expectedOutput = "Name: John\nAge: 25\n";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }

    @Test
    public void testMainWithInvalidAgeInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String[] args = {"Jane", "invalid"};
        JavaProject.main(args);

        String expectedOutput = "Invalid age input. Please enter a valid number.";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
}
