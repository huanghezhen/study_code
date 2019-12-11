package hhz.interpreter;

import java.util.HashMap;

/**
 * @ClassName: SymbolExpression
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:11
 */
public class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
