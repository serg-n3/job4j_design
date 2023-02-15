package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> mapPrev = new HashMap<>();
        Map<Integer, String> mapCur = new HashMap<>();
        for (User cur : current) {
            mapCur.put(cur.getId(), cur.getName());
        }
        for (User prev : previous) {
            mapPrev.put(prev.getId(), prev.getName());
        }
        for (Map.Entry<Integer, String> curr : mapCur.entrySet()) {
            if (!mapPrev.containsKey(curr.getKey())) {
                info.setAdded(info.getAdded() + 1);
            }
        }
        for (Map.Entry<Integer, String> prev : mapPrev.entrySet()) {
            if (mapCur.containsKey(prev.getKey()) && !mapCur.containsValue(prev.getValue())) {
                info.setChanged(info.getChanged() + 1);
                continue;
            }
            if (!mapCur.containsKey(prev.getKey())) {
                info.setDeleted(info.getDeleted() + 1);
            }
        }
        return info;
    }
}
