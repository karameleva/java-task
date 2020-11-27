package karameleva.java.fundamentals;

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