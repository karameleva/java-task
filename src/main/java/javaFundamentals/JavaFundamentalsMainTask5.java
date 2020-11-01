package javaFundamentals;

import java.util.Scanner;

//---------------------------------------------------------------------------------------------
// 5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
// Осуществить проверку корректности ввода чисел.
// --------------------------------------------------------------------------------------------

public class JavaFundamentalsMainTask5 {
    public static void main (String [] args) {
        Scanner m = new Scanner(System.in);
        System.out.println("Введите число от 1 до 12: ");
        int month =  m.nextInt();
        String [] year = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь",
                "Ноябрь", "Декабрь"};
        if (month >0 && month <= year.length) {
            System.out.println(year[month - 1]);
        } else
            throw new IllegalArgumentException("Неверно введено число");
    }
}
