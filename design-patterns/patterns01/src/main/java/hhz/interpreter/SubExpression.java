package hhz.interpreter;

import java.util.HashMap;

/**
 * @ClassName: SubExpression
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:11
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return left.interpreter(var) - right.interpreter(var);
    }
}
