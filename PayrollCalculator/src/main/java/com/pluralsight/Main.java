package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static float calculateGrossPay(Scanner scanner) {
        System.out.println("How many hours have you worked?");
        float hours = scanner.nextFloat();
        System.out.println("What is your hourly pay rate?");
        float payRate = scanner.nextFloat();
        return hours * payRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        float grossPay = calculateGrossPay(scanner);
        System.out.printf("%s's gross pay is $%.2f", name, grossPay);
        scanner.close();
    }
}