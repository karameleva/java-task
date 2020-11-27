package karameleva.java.сollections.maintask;

import java.util.*;

import static karameleva.java.сollections.maintask.SweetsType.*;

public class NewYearPresent {
    private static List<? extends Confectionery> confectioneries;

    public NewYearPresent(List<? extends Confectionery> confectioneries) {
        NewYearPresent.confectioneries = confectioneries;
    }

    public static int getAmount(String typeOfConfectionery) {
        Scanner scan = new Scanner(System.in);
        System.out.println(typeOfConfectionery + ".\nВведите количество, которое вы хотите положить в новогодний подарок (шт):  ");
        int amount = scan.nextInt();
        while (amount < 0) {
            System.out.println("Введено некорректное количество. Попробуйте еще раз. \nВведите количество:  ");
            amount = scan.nextInt();
        }
        return amount;
    }

    public Map <SweetsType, Integer> getSweetsMap () {
        int amountChocolateSweetsInPresent = getAmount("Шоколадные конфеты");
        int amountCaramelSweetsInPresent = getAmount("Карамель");

       Map<SweetsType, Integer> mapSweets = new HashMap<>();
        mapSweets.put (CHOCOLATE, amountChocolateSweetsInPresent);
        mapSweets.put (CARAMEL, amountCaramelSweetsInPresent);
        return mapSweets;
    }

    public Map <FlourConfectionType, Integer> getFlourConfectionMap () {
        int amountBiscuitsInPresent = getAmount("Печенье");
        int amountGingerbreadInPresent = getAmount("Пряники");

        Map <FlourConfectionType, Integer> mapFlourConfection = new HashMap<>();
        mapFlourConfection.put (FlourConfectionType.BISCUITS, amountBiscuitsInPresent);
        mapFlourConfection.put (FlourConfectionType.GINGERBREAD, amountGingerbreadInPresent);

        return mapFlourConfection;
    }

    public List <Confectionery>  getNewYearPresent (Map <SweetsType, Integer> mapSweets,
                                                    Map<FlourConfectionType, Integer> mapFlourConfection) {
        double presentWeight = 0;
        List<Confectionery> newYearPresent = new ArrayList<>();
        for (Confectionery confectionary : confectioneries) {
            if (confectionary instanceof Sweets) {
                if (mapSweets.get(((Sweets) confectionary).getType()) > 0) {
                    newYearPresent.add(confectionary);
                    presentWeight += (confectionary.weight * mapSweets.get(((Sweets) confectionary).getType()));
                }
            } else {
                if (confectionary instanceof FlourConfection) {
                    if (mapFlourConfection.get(((FlourConfection) confectionary).getType()) > 0) {
                        newYearPresent.add(confectionary);
                        presentWeight += (confectionary.weight * mapFlourConfection.get(((FlourConfection) confectionary).getType()));
                    }
                }
            }
        }
        if (newYearPresent.isEmpty()) {
            throw new IllegalArgumentException("Новогодний подарок не собран!");
        }
            return newYearPresent;
    }

    public void printNewYearPresent (List <Confectionery> newYearPresent,
                                            Map <SweetsType, Integer> mapSweets,
                                            Map<FlourConfectionType, Integer> mapFlourConfection) {
        System.out.println("\nНовогодний подарок: ");
        for (Confectionery confectionary : newYearPresent) {
            if (confectionary instanceof Sweets) {
                System.out.println("'" + confectionary.getName() + "' (" +
                        ((Sweets) confectionary).getType().getRealName() + "), " +
                        mapSweets.get(((Sweets) confectionary).getType()) + " шт.");
            } else if (confectionary instanceof FlourConfection) {
                System.out.println("'" + confectionary.getName() + "' (" +
                        ((FlourConfection) confectionary).getType().getRealName() + "), " +
                        mapFlourConfection.get(((FlourConfection) confectionary).getType()) + " шт.");
            }
        }
    }

    public static double getNewYearPresentWeight (List <Confectionery> newYearPresent,
                                           Map <SweetsType, Integer> mapSweets,
                                           Map<FlourConfectionType, Integer> mapFlourConfection) {
        double presentWeight = 0;
        for (Confectionery confectionary : newYearPresent) {
            if (confectionary instanceof Sweets) {
                presentWeight += (confectionary.weight * mapSweets.get(((Sweets) confectionary).getType()));
            } else if (confectionary instanceof FlourConfection) {
                presentWeight += (confectionary.weight * mapFlourConfection.get(((FlourConfection) confectionary).getType()));
            }
        }
        return presentWeight;
    }

    public List <Sweets> getSweetsListInNewYearPresent(List <Confectionery> newYearPresent) {
        List <Sweets> sweets = new ArrayList();
        for (Confectionery confectionery : newYearPresent) {
            if (confectionery instanceof Sweets) {
                sweets.add((Sweets) confectionery);
            }
        }
        if (sweets.isEmpty()) {
            throw new IllegalArgumentException("Конфеты в новогоднем подарке не найдены!");
        }
        sweets.sort(Comparator.comparingInt(Confectionery::getWeight));
        return sweets;
    }

    public List <Sweets> searchSweetAccordingToSugar(List <Sweets> sweets) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nДля поиска конфеты по содержанию сахара, введите минимальное количество сахара в конфете");
        int minSugar = scan.nextInt();

        while (minSugar < 0) {
            System.out.println("Введено некорректное количество. Попробуйте еще раз. " +
                    "\nВведите минимальное количество сахара в конфете:  ");
            minSugar = scan.nextInt();
        }
        System.out.println("Введите максимальное количество сахара в конфете");

        int maxSugar = scan.nextInt();
        while (maxSugar < 0) {
            System.out.println("Введено некорректное количество. Попробуйте еще раз. " +
                    "\nВведите максимальное количество сахара в конфете:  ");
            maxSugar = scan.nextInt();
        }

        List <Sweets> sweetsAccordingToSugar = new ArrayList<>();
        for (Sweets sweet : sweets) {
            if (sweet.getSugarValue() > minSugar &&
                    sweet.getSugarValue() < maxSugar) {
                sweetsAccordingToSugar.add(sweet);
            }
        }
        if (sweetsAccordingToSugar.isEmpty()) {
            throw new IllegalArgumentException("Конфеты с заданым содержанием сахара не найдены!");
        }
        return sweetsAccordingToSugar;
    }
}