package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/11/13
 */

public class Q01389_Create_Target_Array_in_the_Given_Order {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
