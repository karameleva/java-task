package karameleva.java.сollections.optionaltask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTask {

    public static void main(String[] args) throws IOException {

        //Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

        String textFileWithVerse = "src/main/java/JavaCollections/OptionalTask/verse.txt";
        Scanner scan = new Scanner(new File(textFileWithVerse));

        Deque<String> verse = new ArrayDeque<>();
        while (scan.hasNextLine()) {
            verse.push(scan.nextLine());
        }

        File verseReverse = new File("src/main/java/JavaCollections/OptionalTask/verseReverse.txt");
        verseReverse.createNewFile();
        Files.write(Paths.get(String.valueOf(verseReverse)), verse );

        //Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

        List<String> sortedByLengthVerse = new ArrayList<>(verse);
        sortedByLengthVerse.sort(Comparator.comparingInt(String::length));

        File verseByLinesLength = new File("src/main/java/JavaCollections/OptionalTask/verseByLinesLength.txt");
        verseReverse.createNewFile();
        Files.write(Paths.get(String.valueOf(verseByLinesLength)), sortedByLengthVerse );

    }
}

