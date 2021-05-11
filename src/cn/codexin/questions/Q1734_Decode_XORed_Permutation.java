package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/11
 */

public class Q1734_Decode_XORed_Permutation {
    public int[] decode(int[] encoded) {
        int all = 0, rest = 0;
        int length = encoded.length;
        int[] ans = new int[length + 1];
        for(int i = 1; i <= length + 1; i++) {
            all ^= i;
        }
        for(int i = 1; i < length; i += 2) {
            rest ^= encoded[i];
        }
        ans[0] = all ^ rest;
        for(int i = 1; i <= length; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}
