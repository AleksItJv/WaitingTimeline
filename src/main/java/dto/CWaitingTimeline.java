package dto;

import model.*;

public class CWaitingTimeline extends WaitingTimeline {

    private long count;
    private String dateReq;
    private Long waitingTime;

    public CWaitingTimeline() {
    }

    public CWaitingTimeline(LineStartCharacter lineStartCharacter) {
        super(lineStartCharacter);
    }

    public CWaitingTimeline(LineStartCharacter lineStartCharacter, CompanyService companyService, Question question, ResponseType responseType, String dateReq, Long waitingTime) {
        super(lineStartCharacter, companyService, question, responseType);
        this.dateReq = dateReq;
        this.waitingTime = waitingTime;
    }

    public String getDateReq() {
        return dateReq;
    }

    public void setDateReq(String dateReq) {
        this.dateReq = dateReq;
    }

    public Long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CtypeDto{" + super.toString() +
                ", " + count +
                ", " + dateReq +
                ", " + waitingTime +
                "} ";
    }
}
