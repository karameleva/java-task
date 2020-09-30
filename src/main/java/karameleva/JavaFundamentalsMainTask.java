package karameleva;

import java.util.Scanner;

public class JavaFundamentalsMainTask {
    public static void main (String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.println("1. Приветствовать любого пользователя при вводе его имени через командную строку." +
                "\n2. Отобразить в окне консоли аргументы командной строки в обратном порядке.");
        System.out.println("\nВведите номер задания, которое следует выполнить: ");
        int task = t.nextInt();
        switch (task) {
            case 1: nameOutput();
            break;
            case 2: reverse();
            break;
            default: throw new IllegalArgumentException("некорректное число");
        }

    }
    public static void nameOutput () {
        // 1.Приветствовать любого пользователя при вводе его имени через командную строку.
        Scanner name = new Scanner(System.in);
        System.out.println("Введите имя");
        String userName = name.nextLine();
        System.out.println("Hello, " + userName);
    }

    public static void reverse () {
        // 2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
        Scanner v = new Scanner(System.in);
        System.out.println("Что вы хотите ввести:" +
                "\n1. строку" +
                "\n2. массив" +
                "\n1/2 : ");
        int variant = v.nextInt();
            switch (variant) {
                case 1:
                    Scanner str = new Scanner(System.in);
                    System.out.println("Введите данные");
                    String strings = str.nextLine();
                    String reverse = new StringBuffer(strings).reverse().toString();
                    System.out.println("Reverse: " + reverse);
                    break;
                case 2:
                    Scanner size = new Scanner(System.in);
                    Scanner arr = new Scanner(System.in);
                    System.out.println("Введите количество аргументов");
                    int sizeArr = size.nextInt();
                    String array [] = new String[sizeArr];
                    for (int i = 0; i < sizeArr ; i++) {
                        System.out.println("Введите "+ (i+1) + " аргумент");
                        array[i] = arr.nextLine();
                    }
                    System.out.println("Reverse: ");
                    for (int i = sizeArr-1; i >=0 ; i--) {
                        System.out.print(array[i] + " ");
                    }
                    break;
                default:
                System.out.println("введены некорректные данные");

            }

        }
    }





