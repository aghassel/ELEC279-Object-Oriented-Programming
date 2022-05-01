package lab4;

import java.util.Arrays;
import java.util.Date;

public class Lab4 {

    public static void main(String[] args) {
        // Part 1
        HourlyEmployee[] staff = new HourlyEmployee[5];
        Date theDate = new Date(2005 - 1900, 1, 1);
        for (int i = 0; i < 5; i++) {
            theDate.setYear(2005 + i - 1900);
            staff[i] = new HourlyEmployee("Alice" + (5 - i), (Date) theDate.clone(), 15.0, 10 + i * 4.0);
        }

        for (HourlyEmployee temp : staff) {
            System.out.println(temp.toString());
        }

        Arrays.sort(staff);

        for (HourlyEmployee temp : staff) {
            System.out.println(temp.toString());
        }

        // Part 2
        Invoice[] bills = new Invoice[5];
        for (int i = 0; i < 5; i++) {
            bills[i] = new Invoice("Company" + (5 - i), 300.0 - 50.0 * i);
        }

        for (Invoice temp : bills) {
            System.out.println(temp.toString());
        }

        Arrays.sort(bills);

        for (Invoice temp : bills) {
            System.out.println(temp.toString());
        }

        // Part 3
        for (PayAble temp : (PayAble[]) bills) {
            temp.printPayment();
        }

        // Part 4
        PayAble[] pending = new PayAble[10];

        for (int i = 0; i < 5; i++) {
            pending[i] = (PayAble) bills[i];
        }

        for (int i = 0; i < 5; i++) {
            pending[i + 5] = (PayAble) staff[i];
        }

        for (PayAble temp : pending) {
            temp.printPayment();
        }
    }
}
