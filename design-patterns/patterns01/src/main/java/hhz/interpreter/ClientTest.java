package hhz.interpreter;

import java.util.HashMap;

/**
 * @ClassName: ClientTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:10
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 2);
        hashMap.put("b", 4);

        Calculator calculator = new Calculator("a+b");
        int run = calculator.run(hashMap);
        System.out.println(run);
    }
}
