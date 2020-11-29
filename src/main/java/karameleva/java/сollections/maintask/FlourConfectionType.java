package karameleva.java.сollections.maintask;

public enum FlourConfectionType {
    BISCUITS ("Biscuits"), GINGERBREAD("Gingerbread");
    private String realName;

    FlourConfectionType(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }
}
