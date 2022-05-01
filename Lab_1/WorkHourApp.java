import java.util.Scanner;

public class WorkHourApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter worked hours per day: ");
		int hoursperday = input.nextInt(); // Enter Work hours per day

		System.out.println("Enter Number of days worked: ");
		int numdays = input.nextInt(); // Enter Work hours per day

		for (int i = 1; i <= numdays; i++) {
			System.out.print("Day " + i + ","); // Print day number
			System.out.print(" Total Hours Worked: " + (i * hoursperday)); // Print total hours worked
			System.out.println(); // Print blank line
		}
	}
};