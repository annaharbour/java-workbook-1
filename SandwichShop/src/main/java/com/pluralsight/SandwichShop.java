package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public float calculateSandwichPrice(float sandwichOrder, float discount) {
        float sandwichPrice = 0.0f;
        if(sandwichOrder == 1) {
            sandwichPrice = 5.45f;
        } else if (sandwichOrder == 2) {
            sandwichPrice = 8.95f;
        } else {
            System.out.println("Invalid selection.");
        }
        sandwichPrice = sandwichPrice - (sandwichPrice * discount);
        return sandwichPrice - (sandwichPrice * discount);
    }
    public float getDiscount(float age) {
        float discount = 0.0f;
        if(age < 18) {
            discount = .1f;
            System.out.println("You qualify for a 10% discount.");
        } else if (age >= 65) {
            discount = .20f;
            System.out.println("You qualify for a 20% discount.");
        }
        return discount;
    }
    public static void main(String[] args) {
        SandwichShop sandwichShop = new SandwichShop();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Sandwich Shop!");
        System.out.printf("What size sandwich would you like? %n 1. Regular: base price $5.45 %n 2. Large: base " +
                "price $8.95 %n");
        int sandwichOrder = scanner.nextInt();
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        scanner.close();
        float total = sandwichShop.calculateSandwichPrice(sandwichOrder, sandwichShop.getDiscount(age));
        System.out.printf("Your total is: $%.2f", total);
    }
}