package cn.codexin.questions;

/**
 * Created by xinGao 2021/7/12
 */

public class Q0275_H_Index_II {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}
