package JavaCollections.MainTask;

// Задание. Создать консольное приложение, удовлетворяющее следующим требованиям:
// Каждый класс должен иметь отражающее смысл название и информативный состав.
// Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
// Наследование должно применяться только тогда, когда это имеет смысл.
// При кодировании должны быть использованы соглашения об оформлении кода java code c
// Для хранения параметров инициализации можно использовать файлы.
//
// Новогодний подарок. Определить иерархию конфет и прочих сладостей.
// Создать несколько объектов-конфет. Собрать детский подарок с определением его веса.
// Провести сортировку конфет в подарке на основе одного из параметров.
// Найти конфету в подарке, соответствующую заданному диапазону содержания сахара.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static JavaCollections.MainTask.FlourConfectionType.BISCUITS;
import static JavaCollections.MainTask.FlourConfectionType.GINGERBREAD;
import static JavaCollections.MainTask.SweetsType.CARAMEL;
import static JavaCollections.MainTask.SweetsType.CHOCOLATE;


public class MainTask {
    public static void main (String [] args) {
        List<Confectionery> confectioneries = new ArrayList<>();
        confectioneries.add(new FlourConfection("Мария (уп)", 45, 13, 100, BISCUITS));
        confectioneries.add(new FlourConfection("Тульский", 55, 12, 70, GINGERBREAD));
        confectioneries.add(new Sweets("Аэрофлотские", 60, 18, 12, CHOCOLATE));
        confectioneries.add(new Sweets("Грильяж", 45, 25, 22, CHOCOLATE));
        confectioneries.add(new Sweets("Алёнка", 55, 19, 16, CHOCOLATE));
        confectioneries.add(new Sweets("Столичные", 56, 15.5, 17, CHOCOLATE));
        confectioneries.add(new Sweets("Батончик", 52, 14, 19, CHOCOLATE));
        confectioneries.add(new Sweets("Марс", 51, 25, 16, CHOCOLATE));
        confectioneries.add(new Sweets("Сникерс", 54, 28, 25, CHOCOLATE));
        confectioneries.add(new Sweets("Баунти", 52, 24, 21, CHOCOLATE));
        confectioneries.add(new Sweets("Дюшес", 65, 8, 6, CARAMEL));
        confectioneries.add(new Sweets("Клубничные", 66, 8.5, 7, CARAMEL));
        confectioneries.add(new Sweets("Рачки", 68, 10, 9, CARAMEL));

        NewYearPresent present = new NewYearPresent(confectioneries);

        Map<SweetsType, Integer> sweetsMap = present.getSweetsMap();
        Map <FlourConfectionType, Integer> flourConfectionMap = present.getFlourConfectionMap();
        List <Confectionery> newYearPresent = present.getNewYearPresent(sweetsMap, flourConfectionMap);

        present.printNewYearPresent(newYearPresent, sweetsMap, flourConfectionMap);

        double presentWeight = present.getNewYearPresentWeight ( newYearPresent, sweetsMap, flourConfectionMap);
        System.out.println("\nВес подарка: " + presentWeight + " гр.");

        List <Sweets> sweets = present.getSweetsListInNewYearPresent(newYearPresent);
        System.out.println("\nКонфеты в новогоднем подарке отсортированные по весу: " + sweets);

        List <Sweets> sweetsAccordingToSugar = present.searchSweetAccordingToSugar(sweets);
        System.out.println("Конфеты с заданым содержанем сахара: " + sweetsAccordingToSugar);
    }
}