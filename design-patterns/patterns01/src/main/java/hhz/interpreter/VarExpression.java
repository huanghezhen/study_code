package hhz.interpreter;

import java.util.HashMap;

/**
 * @ClassName: VarExpression
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:11
 */
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(key);
    }
}
