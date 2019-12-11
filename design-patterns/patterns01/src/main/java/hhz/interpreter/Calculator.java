package hhz.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName: Calculator
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 14:10
 */
public class Calculator {
    private Expression expression;

    public Calculator(String expStr) {
        Stack<Expression> stack = new Stack<>();
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        expression = stack.pop();
    }

    public int run(HashMap<String, Integer> var) {
        return expression.interpreter(var);
    }
}
