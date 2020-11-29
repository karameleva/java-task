package karameleva.java.сollections.maintask;

public enum SweetsType {
    CHOCOLATE ("Chocolate sweets"), CARAMEL ("Caramel sweets");
    private String realName;

    SweetsType(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }
}
