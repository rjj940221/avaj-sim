package com.wtc.avaj.simulator.tower;

import com.wtc.avaj.simulator.Flyable;
import com.wtc.avaj.simulator.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> observer = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observer.contains(flyable))
            observer.add(flyable);
            Logger.getLogger().towerLog(flyable.toString() + "registered");
    }

    public void unregister(Flyable flyable) {

        if (observer.contains(flyable)){
            observer.remove(flyable);
            Logger.getLogger().towerLog(flyable.toString() + "unregistered");
        }
    }

    protected void conditionsChange() {
        for (Flyable flyer : observer) {
            flyer.updateConditions();
        }
    }
}
