package com.pluralsight;

import java.util.Scanner;

class Main {
    public static void printCalculation(float num1, float num2, char symbol, float result) {
        String calculationStatement = "Calculation: " + num1 + " " + symbol + " " + num2 + " = " + result;
        System.out.println(calculationStatement);
    }

    public static float calculate(float num1, float num2, char operation) {
        float result;
        char symbol;
        switch (operation) {
            case 'A':
                result = num1 + num2;
                symbol = '+';
                break;
            case 'S':
                result = num1 - num2;
                symbol = '-';
                break;
            case 'M':
                result = num1 * num2;
                symbol = '*';
                break;
            case 'D':
                if (num2 == 0)
                    throw new IllegalArgumentException("You can't divide by zero! 😡");
                else
                    result = num1 / num2;
                symbol = '/';
                break;
            default:
                throw new IllegalArgumentException("Invalid operation 😡");
        }
        printCalculation(num1, num2, symbol, result);
        return result;
    }

    public static float takeInput(Scanner scanner) {

        System.out.print("Enter first number: ");
        float num1 = scanner.nextFloat();

        System.out.print("Please select a second number: ");
        float num2 = scanner.nextFloat();

        String[] operations = {"(A)dd", "(S)ubtract", "(M)ultiply", "(D)ivide"};
        System.out.printf("Select one from these possible calculations:%n" +
                        "    %-10s%n" +
                        "    %-10s%n" +
                        "    %-10s%n" +
                        "    %-10s%n",
                operations[0], operations[1], operations[2], operations[3]
        );
        Character operation = scanner.next().charAt(0);
        operation = Character.toUpperCase(operation);
        return calculate(num1, num2, operation);
    }

    public static void main(String[] args) {
        System.out.println("Hello, there - ready to do some math? 😊");
        Scanner scanner = new Scanner(System.in);
        float result = takeInput(scanner);
        System.out.println("Result: " + result);
        scanner.close();
    }
}