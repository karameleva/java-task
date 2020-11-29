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
                throw new IllegalArgumentException("Incorrect number of the house");
            }
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            if (floor >= 0) {
                this.floor = floor;
            } else {
                throw new IllegalArgumentException("Incorrect number of the floor");
            }
        }

        public int getApartmentID() {
            return apartmentID;
        }

        public void setApartmentID(int apartmentID) {
            if (apartmentID > 0) {
                this.apartmentID = apartmentID;
            } else {
                throw new IllegalArgumentException("Incorrect number of the apartment");
            }
        }

        public int getRooms() {
            return rooms;
        }

        public void setRooms(int rooms) {
            if (rooms >=0) {
                this.rooms = rooms;
            } else {
                throw new IllegalArgumentException("Incorrect amount of rooms");
            }
        }

        public double getSquare() {
            return square;
        }

        public void setSquare(double square) {
            if (getSquare() > 0) {
                this.square = square;
            } else {
                throw new IllegalArgumentException("Incorrect square of the apartment");
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
                throw new IllegalArgumentException("Incorrect lifetime of the house");
            }
        }

        @Override
        public String toString() {
            return street + " str., house " + house + ", app." + apartmentID + " (fl." + floor +  rooms + " rooms, " +
                    square + " sq.m.), " + buildingType + " house, lifetime till " + lifetime;
        }


}
