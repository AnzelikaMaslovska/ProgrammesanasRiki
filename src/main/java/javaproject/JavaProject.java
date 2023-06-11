package main.java.javaproject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class JavaProject {

	public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input. Please enter a valid number.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("An error occurred while closing the reader.");
                e.printStackTrace();
            }
        }
	}

}
