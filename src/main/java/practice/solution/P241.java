package practice.solution;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyb
 */
@Component
public class P241 {

    public List<Integer> diffWaysToCompute(String input) {
        //用递归
        //遇到符号就把式子分为符号左和符号右
        //符号左和符号右一定可以计算出一个结果
        //substring  ArrayList  不要打错
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < input.length() - 1; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftResults = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(input.substring(i + 1));
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        switch (c) {
                            case '+':
                                results.add(left + right);
                                break;
                            case '-':
                                results.add(left - right);
                                break;
                            case '*':
                                results.add(left * right);
                        }
                    }
                }
            }
        }
        if (results.size() == 0) {
            //只有一个数，没有符号，直接返回这个数
            results.add(Integer.valueOf(input));
        }
        return results;

    }
}
