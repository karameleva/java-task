package karameleva.java.сollections.maintask;

import java.util.*;

public class Sweets extends Confectionery {
    private SweetsType type;

    public Sweets(String name, int sugarValue, double price, int weight, SweetsType type) {
        super(name, sugarValue, price, weight);
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweets sweets = (Sweets) o;
        return type == sweets.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "\n'" + name + "' (" + type.getRealName() +
                "), сахар: " + sugarValue +
                ", вес: " + weight + " гр.";
    }

    public SweetsType getType() {
        return type;
    }
}
