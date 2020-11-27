package karameleva.java.fundamentals;

import java.util.Scanner;

public class JavaFundamentalsMainTask3 {
    public static void main (String [] args) {
        Scanner size = new Scanner(System.in);
        System.out.println("Введите количество случайных чисел: ");
        int sizeArr = size.nextInt();
        int[] array = new int[sizeArr];
        System.out.println("Вывод чисел с переходом на новую строку: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.println(array[i]);
        }
        System.out.println("Вывод чисел без перехода на новую строку: ");
        for (int i = 0; i < sizeArr; i++) {
            System.out.print(array[i] + " ");
        }
    }
}