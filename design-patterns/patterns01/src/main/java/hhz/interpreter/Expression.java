package hhz.interpreter;

import java.util.HashMap;

/**
 * @ClassName: Expression
 * @Description: 抽象类
 * @Author: huanghz
 * @Date: 2019/12/11 14:10
 */
public abstract class Expression {
    public abstract int interpreter(HashMap<String, Integer> var);
}
