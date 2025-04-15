package com.pluralsight;

public class Main {
    private static String printType(Object o) {
        return o.getClass().getSimpleName();
    }

    public static void main(String[] args) {
        String vehicleIdentificationNumber = "1F6A1234567890123";
        String vehicleMakeModel = "Ford Explorer";
        String vehicleColor = "red";
        boolean hasTowingPackage = true;
        float odometerReading = 999999.9f;
        //   doubles more precise than floats
        //for financial calculations where you require decimal exactness, you might use BigDecimals, then set
        // scale/rounding mode
        double price = 19999.99;
        char qualityRating = 'A';
        //could also use a long if I wanted a number or an int if I excluded the 1. Choosing string due to potential
        // leading 0's at the front which would be lost in an int
        String phoneNumber = "15555555555";
        //9 digits, so also within scope of int
        long socialSecurityNumber = 555_55_5555L;
        int zipCode = 28226;

        //2D Array to store questions and answers
        Object[][] qas = {
                {"a vehicle identification number in the range 1000000 - 9999999", vehicleIdentificationNumber},
                {"a vehicle make / model(i.e.Ford Explorer)", vehicleMakeModel},
                {"a vehicle color", vehicleColor},
                {"whether the vehicle has a towing package", hasTowingPackage},
                {"an odometer reading", odometerReading},
                {"a price", price},
                {"a quality rating(A, B, or C)", qualityRating},
                {"a phone number", phoneNumber},
                {"a social security number", socialSecurityNumber},
                {"a zip code", zipCode}
        };

        System.out.println("Data Types");
        System.out.println("----------------");
        for (Object[] qa : qas) {
            System.out.printf(qa[0] + " : " + qa[1] + " (" + printType(qa[1]) + ")" +
                    "%n");
        }
    }
};