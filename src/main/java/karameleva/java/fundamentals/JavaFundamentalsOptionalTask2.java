package karameleva.java.fundamentals;

import java.util.Random;
import java.util.Scanner;

public class JavaFundamentalsOptionalTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int task = 0;
        while (task != 5) {
            System.out.println("\n---------------------------------------------------------------------------------" +
                    "\nEnter n - size of the array a [n] [n]. Value of the elements should be set between -M and M " +
                    "and generated with the Random class." +
                    "\n1. Order the rows (columns) of the array in ascending order of the k-th column (row) elements values." +
                    "\n2. Find the largest number of increasing (decreasing) elements in the array, going in a row." +
                    "\n3. Find sum of the elements between first and second positive elements in each row." +
                    "\n4. Find the max element in the array and delete all rows and columns containing it. " +
                    "\n5. Exit");
            System.out.println("\nPlease, choose the number of the task: ");
            task = scan.nextInt();
            switch (task) {
                case 1:
                    task1(scan);
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Incorrect number. Please try again: ");
            }
        }
    }

    public static int[][] inputArray() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter size of the array N: ");
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        System.out.println("Please, enter range for array elements' value M ");
        int m = scan.nextInt();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextInt(2 * m + 1);
                a[i][j] -= m;
            }
        }
        return a;
    }

    public static void outputArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void task1(Scanner scan) {
        int[][] a = inputArray();
        System.out.println("Initial array ");
        outputArray(a);
        System.out.println("Please, enter number of column according to which rows' sorting should be done: ");
        int k = scan.nextInt();
        boolean swap = true;
        int[][] buf = new int[1][a.length];
        while (swap) {
            swap = false;
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1][k] > a[i][k]) {
                    swap = true;
                    for (int j = 0; j < a.length; j++) {
                        buf[0][j] = a[i - 1][j];
                        a[i - 1][j] = a[i][j];
                        a[i][j] = buf[0][j];
                    }
                }
            }
        }
        System.out.println("Result");
        outputArray(a);
    }

    public static void task2() {
        int[][] a = inputArray();
        System.out.println("Initial array");
        outputArray(a);
        int[] b = new int[a.length * a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[j + a.length * i] = a[i][j];
            }
        }
        int max = 0;
        int maxTemp = 0;
        for (int i = 1; i < b.length; i++) {
            if (b[i] > b[i - 1]) {
                maxTemp++;
            } else {
                max = Math.max(max, maxTemp);
                maxTemp = 0;
            }
        }
        max = Math.max(max, maxTemp);
        maxTemp = 0;
        if (max > 0) {
            System.out.println("The largest number of increasing elements in the array, going in a row is" + (max + 1) +
                    "\nThat are numbers: ");
            for (int i = 1; i < b.length; i++) {
                if (b[i] > b[i - 1]) {
                    maxTemp++;
                } else {
                    if (maxTemp == max) {
                        for (int j = (i - max - 1); j < i; j++) {
                            System.out.print(b[j] + "; ");
                        }
                        System.out.println(" ");
                    }
                    maxTemp = 0;
                }
            }
            if (maxTemp == max) {
                for (int j = b.length - max - 1; j < b.length; j++) {
                    System.out.print(b[j] + "; ");
                }
            }
            System.out.println(" ");
        } else {
            System.out.println("Required numbers are not found");
        }
    }

    public static void task3() {
        int[][] a = inputArray();
        System.out.println("Initial array");
        outputArray(a);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int positive = 0;
            int posFirst = -1;
            int posSecond = -1;
            for (int j = 0; j < a.length && positive < 2; j++) {
                if (a[i][j] > 0) {
                    positive++;
                    posFirst = positive == 1 ? j : posFirst;
                    posSecond = positive == 2 ? j : posSecond;
                }
            }
            if (posSecond != -1) {
                for (int j = posFirst + 1; j < posSecond; j++) {
                    sum += a[i][j];
                }
            }
        }
        System.out.println("Sum of required elements: " + sum);
    }

    public static void task4() {
        int[][] a = inputArray();
        System.out.println("Initial array");
        outputArray(a);
        int max = -a.length;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                int maxTemp = Math.max(a[i][j - 1], a[i][j]);
                max = Math.max(maxTemp, max);
            }
        }
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (a[i][j] == max){
                    if (i != length-1 && j != length-1) {
                        deleteRow(length, i, a);
                        deleteColumn(length, j, a);
                        length--;
                    } else if (i != length-1 && j == length-1) {
                        deleteRow(length, i, a);
                        length--;
                    } else if (i == length-1 && j != length-1) {
                        deleteColumn(length, j, a);
                        length--;
                    } else {
                        length--;
                    }
                }
            }
        }
        System.out.println("Maximum: " + max);
        System.out.println("Result");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static int[][] deleteRow (int length, int i, int [][] a) {
        for (int k = i; k < length-1; k++) {
            for (int j = 0; j < length; j++) {
                a[k][j] = a[k + 1][j];
            }
        }
        return a;
    }

    private static int[][] deleteColumn (int length, int j, int [][] a) {
        for (int k = j; k < length-1; k++) {
            for (int i = 0; i < length; i++) {
                a[i][k] = a[i][k + 1];
            }
        }
        return a;
    }
}