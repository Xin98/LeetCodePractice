package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/28
 */

public class QInterview0056_Occurrences_of_Numbers_in_the_Array {
    public int[] singleNumbers(int[] nums) {
        int two = 0;
        for (int num : nums) {
            two ^= num;
        }
        int diff = two & (-two);
        int x = 0;
        for (int num : nums) {
            if((num & diff) != 0){
                x ^= num;
            }
        }
        return new int[]{x, two^x};
    }
}
