package service;

import model.WaitingTimeline;

import java.util.Date;

public interface CustomMethods {

    Date returnDate(String val);
    boolean checkBetweenDate(String dateToCheck, String startDate, String endDate);
    boolean equalsForSimilar(WaitingTimeline valueWT, WaitingTimeline wtFromStorage, CustomMethods cMethods);
}
