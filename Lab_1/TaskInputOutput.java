import java.util.Scanner;

public class TaskInputOutput {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer 1:");
		int a = input.nextInt(); // Input integer 1
		
		System.out.println("Enter integer 2:");
		int b = input.nextInt(); // Input integer 2
		
		
		System.out.println("Sum: " + (a+b)); // Prints Sum
		System.out.println("Product: "+ (a*b)); // Prints Product
	}
}
