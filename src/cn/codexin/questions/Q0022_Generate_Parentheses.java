package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2020/4/9
 */

public class Q0022_Generate_Parentheses {
    //String实际上不需要回溯，因为每次都使用的新的字符串变量
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder res = new StringBuilder();
        helper(res, 0, 0, n);
        return ans;
    }
    public void helper(StringBuilder res, int left, int len, int n){
        if(left == n) {
            for(int i = len;i< 2 * n; i++)
                res.append(")");
            ans.add(res.toString());
            res.delete(len, 2*n);
            return;
        }
        helper(res.append("("), left+1, len+1, n);
        res.deleteCharAt(res.length()-1);
        if(len < 2* left){
            helper(res.append(")"),left,len+1,n);
            res.deleteCharAt(res.length()-1);
        }
    }
    //用StringBuilder实现回溯过程
//    private List<String> ans = new ArrayList<>();
//    public List<String> generateParenthesis(int n) {
//        StringBuilder res = new StringBuilder();
//        helper(res, 0, 0, n);
//        return ans;
//    }
//    public void helper(StringBuilder res, int left, int len, int n){
//        if(left == n) {
//            for(int i = len;i< 2 * n; i++)
//                res.append(")");
//            ans.add(res.toString());
//            res.delete(len, 2*n);
//            return;
//        }
//        helper(res.append("("), left+1, len+1, n);
//        res.deleteCharAt(res.length()-1);
//        if(len < 2* left){
//            helper(res.append(")"),left,len+1,n);
//            res.deleteCharAt(res.length()-1);
//        }
//    }
}
