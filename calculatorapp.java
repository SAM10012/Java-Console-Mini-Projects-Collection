
import java.util.*;

/*Problem Statement: Console-Based Calculator in Java
Objective:
Develop a console-based calculator application in Java that can perform basic arithmetic operations. The application should interact with the user through the command line, accept numerical inputs, and perform operations like addition, subtraction, multiplication, and division.

Functional Requirements:
Accept two numbers from the user via the console.

Prompt the user to choose an operation:

+ for addition

- for subtraction

* for multiplication

/ for division

Display the result after performing the selected operation.

Handle:

Invalid inputs (e.g., letters instead of numbers)

Division by zero (show a proper message)

Allow the user to perform multiple calculations until they choose to exit.

Non-Functional Requirements:
Code should be well-organized using methods (e.g., add(), subtract(), etc.).

Use meaningful variable and method names.

Handle exceptions using try-catch blocks where appropriate.

Keep the code modular and readable. */



public class calculatorapp {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return (a > b ? a - b : b - a);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {

            throw new ArithmeticException();
        } else
            return a / b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while (true) {
            try {
                System.out.print("Enter Number 1: ");
                int num1 = sc.nextInt();
                System.out.println();
                System.out.print("Enter Number 2: ");
                int num2 = sc.nextInt();

                sc.nextLine();
                System.out.print("Choose operation (+, -, *, /): ");
                String choice = sc.nextLine();


                switch (choice) {
                    case "+":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "-":
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case "*":
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case "/":

                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    default:
                        System.out.println("Please select from the provided options only.");
                }


            } catch (ArithmeticException e) {
                System.out.println("The Divisor is 0! Enter another number in place of 0.");
                sc.nextLine();

            } catch (InputMismatchException f) {
                System.out.println("Input should only be number. Not Alphabets or anything else.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Something went wrong! Please Check.");
            } finally {
                System.out.println("Do you want to continue(Y/N)?");
                String cont = sc.nextLine();

                if (!(cont.equals("Y") || cont.equals("y"))) {
                    break;
                }
            }


        }

        System.out.println("Thank you for using Calculator!");
    }

}
