package practice.solution;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author wyb
 */
@Component
public class P215 {

    //快速排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //堆
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    //基于快排partition函数
    public int findKthLargest3(int[] nums, int k) {
        int j = 0;
        int idx = nums.length - k;
        int startIdx = 0;
        int endIdx = nums.length - 1;
        while (startIdx < endIdx) {
            j = partition(nums, startIdx, endIdx);
            if (j == idx) {
                break;
            }
            if (j < idx) {
                startIdx = j + 1;
            }
            if (j > idx) {
                endIdx = j - 1;
            }
            //      j = partition(nums,startIdx,endIdx);
        }
        return nums[idx];
    }


    private int partition(int[] nums, int startIdx, int endIdx) {
        int tar = nums[startIdx];
        int i = startIdx;
        int j = endIdx + 1;
        while (true) {
            while (nums[++i] < tar && i < endIdx) ;
            while (nums[--j] > tar && j > startIdx) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, startIdx, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

