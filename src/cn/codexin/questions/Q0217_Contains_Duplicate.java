package cn.codexin.questions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xinGao 2020/12/13
 */

public class Q0217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
