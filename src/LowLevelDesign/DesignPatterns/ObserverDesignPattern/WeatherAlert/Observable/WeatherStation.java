package LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observable;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observer.DisplayObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WeatherStation implements WeatherStationObservable{

    private List<DisplayObserver> observers = new ArrayList<DisplayObserver>();
    private String weather;

    @Override
    public void add(DisplayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(DisplayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(DisplayObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setWeather(String weather) {
        if(Objects.isNull(this.weather) || this.weather.equals(weather)) {
            this.weather = weather;
            notifyObservers();
        }

    }

    @Override
    public String getWeather() {
        return weather;
    }
}
