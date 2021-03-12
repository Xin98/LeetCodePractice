package cn.codexin.questions;

/**
 * Created by xinGao 2021/3/12
 */

public class Q0331_Verify_Preorder_Serialization_of_a_Binary_Tree {
    public boolean isValidSerialization(String preorder) {
        int cnt = 1;
        int n = preorder.length();
        if(n == 0) {
            return false;
        }
        String[] strs = preorder.split(",");
        for(String str : strs) {
            if(cnt == 0) {
                return false;
            }
            if(!str.equals("#")) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cnt == 0;
    }

}
