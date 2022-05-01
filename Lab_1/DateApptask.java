import java.util.Date;

public class DateApptask {
	public static void main(String[] args) {
		Date todaysdate = new Date();
		System.out.println(todaysdate);

		int min = 10, max = 20, average = 5; // Initialize the variables
		String myrole = "Driver";
		byte myfirstByte = 22; // Initializes a byte type
		double pi = 3.14159; // Declares a pi to be variable of type double
		char mychar = 'N'; // Variable type Char

		System.out.println("I am now the " + myrole); // Print integer
		System.out.println("Our minimum score is " + min); // Print String
		System.out.println("We have a byte " + myfirstByte); // Print byte
		System.out.println("And double type is " + pi); // Print double
		System.out.println("A char looks like " + mychar); // Print character

		int count = 1; // Counter variable
		while (count <= 10) {
			System.out.println(todaysdate);
			count = count + 1;
		}
		
		for(count = 1; count <= 15; count++) {
			System.out.println(todaysdate);
		}
		
		for(int row = 1; row<=5; row++) {
			for(int column = 1; column <= 10; column++) {
				System.out.print(row*column + "\t"); // Print rows
			}
			System.out.println(); // New row
		}
	}
}
