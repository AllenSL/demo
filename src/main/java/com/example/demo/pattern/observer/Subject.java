package com.example.demo.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    protected List<Observer> list = new ArrayList<Observer>();

    public void register(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    public void notifyAllObjserver() {
        for (Observer obs : list) {
            obs.update(this);
        }
    }
}
