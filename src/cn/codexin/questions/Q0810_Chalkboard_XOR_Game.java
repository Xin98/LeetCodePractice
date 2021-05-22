package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/22
 */

public class Q0810_Chalkboard_XOR_Game {
    public boolean xorGame(int[] nums) {
        if(nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
