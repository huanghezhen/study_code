package hhz.observer;

/**
 * @ClassName: Observer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 21:35
 */
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
