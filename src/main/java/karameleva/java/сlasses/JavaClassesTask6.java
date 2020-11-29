package karameleva.java.сlasses;

import java.util.Scanner;

public class JavaClassesTask6 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Apartment [] apartments = new Apartment[] {
        new Apartment(Street.PINK, 1, 3, 12,1,28,BuildingType.PANEL, 2060),
        new Apartment(Street.PINK, 1, 5, 22,3,65,BuildingType.PANEL, 2060),
        new Apartment(Street.PINK, 1, 7, 36,4,82,BuildingType.PANEL, 2060),
        new Apartment(Street.PINK, 2, 1, 3,3,72,BuildingType.BRICK, 2040),
        new Apartment(Street.PINK, 2, 4, 10,2,56,BuildingType.BRICK, 2040),
        new Apartment(Street.PINK, 4, 5, 18,2,36,BuildingType.PANEL, 2040),
        new Apartment(Street.GREEN, 5, 3, 9,2,28,BuildingType.WOODEN, 2030),
        new Apartment(Street.GREEN, 6, 4, 12,1,21,BuildingType.WOODEN, 2030),
        new Apartment(Street.GREEN, 7, 2, 6,4,80,BuildingType.WOODEN, 2030),
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
        System.out.println("Print: \n1) List of apartments with required amount of rooms; " +
               "\n2) List of apartments located between required floors with required amount of rooms;" +
               "\n3) List of apartments with  bigger area than given." +
               "\n\nPlease, choose the task: " );
        int task = scan.nextInt();
        while (task < 1 || task > 3) {
            System.out.println("Incorrect number of the task. Please, try again: " );
            task = scan.nextInt();
        }
        return task;
    }

    public static void getApartmentByRoom (Scanner scan, Apartment [] apartments) {
        System.out.print("Please, enter number of rooms: ");
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
            throw new IllegalArgumentException("Incorrect data");
        }
        if (!flag) {
            System.out.println("Data are not found");
        }
    }

    public static void getApartmentByRoomAndFloor (Scanner scan, Apartment [] apartments) {
        System.out.print("Please, enter number of rooms: ");
        int roomAmount = scan.nextInt();
        System.out.print("Please, enter number of start floor  ");
        int floor1 = scan.nextInt();
        System.out.print("Please, enter number of finish floor  ");
        int floor2 = scan.nextInt();
        boolean flag = false;
        if (roomAmount >= 0 && floor1 >= 0 && floor2 >= 0) {
            for (int i = 0; i < apartments.length; i++) {
                if (apartments[i].getRooms() == roomAmount
                        && apartments[i].getFloor() >= floor1
                        && apartments[i].getFloor() <= floor2) {
                    System.out.println(apartments[i]);
                    flag = true;
                }
            }
        } else {
            throw new IllegalArgumentException("Incorrect data");
        }
        if (!flag) {
        System.out.println("Data are not found");
        }
    }

    public static void getApartmentBySquare (Scanner scan, Apartment [] apartments) {
        System.out.print("Please, enter the area  " );
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
            throw new IllegalArgumentException("Incorrect data" );
        }
        if (!flag) {
            System.out.println("Data are not found" );
        }
    }
}