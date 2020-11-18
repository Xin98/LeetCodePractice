package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/18
 */

public class Q0134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int acc = 0;
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            acc += gas[i] - cost[i];
            if(acc < min) {
                min = acc;
                idx = i;
            }
        }
        if(acc < 0) {
            return -1;
        }
        return (idx + 1) % n;
    }
}
