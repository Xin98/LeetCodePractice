package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/10
 */

public class Q0860_Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[2];
        for(int bill : bills) {
            if(bill == 5) {
                change[0]++;
            } else if(bill == 10) {
                if(change[0] == 0) {
                    return false;
                }
                change[1]++;
                change[0]--;
            } else {
                if(change[1] == 0) {
                    if(change[0] < 3) {
                        return false;
                    }
                    change[0] -= 3;
                } else {
                    if(change[0] == 0) {
                        return false;
                    }
                    change[0]--;
                    change[1]--;
                }
            }
        }
        return true;
    }
}
