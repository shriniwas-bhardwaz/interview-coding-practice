package LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observable;


import LowLevelDesign.DesignPatterns.ObserverDesignPattern.NotifyMe.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObserverImpl implements StockObservable{

    private List<NotificationAlertObserver> observerList = new ArrayList<>();

    private int stockCount = 0 ;



    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount == 0) {
            stockCount = stockCount +  newStockAdded;
            notifySubscribers();
        }

    }

    public int getStockCount() {
        return stockCount;
    }

    public List<NotificationAlertObserver> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<NotificationAlertObserver> observerList) {
        this.observerList = observerList;
    }


}
