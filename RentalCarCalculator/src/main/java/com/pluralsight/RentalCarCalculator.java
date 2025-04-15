package com.pluralsight;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class RentalCarCalculator {
//    NOTES

//    Step 1.
//    BASIC CAR RENTAL
//    prompt for pickup date (string)
//    convert pickup date to date object
//    prompt for # days for rental (int)
//    return basic car rental cost for 29.99 / day

//    Step 2.
//    ADDITIONAL OPTIONS
//    prompt user about additional options:
//    electronic toll tag (bool) += 3.95 per day
//    roadside assistance (bool) += 3.95 / day
//    GPS (bool) += 2.95 / day
//    return total cost of additional options

//    Step 3.
//    AGE SURCHARGE
//    prompt for current age
//    if under 25, calculate 30% surcharge to basic car rental
//    return surcharge

    //    Step 4.
//    DISPLAY:
//    total basic car rental cost for 29.99 / day
//    total cost of additional options
//    30% surcharge on basic car rental if under 25
//    total cost of rental
    public double calculateBasicRentalCost(int days) {
        return 29.99 * days;
    }

    public Date determinePickupDate(Scanner scanner) {
        System.out.println("What is your pickup date? (MM/DD/YYYY)");
        String pickupDate = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = null;
        while (true) {
            try {
                date = formatter.parse(pickupDate);
                if (date.before(
                        java.util.Date.from(LocalDate.now().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()))) {
                    throw new Exception();
                }
                break; // Exit the loop if the date is valid
            } catch (Exception e) {
                System.out.println("Invalid date format or date is in the future. Please use MM/DD/YYYY.");
                System.out.println("What is your pickup date? (MM/DD/YYYY)");
                pickupDate = scanner.nextLine(); // Prompt for input again
            }
        }
        return date;
    }

    public String determineDropOffDate(Scanner scanner, int days, Date pickupDate) {
        Date dropoffDate = new Date();
        dropoffDate.setTime(pickupDate.getTime() + (days * 24 * 60 * 60 * 1000));
        return reformatDate(dropoffDate);
    }

    public String reformatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.ENGLISH);
        return formatter.format(date);
    }

    public double calculateAgeSurcharge(int age, double basicRentalCost) {
        if (age < 25) {
            return basicRentalCost * 0.3;
        }
        return 0;
    }

    public double calculateAdditionalOptionsCost(boolean[] options, int days) {
        boolean electronicTollTag = options[0];
        boolean roadsideAssistance = options[1];
        boolean gps = options[2];
        double optionsTotal = 0;
        if (electronicTollTag) {
            optionsTotal += 3.95 * days;
        }
        if (roadsideAssistance) {
            optionsTotal += 3.95 * days;
        }
        if (gps) {
            optionsTotal += 2.95 * days;
        }
        return optionsTotal;
    }

    private static void chargeCard(Scanner scanner) {
        System.out.println("Please enter your credit card number:");
        while(true) {
            try {
                int creditCardNum = scanner.nextInt();
                System.out.println("Charging to " + creditCardNum + "...");
                break;
            } catch (Exception e) {
                System.out.println("Invalid credit card number.");
            }
        }
    }

    public boolean[] addAdditionalOptions(Scanner scanner) {
        boolean[] options = new boolean[3];
        System.out.println("Would you like to add an electronic toll tag? (type y)");
        options[0] = scanner.next().equalsIgnoreCase("y");
        System.out.println("Would you like to add roadside assistance? (type y)");
        options[1] = scanner.next().equalsIgnoreCase("y");
        System.out.println("Would you like to add GPS? (type y)");
        options[2] = scanner.next().equalsIgnoreCase("y");
        return options;
    }

    public double calculateTotalCost(double basicRentalCost, double additionalOptionsCost, double ageSurcharge) {
        return basicRentalCost + additionalOptionsCost + ageSurcharge;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Rental Car Calculator!");
        RentalCarCalculator rentalCarCalculator = new RentalCarCalculator();

//        PICKUP DATE
        Scanner scanner = new Scanner(System.in);
        Date pickUpDate = rentalCarCalculator.determinePickupDate(scanner);
        String formattedDate = rentalCarCalculator.reformatDate(pickUpDate);
        System.out.println("You are picking up your car on " + formattedDate);

//        RENTAL DAYS
//    prompt for # days for rental (int)
        System.out.print("How many days will you be renting the car?  ");
        int days = scanner.nextInt();
        System.out.println("You are renting for " + days + " days. ");
        double basicCarRentalCost = rentalCarCalculator.calculateBasicRentalCost(days);
        String dropOffDate = rentalCarCalculator.determineDropOffDate(scanner, days, pickUpDate);
        System.out.println("You are dropping off your car on " + dropOffDate);

//        AGE AND OPTIONS
        System.out.println("What is your current age?");
        int age = scanner.nextInt();
        double ageSurcharge = rentalCarCalculator.calculateAgeSurcharge(age,
                rentalCarCalculator.calculateBasicRentalCost(days));

//        ADDITIONAL OPTIONS
        boolean[] additionalOptions = rentalCarCalculator.addAdditionalOptions(scanner);
        double additionalOptionsCost = rentalCarCalculator.calculateAdditionalOptionsCost(additionalOptions, days);

//        TOTAL COST
        double totalCost = rentalCarCalculator.calculateTotalCost(basicCarRentalCost, additionalOptionsCost,
                ageSurcharge);

//        OUTPUT
        System.out.printf("Your total basic car rental cost is: $%.2f\n", basicCarRentalCost);
        System.out.printf("Your total additional options cost is: $%.2f\n", additionalOptionsCost);
        System.out.printf("Your age surcharge is: $%.2f\n", ageSurcharge);
        System.out.printf("Your total cost is: $%.2f\n", totalCost);

//        CHARGE CREDIT CARD
        rentalCarCalculator.chargeCard(scanner);
        System.out.println("Thank you for your business! \nYour car will be ready on " + formattedDate + "!");
        scanner.close();
    }
}