package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/10/22
 */

public class Q0763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        int start = 0, end = 0, n = S.length();
        int[] last = new int[26];
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < n; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end) {
                ans.add(end - start + 1);
                start = end + 1;
                end = start;
            }
        }
        return ans;
    }
}
