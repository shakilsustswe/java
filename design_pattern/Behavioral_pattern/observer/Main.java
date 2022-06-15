package design_pattern.Behavioral_pattern.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}

interface Observer {
    void update(String notifyString);
}

class fbPage implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    private String status;

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update("FB page has new Status");
        }
    }

    public void updatePage(String status) {
        this.status = status;
        notifyAllObserver();
    }

}

class crazyFan implements Observer {

    private String name;

    crazyFan(String name) {
        this.name = name;
    }

    @Override
    public void update(String notifyString) {
        System.out.print("This is " + this.name + "'s page!new notification from ");
        System.out.println(notifyString);

    }

}

public class Main {

    public static void main(String[] args) {

        fbPage fbPage = new fbPage();
        crazyFan crazyFan1=new crazyFan("shakil");
        crazyFan crazyFan2=new crazyFan("SALMAN");
        fbPage.register(crazyFan1);
        fbPage.register(crazyFan2);

        fbPage.updatePage("I'm now live");
}
    }
    
