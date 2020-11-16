package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/11/16
 */

public class Q0406_Queue_Reconstruction_by_Height {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->(a[0] - b[0] == 0 ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> ans = new LinkedList<>();
        for(int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(people);
    }
}
