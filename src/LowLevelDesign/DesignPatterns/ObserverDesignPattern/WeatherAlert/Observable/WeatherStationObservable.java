package LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observable;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observer.DisplayObserver;

public interface WeatherStationObservable {

    void add (DisplayObserver observer);
    void remove(DisplayObserver observer);
    void notifyObservers();
    void setWeather(String weather);
    String getWeather();
}
