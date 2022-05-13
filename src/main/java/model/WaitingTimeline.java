package model;

import java.util.Objects;

public abstract class WaitingTimeline {

    private LineStartCharacter lineStartCharacter;
    private CompanyService companyService;
    private Question question;
    private ResponseType responseType;

    public WaitingTimeline() {
    }

    public WaitingTimeline(LineStartCharacter lineStartCharacter) {
        this.lineStartCharacter = lineStartCharacter;
    }

    public WaitingTimeline(LineStartCharacter lineStartCharacter, CompanyService companyService, Question question, ResponseType responseType) {
        this.lineStartCharacter = lineStartCharacter;
        this.companyService = companyService;
        this.question = question;
        this.responseType = responseType;
    }

    public LineStartCharacter getLineStartsCharacter() {
        return lineStartCharacter;
    }

    public void setLineStartsCharacter(LineStartCharacter lineStartCharacter) {
        this.lineStartCharacter = lineStartCharacter;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineStartCharacter, companyService, question, responseType);
    }

    @Override
    public String toString() {
        return "" +
                lineStartCharacter.getValue() +
                ", " + companyService +
                ", " + question +
                ", " + responseType + "";
    }
}
