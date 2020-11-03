package com.example.demo.pattern.observer;

public class ConcreteSubject extends Subject {

    private int myState;

    public void setMyState(int myState) {
        this.myState = myState;
        this.notifyAllObjserver();
    }

    public int getMyState() {
        return myState;
    }
}
