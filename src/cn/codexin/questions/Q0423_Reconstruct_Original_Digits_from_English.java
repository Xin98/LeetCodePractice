package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/13
 */

public class Q0423_Reconstruct_Original_Digits_from_English {
    //"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    //                 |                |               |               |
    //                 w                u               x               g
    public String originalDigits(String s) {
        char[] count = new char[26 + (int)'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }
        int[] out = new int[10];
        out[0] = count['z'];
        out[2] = count['w'];
        out[4] = count['u'];
        out[6] = count['x'];
        out[8] = count['g'];
        out[3] = count['h'] - out[8];
        out[5] = count['f'] - out[4];
        out[7] = count['s'] - out[6];
        out[9] = count['i'] - out[5] - out[6] - out[8];
        out[1] = count['o'] - out[0] - out[2] - out[4];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < out[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
