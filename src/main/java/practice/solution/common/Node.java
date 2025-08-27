package practice.solution.common;

/**
 * @Author WilliamWang
 * @Date 2025/3/4-21:00
 */


public class Node {
    private int val;
    private Node next;
    private Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }
}
