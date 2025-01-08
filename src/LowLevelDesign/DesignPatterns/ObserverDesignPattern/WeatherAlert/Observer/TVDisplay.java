package LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observer;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observable.WeatherStationObservable;

public class TVDisplay implements DisplayObserver {
    private String weather;

    private WeatherStationObservable weatherStation;

    @Override
    public void update() {
        this.weather = weatherStation.getWeather();
        display();
    }

    private void display() {
        System.out.println("TV Display: Weather updated - " + weather);
    }
}
