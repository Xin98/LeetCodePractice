package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/1/5
 */

public class Q0830_Positions_of_Large_Groups {
    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        int groupLen = 1;
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(i != n && s.charAt(i) == s.charAt(i - 1)) {
                groupLen++;
            } else {
                if(groupLen >= 3) {
                    ans.add(Arrays.asList(i - groupLen, i - 1));
                }
                groupLen = 1;
            }
        }
        return ans;
    }
}
