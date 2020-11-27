package karameleva.java.сollections.optionaltask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTask {
    public static void main(String[] args) throws IOException {
        String textFileWithVerse = "src/main/resources/verse.txt";
        Scanner scan = new Scanner(new File(textFileWithVerse));
        Deque<String> verse = new ArrayDeque<>();
        while (scan.hasNextLine()) {
            verse.push(scan.nextLine());
        }

        File verseReverse = new File("src/main/resources/verseReverse.txt");
        verseReverse.createNewFile();
        Files.write(Paths.get(String.valueOf(verseReverse)), verse );
        List<String> sortedByLengthVerse = new ArrayList<>(verse);
        sortedByLengthVerse.sort(Comparator.comparingInt(String::length));
        File verseByLinesLength = new File("src/main/resources/verseByLinesLength.txt");
        verseReverse.createNewFile();
        Files.write(Paths.get(String.valueOf(verseByLinesLength)), sortedByLengthVerse );
    }
}