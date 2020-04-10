package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/10
 */

public class Q0151_Reverse_Words_in_a_String {
    //利用StringBuilder 来优化字符串拼接
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        s = s.trim();
        String[] wordSet = s.split("\\s+");
        for (String word : wordSet) {
            ans = ans.insert(0, word + " ");
        }
        return ans.substring(0, ans.length()-1);
    }
//    public String reverseWords(String s) {
//        String ans = "";
//        s = s.trim();
//        String[] wordSet = s.split("\\s+");
//        for (String word : wordSet) {
//            ans = word + " " +ans;
//        }
//        return ans.substring(0, ans.length()-1);
//    }


}
