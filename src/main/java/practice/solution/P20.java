package practice.solution;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * @Author William Wang
 */
@Component
public class P20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = cStack == '(' && c != ')'; //()匹配失败
                boolean b2 = cStack == '[' && c != ']';
                boolean b3 = cStack == '{' && c != '}';
                if (b1 || b2 || b3) {
                    //如果任意一个匹配失败
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

