package practice.solution.P200;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @Author William Wang
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
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
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

    /**
     * 数组建堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest4(int[] nums, int k) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            buildMaxHeap(nums, i, nums.length);
        }
        int heapSize = nums.length;
        // 做k-1次删除操作
        for (int j = 1; j < k; j++) {
            swap(nums, 0, heapSize - 1);
            heapSize--;
            buildMaxHeap(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int midIdx, int heapSize) {
        int l = midIdx * 2 + 1;
        int r = midIdx * 2 + 2;
        int largest = midIdx;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != midIdx) {
            // 交换，并调整交换后的子树
            swap(nums, largest, midIdx);
            buildMaxHeap(nums, largest, heapSize);
        }
    }





}

