


import java.util.Scanner;

public class Calculator {

    // Implementation of methods 
    static void addition(double x, double y) {
        double result = x + y;
        System.out.println("Addition of " + x + " and " + y + " is : " + result);
    }

    static void subtration(double x, double y) {
        double result = x - y;
        System.out.println("Diffrence of " + x + " and " + y + " is : " + result);
    }

    static void multiplication(double x, double y) {
        double result = x * y;
        System.out.println("Product of " + x + " and " + y + " is : " + result);
    }

    static void division(double x, double y) {
        if (y == 0)
            System.out.println("Invalid Input : Please enter a valid number ");
        else {
            double result = x / y;
            System.out.println("Result of " + x + "/" + y + " is : " + result);
        }

    }

    public static void main(String[] args) {

        char operator;
        double number1, number2;

        // create an object of Scanner class
        Scanner input = new Scanner(System.in);

        // ask users to enter operator
        System.out.println("Choose an operator: +, -, *, or /");
        operator = input.next().charAt(0);

        // ask users to enter numbers
        System.out.println("Enter first number");
        number1 = input.nextDouble();

        System.out.println("Enter second number");
        number2 = input.nextDouble();

        switch (operator) {

            // performs addition between numbers
            case '+':
                addition(number1, number2);
                break;

            // performs subtraction between numbers
            case '-':
                subtration(number1, number2);
                break;

            // performs multiplication between numbers
            case '*':
                multiplication(number1, number2);
                break;

            // performs division between numbers
            case '/':
                division(number1, number2);
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }

        input.close();
    }

}
