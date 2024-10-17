package practice.solution;

import org.springframework.stereotype.Component;

import java.util.*;


/**
 * @Date 2019/10/9 18:33
 * @Author William Wang
 */
@Component
public class P350 {

    /**
     * @Date 2019/10/9 18:34
     * @Author William Wang
     * @Desicription 暴力法
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (nums1.length <= nums2.length) {
            int[] mark = new int[nums1.length];
            int ansNum = 0;
            for (int num : nums2) {
                for (int i = 0; i < nums1.length; i++) {
                    if (mark[i] == 0 && num == nums1[i]) {
                        ans.add(num);
                        mark[i] = 1;
                        ansNum++;
                        break;
                    }
                }
                if (ansNum == nums1.length) break;
            }
        } else {
            int[] mark = new int[nums2.length];
            int ansNum = 0;
            for (int num : nums1) {
                for (int i = 0; i < nums2.length; i++) {
                    if (mark[i] == 0 && num == nums2[i]) {
                        ans.add(num);
                        mark[i] = 1;
                        ansNum++;
                        break;
                    }
                }
                if (ansNum == nums2.length) break;
            }
        }
        int[] ANS = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            ANS[i] = ans.get(i);
        return ANS;
    }

    /**
     * @Date 2019/10/9 18:35
     * @Author William Wang
     * @Desicription 哈希法和排序步进法
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        // map 记录 nums1 里面的元素以及出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }

        }

        List<Integer> list = new ArrayList<>();

        // 然后遍历 nums2，如果 map 里面有 nums2 里面的数据就表示符合要求
        // 取出该数据存储到 list 里面，同时将该数据出现的次数 - 1（nums2 后面可能再次遇到该 nums2[i]）
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        // 对象转数组
        Object[] a = list.toArray();
        int i = 0;
        int[] ans = new int[a.length];
        for (Object e : a) {
            ans[i++] = (int) e;
        }
        return ans;
    }

    /**
     * @Date 2019/10/9 18:36
     * @Author William Wang
     * @Desicription 使用排序【更好的做法】
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>(nums1.length);
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        // 对象转数组
        Object[] a = list.toArray();
        int n = 0;
        int[] ans = new int[a.length];
        for (Object e : a) {
            ans[n++] = (int) e;
        }
        return ans;
    }
}
