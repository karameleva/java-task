package JavaClasses;

        // Создать классы, спецификации которых приведены ниже.
        // Определить конструкторы и методы setТип(), getТип(), toString().
        // Определить дополнительно методы в классе, создающем массив объектов.
        // Задать критерий выбора данных и вывести эти данные на консоль.
        // В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.

        // House: id, Номер квартиры, Площадь, Этаж, Количество комнат, Улица, Тип здания, Срок эксплуатации.
        // Создать массив объектов. Вывести:
        // a) список квартир, имеющих заданное число комнат;
        // b) список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке;
        // c) список квартир, имеющих площадь, превосходящую заданную.

import java.util.Scanner;

public class JavaClassesTask6 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Apartment [] apartments = new Apartment[] {
        new Apartment(Street.РОЗОВАЯ, 1, 3, 12,1,28,BuildingType.ПАНЕЛЬНЫЙ, 2060),
        new Apartment(Street.РОЗОВАЯ, 1, 5, 22,3,65,BuildingType.ПАНЕЛЬНЫЙ, 2060),
        new Apartment(Street.РОЗОВАЯ, 1, 7, 36,4,82,BuildingType.ПАНЕЛЬНЫЙ, 2060),
        new Apartment(Street.РОЗОВАЯ, 2, 1, 3,3,72,BuildingType.КИРПИЧНЫЙ, 2040),
        new Apartment(Street.РОЗОВАЯ, 2, 4, 10,2,56,BuildingType.КИРПИЧНЫЙ, 2040),
        new Apartment(Street.РОЗОВАЯ, 4, 5, 18,2,36,BuildingType.ПАНЕЛЬНЫЙ, 2040),
        new Apartment(Street.ЗЕЛЁНАЯ, 5, 3, 9,2,28,BuildingType.ДЕРЕВЯННЫЙ, 2030),
        new Apartment(Street.ЗЕЛЁНАЯ, 6, 4, 12,1,21,BuildingType.ДЕРЕВЯННЫЙ, 2030),
        new Apartment(Street.ЗЕЛЁНАЯ, 7, 2, 6,4,80,BuildingType.ДЕРЕВЯННЫЙ, 2030),
        };
        int task = showMenu(scan);
            switch (task) {
                case 1:
                    getApartmentByRoom(scan, apartments);
                    break;
                case 2:
                    getApartmentByRoomAndFloor(scan, apartments);
                    break;
                case 3:
                    getApartmentBySquare(scan, apartments);
                    break;
            }
    }
    public static int showMenu (Scanner scan) {
        System.out.println("Вывести: \n1) список квартир, имеющих заданное число комнат; " +
               "\n2) список квартир, имеющих заданное число комнат и расположенных на этаже, " +
               "\nкоторый находится в заданном промежутке; " +
               "\n3) список квартир, имеющих площадь, превосходящую заданную." +
               "\n\nВведите номер задания  " );
        int task = scan.nextInt();
        while (task < 1 || task > 3) {
            System.out.println("Неверно введен номер задания. Попробуй ещё раз: " );
            task = scan.nextInt();
        }
        return task;
    }
    public static void getApartmentByRoom (Scanner scan, Apartment [] apartments) {
        System.out.print("Введите количество комнат");
        int roomAmount = scan.nextInt();
        boolean flag = false;
        if (roomAmount >= 0) {
            for (int i = 0; i < apartments.length; i++) {
                if (apartments[i].getRooms() == roomAmount) {
                    System.out.println(apartments[i]);
                    flag = true;
                }
            }
        } else {
            throw new IllegalArgumentException("Неверно введены данные");
        }
        if (!flag) {
            System.out.println("Данные не найдены");
        }
    }
    public static void getApartmentByRoomAndFloor (Scanner scan, Apartment [] apartments) {
        System.out.print("Введите количество комнат  ");
        int roomAmount = scan.nextInt();
        System.out.print("Введите начальный этаж  ");
        int floor1 = scan.nextInt();
        System.out.print("Введите конечный этаж  ");
        int floor2 = scan.nextInt();
        boolean flag = false;
        if (roomAmount >= 0 && floor1 >= 0 && floor2 >= 0) {
            for (int i = 0; i < apartments.length; i++) {
                if (apartments[i].getRooms() == roomAmount && apartments[i].getFloor() >= floor1 &&
                        apartments[i].getFloor() <= floor2) {
                    System.out.println(apartments[i]);
                    flag = true;
                }
            }
        } else {
            throw new IllegalArgumentException("Неверно введены данные");
        }
        if (!flag) {
        System.out.println("Данные не найдены");
        }
    }
    public static void getApartmentBySquare (Scanner scan, Apartment [] apartments) {
        System.out.print("Введите площадь  " );
        double squareSearch = scan.nextDouble();
        boolean flag = false;
        if (squareSearch > 0) {
            for (int i = 0; i < apartments.length; i++) {
                if (apartments[i].getSquare() > squareSearch) {
                    System.out.println(apartments[i]);
                    flag = true;
                }
            }
        } else {
            throw new IllegalArgumentException("Неверно введены данные" );
        }
        if (!flag) {
            System.out.println("Данные не найдены" );
        }
    }
}



