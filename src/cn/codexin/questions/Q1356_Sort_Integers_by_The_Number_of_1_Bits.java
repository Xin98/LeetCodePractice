package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xinGao 2020/11/6
 */

public class Q1356_Sort_Integers_by_The_Number_of_1_Bits {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> bitNum = new LinkedList<>();
        for(int i = 0; i <= 16; i++) {
            bitNum.add(new LinkedList<>());
        }
        for(int num : arr) {
            int cnt = 0;
            for(int i = 0; i <= 16; i++) {
                if((num & (1 << i)) != 0) {
                    cnt++;
                }
            }
            bitNum.get(cnt).add(num);
        }
        List<Integer> ans = new LinkedList<>();
        int idx = 0;
        for(int i = 0; i <= 16; i++) {
            ans.addAll(bitNum.get(i).stream().sorted().collect(Collectors.toList()));
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Q1356_Sort_Integers_by_The_Number_of_1_Bits Q = new Q1356_Sort_Integers_by_The_Number_of_1_Bits();
        Q.sortByBits(new int[] {1024,512,256,128,64,32,16,8,4,2,1});
    }
}
