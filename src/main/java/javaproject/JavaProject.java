package main.java.javaproject;

public class JavaProject {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: JavaProject <name> <age>");
            return;
        }

        String name = args[0];
        int age;
        try {
            age = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input. Please enter a valid number.");
            return;
        }

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
