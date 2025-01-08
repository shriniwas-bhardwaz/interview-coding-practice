package LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observer;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;

    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.observable = observable;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        System.out.println(observable.getStockCount());
        sendEmail(emailId, "product is in stock hurry up!");
    }

    private void sendEmail(String emailId, String message) {
        System.out.println("mail sent to: " + emailId);
    }
}
