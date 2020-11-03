package com.example.demo.pattern.observer;

public class ObserverA implements Observer{
    private int myState;

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getMyState();
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    public int getMyState() {
        return myState;
    }
}
