package karameleva.java.сollections.maintask;

import java.util.Objects;

public class Confectionery {
    String name;
    int sugarValue; // per 100 gr
    double price; // per 1000 gr
    int weight; // gr per 1 confectionery

    public Confectionery(String name, int sugarValue, double price, int weight) {
        this.name = name;
        this.sugarValue = sugarValue;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getSugarValue() {
        return sugarValue;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Confectionery that = (Confectionery) o;
        return sugarValue == that.sugarValue &&
                Double.compare(that.price, price) == 0 &&
                weight == that.weight &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sugarValue, price, weight);
    }
}
