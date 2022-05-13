package repository;

import model.WaitingTimeline;

import java.util.HashMap;
import java.util.Map;

public class Repo {

    private static Map<Long, WaitingTimeline> repa = new HashMap<>();

    public Map<Long, WaitingTimeline> getMapa() {
        return repa;
    }

    public void addItem(Long id, WaitingTimeline obj) {
        this.repa.put(id, obj);
    }

    @Override
    public String toString() {
        return "Repo{" +
                "baza=" + repa +
                '}';
    }
}
