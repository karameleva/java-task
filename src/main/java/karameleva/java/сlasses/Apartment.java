package karameleva.java.сlasses;

public class Apartment {

        private Street street;
        private int house;
        private int floor;
        private int apartmentID;
        private int rooms;
        private double square;
        private BuildingType buildingType;
        private int lifetime;

        public Apartment(Street street, int house, int floor, int apartmentID, int rooms, double square,
                         BuildingType buildingType, int lifetime) {
            this.street = street;
            this.house = house;
            this.floor = floor;
            this.apartmentID = apartmentID;
            this.rooms = rooms;
            this.square = square;
            this.buildingType = buildingType;
            this.lifetime = lifetime;
        }

        public Street getStreet() {
            return street;
        }

        public void setStreet(Street street) {
            this.street = street;
        }

        public int getHouse() {
            return house;
        }

        public void setHouse(int house) {
            if (house > 0) {
                this.house = house;
            } else {
                throw new IllegalArgumentException("Неверно введен номер дома");
            }
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            if (floor >= 0) {
                this.floor = floor;
            } else {
                throw new IllegalArgumentException("Неверно введен этаж");
            }
        }

        public int getApartmentID() {
            return apartmentID;
        }

        public void setApartmentID(int apartmentID) {
            if (apartmentID > 0) {
                this.apartmentID = apartmentID;
            } else {
                throw new IllegalArgumentException("Неверно введен номер квартиры");
            }
        }

        public int getRooms() {
            return rooms;
        }

        public void setRooms(int rooms) {
            if (rooms >=0) {
                this.rooms = rooms;
            } else {
                throw new IllegalArgumentException("Неверно введено количество комнат");
            }
        }

        public double getSquare() {
            return square;
        }

        public void setSquare(double square) {
            if (getSquare() > 0) {
                this.square = square;
            } else {
                throw new IllegalArgumentException("Неверно введена площадь квартиры");
            }
        }

        public BuildingType getBuildingType() {
            return buildingType;
        }

        public void setBuildingType(BuildingType buildingType) {
            this.buildingType = buildingType;
        }

        public int getLifetime() {
            return lifetime;
            }

        public void setLifetime(int lifetime) {
            if (lifetime >= 2000) {
                this.lifetime = lifetime;
            } else {
                throw new IllegalArgumentException("Неверно введен срок эксплуатации дома");
            }
        }

        @Override
        public String toString() {
            return street + " д." + house + " кв." + apartmentID + " (" + floor + "-й этаж, " + rooms + "-комн., " +
                    square + " кв.м.), " + buildingType + " дом, срок эксплуатации до " + lifetime + " г.";
        }


}
