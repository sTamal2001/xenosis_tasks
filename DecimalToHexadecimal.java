import java.util.Scanner;

public class DecimalToHexadecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int no = sc.nextInt();
        // Convert to hexadecimal Number and UpperCase
        String hexadecimal = Integer.toHexString(no).toUpperCase();
        System.out.println("Hexadecimal of " + no + " is: " + hexadecimal);
    }
}
