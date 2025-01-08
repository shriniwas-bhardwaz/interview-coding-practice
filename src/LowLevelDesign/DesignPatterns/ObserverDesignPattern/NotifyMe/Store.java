package LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observable.IPhoneObserverImpl;
import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observable.StockObservable;
import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observer.EmailAlertObserverImpl;
import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observer.MobileAlertObserverImpl;
import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observer.NotificationAlertObserver;

public class Store {

    public static void main(String[] args) {

        StockObservable iphoneStockObservable = new IPhoneObserverImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("Rahul", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
    }
}
