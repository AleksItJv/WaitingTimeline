package model;

public enum ResponseType {

    P("first_answer"),
    N("next_answer"),
    D("default");

    private final String value;

    ResponseType(String value) {
        this.value = value;
    }


    public String getName() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
