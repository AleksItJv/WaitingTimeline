package model;

public enum LineStartCharacter {

    TYPE_WAITING_TIMELINE("C"),
    TYPE_QUERY("D");

    private final String value;

    LineStartCharacter(String value) {
        this.value = value;
    }


    public String getName() {

        return name();
    }

    public String getValue() {
        return value;
    }
}
