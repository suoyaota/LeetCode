package practice.solution.P200;

import java.util.PriorityQueue;

/**
 * @Author WilliamWang
 * @Date 2025/9/9-08:17
 */


public class P295 {
    PriorityQueue<Integer> smallerPq;
    PriorityQueue<Integer> biggerPq;

    public P295() {
        this.smallerPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.biggerPq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        Integer smallerNum = smallerPq.peek();
        Integer biggerNum = biggerPq.peek();
        if (smallerNum == null && biggerNum == null) {
            smallerPq.offer(num);
        } else if (smallerNum == null && biggerNum != null) {
            if (num < biggerNum) {
                smallerPq.offer(num);
            } else {
                biggerPq.offer(num);
            }
        } else if (smallerNum != null && biggerNum == null) {
            if (num < smallerNum) {
                smallerPq.offer(num);
            } else {
                biggerPq.offer(num);
            }
        } else if (num < smallerNum) {
            smallerPq.offer(num);
        } else if (num <= biggerNum) {
            if (smallerPq.size() < biggerPq.size()) {
                smallerPq.offer(num);
            } else {
                biggerPq.offer(num);
            }
        } else {
            biggerPq.offer(num);
        }
        if (smallerPq.size() - biggerPq.size() == 2) {
            biggerPq.offer(smallerPq.poll());
        } else if (biggerPq.size() - smallerPq.size() == 2) {
            smallerPq.offer(biggerPq.poll());
        }
    }

    public double findMedian() {
        int smallerSize = smallerPq.size();
        int biggerSize = biggerPq.size();
        if (smallerSize < biggerSize) {
            return biggerPq.peek();
        } else if (smallerSize == biggerSize) {
            return (smallerPq.peek() + biggerPq.peek()) / 2.0;
        } else {
            return smallerPq.peek();
        }
    }
}
