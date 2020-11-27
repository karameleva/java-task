package karameleva.java.сollections.maintask;

public enum SweetsType {
    CHOCOLATE ("Шоколадные конфеты"), CARAMEL ("Карамель");
    private String realName;

    SweetsType(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }
}
