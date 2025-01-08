package LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert;

import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observable.WeatherStation;
import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observable.WeatherStationObservable;
import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observer.DisplayObserver;
import LowLevelDesign.DesignPatterns.ObserverDesignPattern.WeatherAlert.Observer.PhoneDisplay;

public class WeatherApp {

    public static void main(String[] args) {
        WeatherStationObservable weatherStationObservable = new WeatherStation();

        DisplayObserver observer1 = new PhoneDisplay(weatherStationObservable);
        DisplayObserver observer2 = new PhoneDisplay(weatherStationObservable);

        weatherStationObservable.add(observer1);
        weatherStationObservable.add(observer2);

        weatherStationObservable.setWeather("Sunny");
    }
}
