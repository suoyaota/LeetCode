package practice.solution.P200;

import org.springframework.stereotype.Component;

/**
 * @Author William Wang
 * @Date 2019/10/18 15:50
 */
@Component
public class P287 {

    /**
     * @Date 2019/10/18 15:50
     * @Author William Wang
     * @Desicription Runtime & Memory Usage: 100.00%
     * 问题转换为找环问题：因为跳跃会无穷无尽进行下去所以必然有环
     * 阶段一：一开始兔子和龟都从起点开跳（这个起点是某条入环的路，设路长为r）
     * 假设乌龟在入圈后走了x步与已经在圈内绕了n圈的兔子相遇，设圈长为c
     * 乌龟每次走一步，兔子每次走两步，则有 2*(x+r) = nc + r; 所以 r = nc - x;
     * 因为乌龟已经入环x步了，所以乌龟再走nc - x步会走到环入口
     * 阶段二：所以再找一个人从起点与乌龟同速走r步后，人和乌龟在环入口相遇，返回环入口
     */
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        int man = nums[0];
        while (man != tortoise) {
            man = nums[man];
            tortoise = nums[tortoise];
        }
        return man;
    }
}
