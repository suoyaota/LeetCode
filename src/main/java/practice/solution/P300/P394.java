package practice.solution.P300;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author WilliamWang
 * @Date 2025/8/25-09:25
 */

@Component
public class P394 {
    public String decodeString(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                List<Character> tempList = new ArrayList<>();
                char tempC = stack.pop();
                while (tempC != '[') {
                    tempList.add(tempC);
                    tempC = stack.pop();
                }
                int num = stack.pop() - '0';
                while (num-- > 0) {
                    for (int j = tempList.size() - 1; j >= 0; j--) {
                        stack.push(tempList.get(j));
                    }
                }
            }
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
