package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/22
 */

public class QSword0011_Min_Num_in_Rotate_Array {
    public int minArray(int[] numbers) {
        int lo = 0;
        int hi = numbers.length - 1;
        while(lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if(numbers[mid] > numbers[hi]) {
                lo = mid;
            } else if(numbers[mid] < numbers[hi]){
                hi = mid;
            } else {
                hi--;
            }
        }
        return numbers[lo];
    }
}
