package karameleva.java.сollections.maintask;

public class FlourConfection extends Confectionery {
    private FlourConfectionType type;

    public FlourConfection(String name, int sugarValue, double price, int weight, FlourConfectionType type) {
        super(name, sugarValue, price, weight);
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n'" + name + "' (" + type.getRealName() +
                "), sugar: " + sugarValue +
                ", weight: " + weight + " gr";
    }

    public FlourConfectionType getType() {
        return type;
    }
}

