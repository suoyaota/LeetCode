package practice.solution.P300;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @Author William Wang
 */
@Component
public class P347 {

    //桶排序
    //先用一个hashmap 存放 num,frequency
    //再用一个List<Integer>[] buckets = new ArrayList[] 来当桶 下标为出现的次数
    //最后从出现的次数多的桶里取出topK;
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequency = new HashMap<>();
        for (int num : nums) {
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : numFrequency.keySet()) {
            //用keySet,保证不会重复添加数字
            int frequency = numFrequency.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<Integer>();
            }
            buckets[frequency].add(num);
        }
        List<Integer> topK = new ArrayList<Integer>(k + 1);
        int needNum = k;
        for (int i = nums.length; i >= 0; i--) {
            if (needNum == 0) {
                break;
            }
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= needNum) {
                topK.addAll(buckets[i]);
                needNum -= buckets[i].size();
            } else {
                topK.addAll(buckets[i].subList(0, needNum));
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = topK.get(i);
        }
        return ans;
    }

    // 堆排序
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> num2FrenquencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            num2FrenquencyMap.put(nums[i], num2FrenquencyMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : num2FrenquencyMap.entrySet()) {
            int[] pair = new int[] {entry.getKey(), entry.getValue()};
            pq.offer(pair);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int[] pair = pq.poll();
            ans[i] = pair[0];
        }
        return ans;
    }
}

