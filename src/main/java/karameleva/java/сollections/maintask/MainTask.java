package karameleva.java.сollections.maintask;

import java.util.ArrayList;
import java.util.List;

public class MainTask {
    public static void main (String [] args) {
        List<Confectionery> confectioneries = new ArrayList<>();
        confectioneries.add(new FlourConfection("Maria", 45, 13, 100, FlourConfectionType.BISCUITS));
        confectioneries.add(new FlourConfection("Tulskiy", 55, 12, 70, FlourConfectionType.GINGERBREAD));
        confectioneries.add(new Sweets("Aeroflot", 60, 18, 12, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Griliazh", 45, 25, 22, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Alenka", 55, 19, 16, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Stolichnie", 56, 15.5, 17, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Batonchik", 52, 14, 19, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Mars", 51, 25, 16, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Snikers", 54, 28, 25, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Baunti", 52, 24, 21, SweetsType.CHOCOLATE));
        confectioneries.add(new Sweets("Dushes", 65, 8, 6, SweetsType.CARAMEL));
        confectioneries.add(new Sweets("Strawberry", 66, 8.5, 7, SweetsType.CARAMEL));
        confectioneries.add(new Sweets("Rachki", 68, 10, 9, SweetsType.CARAMEL));

        NewYearPresent present = new NewYearPresent(confectioneries);
        List <NewYearPresent> newYearPresent = present.getMyNewYearPresent();
        System.out.println("New Year Present" + newYearPresent + "\n\nTotal weight: " +
                present.getNewYearPresentWeight() + " gr");
        System.out.println("\nList of sweets in Mew Year Present sorted by weight: " +
                present.getSweetsListInNewYearPresentSortedByWeight());
        System.out.println("\nList of sweets in New Year Present with requested amount of sugar:" +
                present.searchSweetAccordingToSugar());
    }
}