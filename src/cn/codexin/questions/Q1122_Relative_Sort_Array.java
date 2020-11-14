package cn.codexin.questions;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xinGao 2020/11/14
 */

public class Q1122_Relative_Sort_Array {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Map<Integer, Integer> freq = new TreeMap<>();
        for(int num : arr1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[n];
        int idx = 0;
        for(int num : arr2) {
            int c = freq.get(num);
            Arrays.fill(ans, idx, idx + c, num);
            idx += c;
            freq.remove(num);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int c = entry.getValue();
            Arrays.fill(ans, idx, idx + c, num);
            idx += c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q1122_Relative_Sort_Array Q = new Q1122_Relative_Sort_Array();
        Q.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
    }
}
