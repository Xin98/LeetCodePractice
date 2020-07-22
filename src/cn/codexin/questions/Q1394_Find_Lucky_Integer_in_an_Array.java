package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/21
 */

public class Q1394_Find_Lucky_Integer_in_an_Array {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n+1];
        for (int num : arr) {
            if(num <= n) {
                hash[num]++;
            }
        }
        for (int i = n; i >= 1; i--) {
            if(hash[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
