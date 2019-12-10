package hhz.observer;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 21:45
 */
public class Client {
    public static void main(String[] args) throws Exception {
        WeatherData weatherData = new WeatherData();
        CurrentConditions currentConditions1 = new CurrentConditions("11");
        CurrentConditions currentConditions2 = new CurrentConditions("22");
        weatherData.registerObserver(currentConditions1);
        weatherData.registerObserver(currentConditions2);

        weatherData.setData(1.0f, 2.0f, 3.0f);

        System.out.println("-------------------------------------------------------------");

        weatherData.setData(1.0f, 2.0f, 3.0f);

        System.out.println("-------------------------------------------------------------");

        CurrentConditions currentConditions3 = new CurrentConditions("33");
        weatherData.registerObserver(currentConditions3);

        weatherData.setData(1.0f, 2.0f, 3.0f);

    }
}
