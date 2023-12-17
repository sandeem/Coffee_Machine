package machine;

// Import Scanner class
import java.util.Scanner;

// Define the CoffeeMachine class
public class CoffeeMachine {

    // Static variables to store the initial quantities of water, milk, beans, cups, and money
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    // Boolean variable to control the loop and exit the program
    static boolean exit = false;

    // Scanner object to take user input
    static Scanner coffee = new Scanner(System.in);

    // Main method, the entry point of the program
    public static void main(String[] args) {

        // Do-while loop to repeatedly prompt the user for actions until 'exit' is chosen
        do {
            // Prompt user for action
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = coffee.next();

            // Switch statement to handle different user actions
            switch (action) {
                case "buy":
                    toBuy(); // Call the toBuy method to handle the coffee purchase
                    break;
                case "fill":
                    toFill(); // Call the toFill method to handle filling resources
                    break;
                case "take":
                    takeFrom(); // Call the takeFrom method to handle taking money
                    break;
                case "remaining":
                    checkRemaining(); // Call the checkRemaining method to display current resources
                    break;
                case "exit":
                    exitCheck(); // Call the exitCheck method to exit the loop
                    break;
            }
        } while (!exit); // Continue looping until exit is true
    }

    // Method to handle the coffee purchase
    static void toBuy() {
        // Prompt user for coffee choice
        System.out.println();
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeChoice = coffee.next();

        // Switch statement to handle different coffee choices
        switch (coffeeChoice) {
            case "1": {
                if (sufficientCheck(250, 0, 16)) {
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                    break;
                }
            }
            case "2": {
                if (sufficientCheck(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                    break;
                }
            }
            case "3": {
                if (sufficientCheck(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    money += 6;
                    break;
                }
            }
            case "back": {
                break;
            }
        }
    }

    // Method to check if there are sufficient resources for a coffee choice
    static boolean sufficientCheck(int waterNeed, int milkNeed, int beansNeed) {
        if (water < waterNeed) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkNeed) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < beansNeed) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
        return false;
    }

    // Method to handle filling resources
    static void toFill() {
        System.out.println("Write how many ml of water you want to add:");
        int moreWater = coffee.nextInt();
        water += moreWater;
        System.out.println("Write how many ml of milk you want to add:");
        int moreMilk = coffee.nextInt();
        milk += moreMilk;
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int moreBeans = coffee.nextInt();
        beans += moreBeans;
        System.out.println("Write how many disposable cups you want to add: ");
        int moreCups = coffee.nextInt();
        cups += moreCups;
    }

    // Method to handle taking money
    static void takeFrom() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    // Method to display the current resources
    static void checkRemaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    // Method to set the exit flag to true, ending the program
    static void exitCheck() {
        exit = true;
    }
}
