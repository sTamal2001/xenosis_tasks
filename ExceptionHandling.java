import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Prompt the user to input a number
            System.out.print("Enter a number to divide 10 by: ");
            int userNumber = sc.nextInt();
            // Attempt to divide a fixed number 10 by the user-provided number
            int result = 10 / userNumber;
            System.out.println("Result: 10 / " + userNumber + " = " + result);
        } catch (Exception e) {
            // Handle any potential exceptions
            System.out.println("Error: An unexpected error occurred: " + e);
        } finally {
            // This block will always execute
            System.out.println("This is the finally block. It always executes.");
        }
    }
}