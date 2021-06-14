package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/14
 */

public class Q0374_Guess_Number_Higher_or_Lower {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = (right - left) / 2 + left;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    // example
    int guess(int num) {
        return 0;
    }
}
