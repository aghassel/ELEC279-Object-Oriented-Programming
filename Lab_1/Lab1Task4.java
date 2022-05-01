import java.util.Scanner;

public class Lab1Task4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter integer:");
		int a = input.nextInt(); // Input integer 
		
		for(int i = 0; i <= 20; i++) { // loop that repeats 21 times
			System.out.println(i + "*" + a + "=" + (a*i)); // Print Multiplication table up to 20
		}
	}
}
