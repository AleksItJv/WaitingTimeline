package model;

public class Question {

    private String type;

    public Question() {
    }

    public Question(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Question: " + type;
    }
}
