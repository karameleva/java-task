package karameleva.java.fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class JavaFundamentalsOptionalTask {

    public static Integer[] inputArray ( ) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество цифр: ");
        int size = scan.nextInt();
        Integer [] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите число: ");
            array[i] = scan.nextInt();
        }
        return array;
    }
    public static int getNumberOfDifDigs(int[] b) {
        int numberOfDifDigs = 1;
        if (b.length > 0) {
            for (int i = 1; i < b.length; i++) {
                numberOfDifDigs = b[i] > b[i - 1] ? ++numberOfDifDigs : numberOfDifDigs;
            }
        } else numberOfDifDigs = 1;
        return numberOfDifDigs;
    }
    public static int[] numberToArray(Integer a) {
        int[] aArray = new int[a.toString().length()];
        for (int i = a.toString().length() - 1; i >= 0; i--) {
            aArray[i] = a % 10;
            a /= 10;
        }
        return aArray;
    }
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int task = 0;
        while (task != 8) {
            System.out.println("\n---------------------------------------------------------------------------------" +
                    "\n1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину." +
                    "\n2. Вывести числа в порядке возрастания (убывания) значений их длины." +
                    "\n3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, " +
                    "а также длину." +
                    "\n4. Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, " +
                    "найти первое из них." +
                    "\n5. Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество " +
                    "чисел с равным числом четных и нечетных цифр." +
                    "\n6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел " +
                    "несколько, найти первое из них." +
                    "\n7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, " +
                    "найти первое из них." +
                    "\n8. Выход");
            System.out.println("\nВведите номер задания, которое следует выполнить: ");
            task = t.nextInt();
            switch (task) {
                case 1:
                    searchMaxMinLength();
                    break;
                case 2:
                    sort();
                    break;
                case 3:
                    average();
                    break;
                case 4:
                    differentDigitsMin();
                    break;
                case 5:
                    findEverAndOdd();
                    break;
                case 6:
                    ascendingOrder();
                    break;
                case 7:
                    differentDigits();
                    break;
                case 8:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Вы ввели некорректное число. Попробуйте ещё раз");
            }
        }
    }

    public static void searchMaxMinLength() {
        Integer[] array = inputArray();
        int max = array[0].toString().length();
        int min = array[0].toString().length();
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i].toString().length());
            min = Math.min(min, array[i].toString().length());
        }
        if (max != min) {
            System.out.print("Длина самых коротких чисел составляет " + min + ". Это числа: ");
            for (Integer elem : array) {
                if (elem.toString().length() == min)
                    System.out.print(elem + "; ");
            }
            System.out.print("\nДлина самых длинных чисел составляет " + max + ". Это числа: ");
            for (Integer elem : array) {
                if (elem.toString().length() == max)
                    System.out.print(elem + "; ");
            }
        } else System.out.println("Все числа имеют одинаковую длину " + min + ".");
    }

    public static void sort() {
        Integer[] array = inputArray();
        boolean swap = false;
        for (int i = 1; (i < array.length) && !swap; i++) {
            swap = array[0].toString().length() != array[i].toString().length();
        }
        if (swap) {
            int buf = 0;
            while (swap) {
                swap = false;
                for (int i = 0; i < (array.length - 1); i++) {
                    if (array[i].toString().length() > array[i + 1].toString().length()) {
                        buf = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = buf;
                        swap = true;
                    }
                }
            }
            System.out.println("Числа в порядке возрастания значений их длины: " + Arrays.toString(array));
            swap = true;
            while (swap) {
                swap = false;
                for (int i = 0; i < (array.length - 1); i++) {
                    if (array[i].toString().length() < array[i + 1].toString().length()) {
                        buf = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = buf;
                        swap = true;
                    }
                }
            }
            System.out.println("Числа в порядке убывания значений их длины: " + Arrays.toString(array));
        } else {
            System.out.println("Все числа одной длины");
        }
    }

    public static void average() {
        Integer[] array = inputArray();
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].toString().length();
        }
        double aver =  sum / array.length;
        System.out.println("Средняя длина чисел: " +  aver);
        System.out.print("Числа, длина которых меньше средней (длина числа): ");
        for (Integer elem : array) {
            if (elem.toString().length() < aver) {
                System.out.print(elem + " (" + elem.toString().length() + "); ");
            }
        }
        System.out.print("\nЧисла, длина которых больше средней (длина числа): ");
        for (Integer elem : array) {
            if (elem.toString().length() > aver) {
                System.out.print(elem + " (" + elem.toString().length() + "); ");
            }
        }
    }

    public static void differentDigitsMin() {
        Integer[] array = inputArray();
        int[] arraySort = numberToArray(array[0]);
        Arrays.sort(arraySort);
        int match = getNumberOfDifDigs(arraySort);
        Integer numberWithMinDifDigs = array[0];

        for (int i = 1; i < array.length; i++) {
            arraySort = numberToArray(array[i]);
            Arrays.sort(arraySort);
            int matchTemp = getNumberOfDifDigs(arraySort);
            numberWithMinDifDigs = matchTemp < match ? array[i] : numberWithMinDifDigs;
            match = Math.min(match, matchTemp);
        }
        System.out.println("Первое число с минимальным количеством различных цифр: " + numberWithMinDifDigs);
    }

    public static void findEverAndOdd() {
        Integer[] array = inputArray();
        int numberOfEver = 0;
        int numberOfOddAndEver = 0;
        for (Integer elem : array) {
            int ever = 0;
            int odd = 0;
            int[] arrayDig = numberToArray(elem);
            for (int i = 0; i < arrayDig.length; i++) {
                if (arrayDig[i] != 0) {
                    int remainder = arrayDig[i] % 2;
                    ever = remainder == 0 ? ++ever : ever;
                    odd = remainder != 0 ? ++odd : odd;
                }
            }
            numberOfEver = ever == elem.toString().length() ? ++numberOfEver : numberOfEver;
            numberOfOddAndEver = ever == odd ? ++numberOfOddAndEver : numberOfOddAndEver;
        }
        System.out.println("Количество чисел, содержащих только четные цифры: " + numberOfEver);
        System.out.println("Количество чисел с равным числом четных и нечетных цифр: " + numberOfOddAndEver);
    }

    public static void ascendingOrder() {
        boolean findFirstAscNum = false;
        Integer[] array = inputArray();
        int i;
        for (i = 0; (i < array.length) && !findFirstAscNum; i++) {
            int[] arrDig = numberToArray(array[i]);
            boolean flag = true;
            if (arrDig.length > 1 ) {
                for (int j = 1; j < arrDig.length && flag; j++) {
                    flag = arrDig[j] > arrDig[j - 1];
                }
                findFirstAscNum = flag;
            }
        }
        if (findFirstAscNum) {
            System.out.println("Первое число, в котором цифры идут в строгом порядке возрастания " + array[i-1]);
        } else {
            System.out.println("Число не найдено");
        }
    }

    public static void differentDigits () {
        Integer [] array = inputArray();
        boolean numberWithDifDigs = false;
        int i;
        for (i = 0; i < array.length && !numberWithDifDigs; i++) {
            int [] arrDig = numberToArray (array[i]);
            Arrays.sort(arrDig);
            if (arrDig.length > 1) {
                int difDig = getNumberOfDifDigs(arrDig);
                numberWithDifDigs = difDig == arrDig.length;
            }
        }
        if (numberWithDifDigs) {
            System.out.println("Первое число, состоящее из различных цифр " + array [i-1]);
        } else {
            System.out.println("число, состоящее из различных цифр не найдено");
        }
    }
}