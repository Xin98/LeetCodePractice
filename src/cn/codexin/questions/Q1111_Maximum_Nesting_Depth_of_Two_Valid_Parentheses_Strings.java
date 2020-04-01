package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/1
 */

public class Q1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings {
    //常规思路:
    //此题要求是A类型的括号和B类型的括号深度尽可能的接近
    //因此根据现在的状态选择分配括号给深度最小的类型
//    public int[] maxDepthAfterSplit(String seq) {
//        int n = seq.length();
//        int[] ans = new int[n];
//        //aLeftParsCount a类型的左括号的个数， bLeftParsCount b类型的左括号的个数
//        int aLeftParsCount = 0, bLeftParsCount = 0;
//        for(int i = 0; i < n; i++){
//            if(seq.charAt(i) == '('){
//                if(aLeftParsCount <= bLeftParsCount){
//                    ans[i] = 0;
//                    aLeftParsCount++;
//                }
//                else{
//                    ans[i] = 1;
//                    bLeftParsCount++;
//                }
//            }
//            else{
//                //这里需要匹配
//                if(aLeftParsCount > bLeftParsCount){
//                    ans[i] = 0;
//                    aLeftParsCount--;
//                }
//                else{
//                    ans[i] = 1;
//                    bLeftParsCount--;
//                }
//            }
//        }
//        return ans;
//    }
    //优化思路
    //简单的思考一下，上述分配规则可以简化为奇偶下标分配，奇下标分配给A, 偶下标的左括号分配给B即可
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = (seq.charAt(i) == '(') ? i&1 : (i+1) & 1;
        }
        return ans;
    }
}
