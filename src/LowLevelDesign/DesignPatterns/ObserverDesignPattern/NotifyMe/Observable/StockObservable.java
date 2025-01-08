package LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observable;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observer.NotificationAlertObserver;

public interface StockObservable {

    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifySubscribers();
    void setStockCount(int newStockAdded);
    int getStockCount();
}
