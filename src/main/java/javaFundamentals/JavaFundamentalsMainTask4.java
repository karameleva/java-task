package javaFundamentals;

//---------------------------------------------------------------------------------------------
// 4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение)
// и вывести результат на консоль.
// --------------------------------------------------------------------------------------------

public class JavaFundamentalsMainTask4 {
    public static void main (String [] args) {
        Integer sum = 0;
        Integer multiply = 1;
        for (String elem : args) {
             sum += Integer.parseInt(elem);
             multiply *= Integer.parseInt(elem);
        }
        System.out.println("Sum: " + sum);
        System.out.println("Multiply: " + multiply);
    }
}