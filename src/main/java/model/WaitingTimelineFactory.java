package model;

import dto.CWaitingTimeline;
import dto.DWaitingTimeline;

public class WaitingTimelineFactory {

    public WaitingTimeline getWaitingTimelineDto(LineStartCharacter type) {
        WaitingTimeline toReturn = null;
        switch (type) {
            case TYPE_WAITING_TIMELINE:
                toReturn = new CWaitingTimeline(LineStartCharacter.TYPE_WAITING_TIMELINE);
                break;
            case TYPE_QUERY:
                toReturn = new DWaitingTimeline(LineStartCharacter.TYPE_QUERY);
                break;
            default:
                throw new IllegalArgumentException("Wrong WaitingTimeline type:" + type);
        }
        return toReturn;
    }
}
