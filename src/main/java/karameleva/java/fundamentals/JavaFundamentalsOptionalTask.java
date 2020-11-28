package karameleva.java.fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class JavaFundamentalsOptionalTask {

    public static Integer[] inputArray ( ) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter amount of numbers: ");
        int size = scan.nextInt();
        Integer [] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Please, enter a number: ");
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
                    "\n1. Find the shortest and longest number. Print the found numbers and their length." +
                    "\n2. Print numbers in ascending (descending) order of their lengths." +
                    "\n3. Print numbers which length is less (more) than the average length for all numbers and length."+
                    "\n4. Find the number in which amount of different digits is minimal. " +
                    "If there are several numbers, find the first one." +
                    "\n5. Find amount of numbers with only even digits, and among the rest -" +
                    "numbers with equal amount of  odd and even digits. " +
                    "\n6. Find the number with digits in strict ascending order. If there are several numbers, find the first one." +
                    "\n7. Find the number with only different digits. If there are several numbers, find the first one." +
                    "\n8. Exit");
            System.out.println("\nPlease, choose the number af the task: ");
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
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("You entered incorrect number. Please, try one more time: ");
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
            System.out.print("The length of the shortest numbers is " + min + ". That numbers are: ");
            for (Integer elem : array) {
                if (elem.toString().length() == min)
                    System.out.print(elem + "; ");
            }
            System.out.print("\nThe length of the longest numbers is " + max + ". That numbers are: ");
            for (Integer elem : array) {
                if (elem.toString().length() == max)
                    System.out.print(elem + "; ");
            }
        } else System.out.println("All numbers are the same length " + min + ".");
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
            System.out.println("The numbers in ascending order of their length: " + Arrays.toString(array));
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
            System.out.println("The numbers in descending order of their length: " + Arrays.toString(array));
        } else {
            System.out.println("All numbers are the same length");
        }
    }

    public static void average() {
        Integer[] array = inputArray();
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].toString().length();
        }
        double aver =  sum / array.length;
        System.out.println("Average length of the numbers is " +  aver);
        System.out.print("The numbers with length which is less then average (length of the number): ");
        for (Integer elem : array) {
            if (elem.toString().length() < aver) {
                System.out.print(elem + " (" + elem.toString().length() + "); ");
            }
        }
        System.out.print("\nThe numbers with length which is more then average (length of the number): ");
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
        System.out.println("First number with min amount of different digits: " + numberWithMinDifDigs);
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
        System.out.println("Amount of the numbers containing only even digits is " + numberOfEver);
        System.out.println("Amount of the numbers containing equal amount of  odd and even digits: " + numberOfOddAndEver);
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
            System.out.println("First number with digits in strict ascending order is " + array[i-1]);
        } else {
            System.out.println("Required number isn't found");
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
            System.out.println("First number containing only different digits is " + array [i-1]);
        } else {
            System.out.println("Required number isn't found");
        }
    }
}