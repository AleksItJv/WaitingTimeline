package service.impl;

import dto.CWaitingTimeline;
import dto.DWaitingTimeline;
import model.WaitingTimeline;
import service.CustomMethods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class CustomMethodsImpl implements CustomMethods {

    @Override
    public boolean checkBetweenDate(String dateToCheck, String startDate, String endDate) {
        boolean res = false;
        SimpleDateFormat fmt1 = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat fmt2 = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date requestDate = fmt2.parse(dateToCheck);
            Date fromDate = fmt1.parse(startDate);
            Date toDate = fmt1.parse(endDate);
            res = requestDate.compareTo(fromDate) >= 0 && requestDate.compareTo(toDate) <= 0;
        } catch (ParseException pex) {
            pex.printStackTrace();
        }
        return res;
    }

    @Override
    public Date returnDate(String val) {

        DateFormat df = null;
        Date date = null;

        try {
            df = new SimpleDateFormat("dd.MM.yyyy");
            date = df.parse(val);
            System.out.println("Date Converted.." + date);
            return date;
        } catch (Exception ex) {
            System.out.println(ex);
            return Date.from(Instant.now());
        } finally {
            df = null;
            date = null;
        }
    }

    @Override
    public boolean equalsForSimilar(WaitingTimeline valueWT, WaitingTimeline wtFromStorage, CustomMethods customMethod) {
        return valueWT.getCompanyService().getType().replaceAll("\\.(.*)", "").equals(wtFromStorage.getCompanyService().getType().replaceAll("\\.(.*)", ""))
                //&& (valueWT.getQuestion().getType().equals("*") ? true : valueWT.getQuestion().getType().replaceAll("\\.(.*)", "").equals(wtFromStorage.getQuestion().getType().replaceAll("\\.(.*)", "")))
                && (valueWT.getQuestion().getType().equals("*") || valueWT.getQuestion().getType().replaceAll("\\.(.*)", "").equals(wtFromStorage.getQuestion().getType().replaceAll("\\.(.*)", "")))
                // only for questions !!! ignore all category && sub-category
                && customMethod.checkBetweenDate(
                ((CWaitingTimeline) wtFromStorage).getDateReq(),
                ((DWaitingTimeline) valueWT).getDateFrom(),
                ((DWaitingTimeline) valueWT).getDateTo());
    }
}
