package com.pluralsight;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
//        Question 1
        BigDecimal bobSalary = new BigDecimal(50000);
        BigDecimal garySalary = new BigDecimal( 60000);
        BigDecimal highestSalary = bobSalary.max(garySalary);
//Question 2
        BigDecimal carPrice = new BigDecimal(14000.99);
        BigDecimal truckPrice = new BigDecimal(19999.99);
        BigDecimal cheapestVehicle = carPrice.min(truckPrice);
        cheapestVehicle = cheapestVehicle.setScale(2, BigDecimal.ROUND_HALF_EVEN);
//Question 3
        double radius = 7.25;
        double area = Math.PI * Math.pow(radius, 2);
//Question 4
        double x = 5.0;
        double squareRoot = Math.sqrt(x);

//Question 5
        int[][] points = {{5, 10}, {85, 50}};
        double distance = Math.sqrt(
                Math.pow(points[0][1] - points[0][0], 2) + Math.pow(points[1][1] - points[1][0], 2));
//Question 6
        double num = -3.8;
        double positiveNum = Math.abs(num);
//Question 7
        int min = 0;
        int max = 1;
//        random double within range of min and max
        double randomD = min + (max - min) * Math.random();


        Object[][] qas = {
                {"1. The highest salary is... $", highestSalary},
                {"2. The lowest car price is... $", cheapestVehicle},
                {"3. The area of the circle is...", area},
                {"4. The square root is...", squareRoot},
                {"5. The distance is...", distance},
                {"6. The absolute value is...", positiveNum},
                {"7. The random number is...", randomD}
        };

        for (Object[] qa : qas) {
            System.out.printf(qa[0] + " " + qa[1] + "%n");
        }
    }
}