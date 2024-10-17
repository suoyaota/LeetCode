package practice.solution;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/9 18:23
 * @Author William Wang
 */
@Component
public class P134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int step = 0;
            int gasNow = 0;
            int pos = i;
            while (step <= gas.length) {
                pos = pos % gas.length;
                gasNow += gas[pos];
                gasNow -= cost[pos];
                if (gasNow >= 0) {
                    step++;
                    pos++;
                    //System.out.println(i+"  "+gasNow+"  " +step);
                } else {
                    break;
                }
            }
            if (step == gas.length + 1) {
                return i;
            }
        }
        return -1;
    }
}


