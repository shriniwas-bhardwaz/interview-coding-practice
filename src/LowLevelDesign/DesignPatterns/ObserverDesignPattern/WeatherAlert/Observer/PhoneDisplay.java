package LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observer;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observable.WeatherStationObservable;

public class PhoneDisplay implements DisplayObserver {

    private String weather;

    private WeatherStationObservable weatherStation;

    public PhoneDisplay(WeatherStationObservable weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        this.weather = weatherStation.getWeather();
        display();
    }

    private void display() {
        System.out.println("Phone Display: Weather updated - " + weather);
    }
}
