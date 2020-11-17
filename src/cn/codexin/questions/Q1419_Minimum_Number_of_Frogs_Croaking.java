package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/17
 */

public class Q1419_Minimum_Number_of_Frogs_Croaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        for(char w : croakOfFrogs.toCharArray()) {
            if(w == 'c') {
                if(k > 0) {
                    k--;
                }
                c++;
            } else if(w == 'r') {
                c--;r++;
            } else if(w == 'o') {
                r--;o++;
            } else if(w == 'a') {
                o--;a++;
            } else {
                a--;k++;
            }
            if(c < 0 || r < 0 || o < 0 || a < 0) {
                break;
            }
        }
        if(c != 0 || r != 0|| o != 0 || a !=0) {
            return -1;
        }
        return k;
    }
}
