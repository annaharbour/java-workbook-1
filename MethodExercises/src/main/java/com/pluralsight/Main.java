package com.pluralsight;

public class Main {
    public static void brushTeeth() {
        String[] steps = {"Walk to bathroom", "Get out toothbrush and toothpaste", "Put " +
                "toothpaste on toothbrush and brush teeth"};
        int stepNum = 1;
        for (String step : steps) {
            System.out.printf("Step %d: %s\n", stepNum++, step);
        }
    }

    public static String favoriteShowOrMovie() {
        return "Girl With the Dragon Tattoo";
    }

    public static int addTwoNumbers(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        brushTeeth();
        String favoriteShowOrMovie = favoriteShowOrMovie();
        System.out.println("My favorite movie is: " + favoriteShowOrMovie + ".");
        int sum = addTwoNumbers(2, 5);
        System.out.printf("The sum is %d", sum);
    }
}