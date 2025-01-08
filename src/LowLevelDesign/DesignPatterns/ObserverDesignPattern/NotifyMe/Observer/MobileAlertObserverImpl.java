package LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observer;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String userName;

    StockObservable observable;

    public MobileAlertObserverImpl(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessageOnMobile(userName, "product is in stock hurry up!");
    }

    private void sendMessageOnMobile(String userName, String message) {
        System.out.println("Message sent to: " + userName);
    }
}
