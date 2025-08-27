package practice.solution.common;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author WilliamWang
 * @Date 2025/3/7-15:31
 */


public class LRUCache {
    class Status implements Comparable<Status> {
        int key;
        int val;
        int lastUsedTime;

        Status(int key, int val, int lastUsedTime) {
            this.key = key;
            this.val = val;
            this.lastUsedTime = lastUsedTime;
        }

        public int compareTo(Status status) {
            return this.lastUsedTime - status.lastUsedTime;
        }
    }

    int capacity;
    Map<Integer, Status> map;
    Queue<Status> queue;
    int time;



    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.queue = new PriorityQueue<>(capacity);
        this.capacity = capacity;
        this.time = 0;

    }

    public int get(int key) {
        if (map == null) {
            return -1;
        }
        time++;
        Status status = map.get(key);
        if (status == null) {
            return -1;
        }
        status.lastUsedTime = time;
        return status.val;
    }

    public void put(int key, int value) {
        if (map == null) {
            return;
        }
        time++;
        if (map.size() == capacity) {
            Status status = queue.poll();
            map.remove(status.key);
        }
        Status old = map.get(key);
        if (old == null) {
            Status newStatus = new Status(key, value, time);
            queue.offer(newStatus);
            map.put(key, newStatus);
        } else {
            old.val = value;
            old.lastUsedTime = time;
        }
    }

}
