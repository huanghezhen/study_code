package hhz.observer;

/**
 * @ClassName: CurrentConditions
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 21:37
 */
public class CurrentConditions implements Observer {

    private String name;

    public CurrentConditions(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature, float pressure, float humidity) {
        System.out.println(name+" temperature : " + temperature);
        System.out.println(name+" pressure : " + pressure);
        System.out.println(name+" humidity : " + humidity);
    }
}
