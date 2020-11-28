package karameleva.java.fundamentals;

import java.util.Scanner;

public class JavaFundamentalsMainTask5 {
    public static void main (String [] args) {
        Scanner m = new Scanner(System.in);
        System.out.println("Please, enter number from 1 t0 12: ");
        int month =  m.nextInt();
        String [] year = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        if (month >0 && month <= year.length) {
            System.out.println(year[month - 1]);
        } else
            throw new IllegalArgumentException("Invalid number");
    }
}
