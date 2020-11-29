package karameleva.java.сollections.maintask;

import java.util.*;
import static karameleva.java.сollections.maintask.SweetsType.*;

public class NewYearPresent {
    private static List<? extends Confectionery> confectioneries;
    private Confectionery confectionary;
    private int amount;
    public NewYearPresent(Confectionery confectionary, int amount) {
        this.confectionary = confectionary;
        this.amount = amount;
    }
    public NewYearPresent(List<? extends Confectionery> confectioneries) {
        NewYearPresent.confectioneries = confectioneries;
    }

    List <NewYearPresent> present = new ArrayList<>();

    public int getAmount(String typeOfConfectionery) {
        Scanner scan = new Scanner(System.in);
        System.out.println(typeOfConfectionery + ".\nPlease, enter amount which you want to put in New Year Present: ");
        int amount = scan.nextInt();
        while (amount < 0) {
            System.out.println("Incorrect number. Please, try again. \nEnter amount: ");
            amount = scan.nextInt();
        }
        return amount;
    }

    public Map <SweetsType, Integer> getSweetsMap () {
        int amountChocolateSweetsInPresent = getAmount("Chocolate sweets");
        int amountCaramelSweetsInPresent = getAmount("Caramel sweets");
        Map <SweetsType, Integer> mapSweets = new HashMap<>();
        mapSweets.put (CHOCOLATE, amountChocolateSweetsInPresent);
        mapSweets.put (CARAMEL, amountCaramelSweetsInPresent);
        return mapSweets;
    }

    public Map <FlourConfectionType, Integer> getFlourConfectionMap () {
        int amountBiscuitsInPresent = getAmount("Biscuits");
        int amountGingerbreadInPresent = getAmount("Gingerbread");
        Map <FlourConfectionType, Integer> mapFlourConfection = new HashMap<>();
        mapFlourConfection.put (FlourConfectionType.BISCUITS, amountBiscuitsInPresent);
        mapFlourConfection.put (FlourConfectionType.GINGERBREAD, amountGingerbreadInPresent);
        return mapFlourConfection;
    }

    public List <NewYearPresent> getMyNewYearPresent () {
        Map <SweetsType, Integer> mapSweets = getSweetsMap ();
        Map <FlourConfectionType, Integer> mapFlourConfection = getFlourConfectionMap ();
        for (Confectionery confectionary : confectioneries) {
            if (confectionary instanceof Sweets) {
                if (mapSweets.get(((Sweets) confectionary).getType()) > 0) {
                    present.add(new NewYearPresent(confectionary,
                            mapSweets.get(((Sweets) confectionary).getType())));
                }
            } else if (confectionary instanceof FlourConfection) {
                if (mapFlourConfection.get(((FlourConfection) confectionary).getType()) > 0) {
                    present.add(new NewYearPresent(confectionary,
                            mapFlourConfection.get(((FlourConfection) confectionary).getType())));
                }
            }
        }
        if (present.isEmpty()) {
            throw new IllegalArgumentException("New Year Present is empty!");
        }
        return present;
    }

    public double getNewYearPresentWeight() {
        double presentWeight = 0;
        for (NewYearPresent presentElement : present) {
            presentWeight += presentElement.confectionary.weight * presentElement.amount;
        }
        return presentWeight;
    }

    public List <Sweets> getSweetsListInNewYearPresentSortedByWeight() {
        List <Sweets> sweets = new ArrayList();
        for (NewYearPresent presentElement : present) {
            if (presentElement.confectionary instanceof Sweets) {
                sweets.add((Sweets) presentElement.confectionary);
            }
        }
        if (sweets.isEmpty()) {
            throw new IllegalArgumentException("Sweets are not found in the New Year Present!");
        }
        sweets.sort(Comparator.comparingInt(Confectionery::getWeight));
        return sweets;
    }

    public List <Sweets> searchSweetAccordingToSugar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease, enter minimum amount of sugar in the sweet: ");
        int minSugar = scan.nextInt();

        while (minSugar < 0) {
            System.out.println("Incorrect amount. Please try again. " +
                    "\nPlease, enter minimum amount of sugar in the sweet: ");
            minSugar = scan.nextInt();
        }
        System.out.println("Please, enter maximum amount of sugar in the sweet: ");
        int maxSugar = scan.nextInt();
        while (maxSugar < 0) {
            System.out.println("Incorrect amount. Please try again. " +
                    "\nPlease, enter maximum amount of sugar in the sweet: ");
            maxSugar = scan.nextInt();
        }
        List <Sweets> sweets  = getSweetsListInNewYearPresentSortedByWeight();
        for (int i = 0; i < sweets.size(); i++) {
            if (sweets.get(i).getSugarValue() < minSugar || sweets.get(i).getSugarValue() > maxSugar) {
                sweets.remove(i);
                i--;
            }
        }
        if (sweets.isEmpty()) {
            throw new IllegalArgumentException("Sweets with requested amount of sugar are not found! ");
        }
        return sweets;
    }

    @Override
    public String toString() {
        String presentToPrint = null;
        if (confectionary instanceof Sweets) {
            presentToPrint =  "\n'" + confectionary.name + "' (" +
                    ((Sweets) confectionary).getType() +
                    "), " + amount + "pc.";
        } else if (confectionary instanceof FlourConfection) {
            presentToPrint = "\n'" + confectionary.name + "' (" +
                    ((FlourConfection) confectionary).getType() +
                    "), " + amount + "pc.";
        }
        return presentToPrint;
    }
}