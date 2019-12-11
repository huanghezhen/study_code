package hhz.interpreter;

import java.util.HashMap;

/**
 * @ClassName: AddExpression
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:10
 */
public class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return left.interpreter(var) + right.interpreter(var);
    }
}
