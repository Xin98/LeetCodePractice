package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2020/8/22
 */

public class Q0679_24_Game {
    enum operate{
        ADD(0),
        MULTIPY(1),
        SUBTRACT(2),
        DIVIDE(3);
        private int value;
        operate(int value) {
            this.value = value;
        }
    }
    private final static int TARGET = 24;
    private final static double EPSILON = 1e-6;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add(Double.valueOf(num));
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if(list.size() == 0) {
            return false;
        }
        if(list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                List<Double> list2 = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if(k != i && k != j) {
                        // 将未被选中的其他元素加入到list中，等待下次递归
                        list2.add(list.get(k));
                    }
                }
                for (int k = 0; k < 4; k++) {
                    if(k < 2 && i > j) {
                        // 加法和乘法满足交换律
                        continue;
                    }
                    if(k == operate.ADD.value) {
                        list2.add(list.get(i) + list.get(j));
                    } else if(k == operate.MULTIPY.value) {
                        list2.add(list.get(i) * list.get(j));
                    } else if(k == operate.SUBTRACT.value) {
                        list2.add(list.get(i) - list.get(j));
                    } else if(k == operate.DIVIDE.value){
                        if(Math.abs(list.get(j)) >= EPSILON) {
                            // 除数不为零
                            list2.add(list.get(i) / list.get(j));
                        } else {
                            continue;
                        }
                    }
                    if(solve(list2)) {
                        return true;
                    }
                    // 回溯
                    list2.remove(list2.size() - 1);
                }
            }
        }
        return false;
    }
}
