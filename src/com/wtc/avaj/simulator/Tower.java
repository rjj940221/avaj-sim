package com.wtc.avaj.simulator;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> observer = new ArrayList<>();

    public void register(Flyable flyable) {
        if (!observer.contains(flyable))
            observer.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observer.remove(flyable);
    }

    protected void conditionsChange() {

    }
}
