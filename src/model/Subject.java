package model;

import view.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<Observer> listObserver = new ArrayList<>();
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int date) {
        this.data = data;
    }

    public void add(Observer o) {
        listObserver.add(o);
    }

    public void remove(Observer o) {
        listObserver.remove(o);
    }

    public void notifyObservers() {
        for(Observer o: listObserver) {
            o.update();
        }
    }
}
