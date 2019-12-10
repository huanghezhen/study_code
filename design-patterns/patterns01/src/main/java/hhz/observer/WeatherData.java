package hhz.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WeatherData
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 21:40
 */
public class WeatherData implements Subject{


    private float temperature;
    private float pressure;
    private float humidity;

    private List<Observer> observerList = new ArrayList<>();


    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;

        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature,pressure,humidity);
        }
    }
}
