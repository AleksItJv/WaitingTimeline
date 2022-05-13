package service;

import dto.CWaitingTimeline;
import dto.DWaitingTimeline;

public interface CreateObject {

    void createObj(String str);
    void createCWaitingTimeline(String[] part, CWaitingTimeline cWaitingTimelineDto);
    void createDWaitingTimeline(String[] part, DWaitingTimeline dWaitingTimelineDto);
}
