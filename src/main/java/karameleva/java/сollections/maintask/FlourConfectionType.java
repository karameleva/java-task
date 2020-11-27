package karameleva.java.сollections.maintask;

public enum FlourConfectionType {
    BISCUITS ("Печенье"), GINGERBREAD("Пряник");
    private String realName;

    FlourConfectionType(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }
}
