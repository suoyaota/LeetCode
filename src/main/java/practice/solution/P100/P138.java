package practice.solution.P100;

import practice.solution.common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author WilliamWang
 * @Date 2025/3/4-21:00
 */


public class P138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> old2NewMap = new HashMap<>();
        Node oldCur = head;
        Node ans = new Node(-1);
        Node newCur = ans;
        while (oldCur != null) {
            Node temp = new Node(oldCur.getVal());
            old2NewMap.put(oldCur, temp);
            newCur.setNext(temp);
            oldCur = oldCur.getNext();
            newCur = newCur.getNext();
        }
        oldCur = head;
        newCur = ans.getNext();
        while (oldCur != null) {
            Node newRandom = old2NewMap.get(oldCur.getRandom());
            newCur.setRandom(newRandom);
            oldCur = oldCur.getNext();
            newCur = newCur.getNext();
        }
        return ans.getNext();
    }

}
