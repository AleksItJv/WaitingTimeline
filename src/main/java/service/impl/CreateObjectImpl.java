package service.impl;

import dto.CWaitingTimeline;
import dto.DWaitingTimeline;
import model.WaitingTimeline;
import model.WaitingTimelineFactory;
import repository.Repo;
import model.CompanyService;
import model.LineStartCharacter;
import model.Question;
import model.ResponseType;
import service.CreateObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateObjectImpl implements CreateObject {

    private static long count = 1;
    private Repo repo = new Repo();

    @Override
    public void createObj(String str) {

        WaitingTimelineFactory factory = new WaitingTimelineFactory();
        String[] part = str.split(" ");

        WaitingTimeline cWaitingTimeline = factory.getWaitingTimelineDto(LineStartCharacter.TYPE_WAITING_TIMELINE);
        WaitingTimeline dWaitingTimeline = factory.getWaitingTimelineDto(LineStartCharacter.TYPE_QUERY);

        if (part[0].equals(LineStartCharacter.TYPE_WAITING_TIMELINE.getValue())) {

            createCWaitingTimeline(part, (CWaitingTimeline) cWaitingTimeline);

        } else if (part[0].equals(LineStartCharacter.TYPE_QUERY.getValue())) {

            createDWaitingTimeline(part, (DWaitingTimeline) dWaitingTimeline);

        } else {
            System.out.println("This is Type NOT SUPPORTED !!! ");
        }
    }

    @Override
    public void createCWaitingTimeline(String[] part, CWaitingTimeline cWaitingTimeline) {
        cWaitingTimeline.setCompanyService(new CompanyService(part[1]));
        cWaitingTimeline.setQuestion(new Question(part[2]));
        try {
            if (part[3].equals("P")) {
                cWaitingTimeline.setResponseType(ResponseType.P);
            } else if (part[3].equals("N")) {
                cWaitingTimeline.setResponseType(ResponseType.N);
            } else {
                throw new IllegalArgumentException("Wrong ResponseType!");
            }
        } catch (IllegalArgumentException ex) {
            System.err.print("Wrong ResponseType!");
            ex.getStackTrace();
        } finally {
            cWaitingTimeline.setResponseType(ResponseType.D);
        }
        cWaitingTimeline.setDateReq(part[4]);
        cWaitingTimeline.setWaitingTime((long) Integer.parseInt(part[5]));
        cWaitingTimeline.setCount(33);
        //System.out.println("C_Type - " + cWaitingTimeline);
        repo.addItem(count++, cWaitingTimeline);

    }

    @Override
    public void createDWaitingTimeline(String[] part, DWaitingTimeline dWaitingTimeline) {
        dWaitingTimeline.setCompanyService(new CompanyService(part[1]));
        dWaitingTimeline.setQuestion(new Question(part[2]));
        try {
            if (part[3].equals("P")) {
                dWaitingTimeline.setResponseType(ResponseType.P);
            } else if (part[3].equals("N")) {
                dWaitingTimeline.setResponseType(ResponseType.N);
            } else {
                throw new IllegalArgumentException("Wrong ResponseType!");
            }
        } catch (IllegalArgumentException ex) {
            System.err.print("Wrong ResponseType!");
            ex.getStackTrace();
        } finally {
            dWaitingTimeline.setResponseType(ResponseType.D);
        }
        String[] partDate = part[4].split("-");
        dWaitingTimeline.setDateFrom(partDate[0]);
        if (partDate.length < 2) {
            dWaitingTimeline.setDateTo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        } else {
            dWaitingTimeline.setDateTo(partDate[1]);
        }
        //System.out.println("D_Type - " + dWaitingTimeline);
        repo.addItem(count++, dWaitingTimeline);

    }


}
