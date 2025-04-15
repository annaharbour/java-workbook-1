package com.pluralsight;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] items = {"kale", "spinach", "carrots", "cantaloupe", "grapes", "flaxseed", "almonds", "beets",
                "dates", "chocolate walnuts"};
        System.out.println("Shopping List");
        System.out.println("----------------");
        for (String item : items) {
            System.out.println(item);
        }
    }
}