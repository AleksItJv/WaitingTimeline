package dto;

import model.*;

public class DWaitingTimeline extends WaitingTimeline {

    private String dateFrom;
    private String dateTo;

    public DWaitingTimeline() {
    }

    public DWaitingTimeline(LineStartCharacter lineStartCharacter) {
        super(lineStartCharacter);
    }

    public DWaitingTimeline(LineStartCharacter lineStartCharacter, CompanyService companyService, Question question, ResponseType responseType, String dateFrom, String dateTo) {
        super(lineStartCharacter, companyService, question, responseType);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "CtypeDto{" + super.toString() +
                ", " + dateFrom +
                ", " + dateTo +
                "} ";
    }

}
