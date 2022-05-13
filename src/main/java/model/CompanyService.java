package model;

public class CompanyService {


    private String type;

    public CompanyService() {
    }

    public CompanyService(String type) {
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
        return "CompanyService: " + type;
    }
}
