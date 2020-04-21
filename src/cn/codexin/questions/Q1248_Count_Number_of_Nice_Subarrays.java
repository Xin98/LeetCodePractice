package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/21
 */

public class Q1248_Count_Number_of_Nice_Subarrays {
    //dp从0-k找 未优化的时间空间复杂度都 O(n^2)
    //双指针空间复杂度为O(1) 时间复杂度 O(n)
    //双指针解法:
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int lo = 0, hi = 0;
        int leftCount = 0, rightCount = 0;
        int ans = 0;
        for(;hi < n; hi++){
            if((nums[hi] & 1) == 1) k--;
            if(k == 0) break;
        }
        // hi >= n 就说明 整个序列中没有奇数，那么直接返回ans
        for(;hi < n;){
            leftCount = 1;
            rightCount = 1;
            // lo最多找到hi处，因为上个hi处必为奇数
            for(;lo <= hi; leftCount++){
                //lo开始处可能是 奇数 也可能是 偶数 所以不需要跳过第一个
                //奇数： 长度为1  偶数：继续往下找到奇数计算长度。
                // 例如格式为： 0001 xxxx 1000 1 此时长度为 4 * 4
                //lo++ 保证lo 至少前进一步
                if((nums[lo++] & 1) == 1) break;
            }
            //保证 hi至少前进一步
            hi++;
            for(;hi < n; hi++,rightCount++){
                // hi是从 奇数 开始的， 所以要跳过第一个 找到下一个奇数或者到达末尾。
                if((nums[hi] & 1) == 1) break;
            }
            ans += leftCount * rightCount;
        }
        return ans;
    }


    //二维dp 超出内存限制
//    public int numberOfSubarrays(int[] nums, int k) {
//        int n = nums.length;
//        int[][] dp = new int[k+1][n+1];
//        //初始化
//        for(int i = 0; i < n; i++){
//            if(nums[i] % 2 == 0){ //偶数
//                dp[0][i+1] = 1;
//            }
//            else{ //奇数
//                dp[1][i+1] = 1;
//            }
//        }
//        int ans = 0;
//        for(int i = 0; i <= k; i++){
//            for(int j = 0; j < n; j++){
//                if(nums[j] % 2 == 0){
//                    dp[i][j+1] += dp[i][j];
//                }
//                else{
//                    if(i != 0){
//                        dp[i][j+1] += dp[i-1][j];
//                    }
//
//                }
//            }
//
//        }
//        for(int i = 1; i <= n; i++) ans += dp[k][i];
//        return ans;
//    }

    //优化空间的 dp  依旧超时
//    public int numberOfSubarrays(int[] nums, int k) {
//        int n = nums.length;
//        int[][] dp = new int[2][n + 1];
//        int ans = 0, newI = 0;
//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j < n; j++) {
//                newI = i % 2;
//                if (nums[j] % 2 == 0) {
//                    if (i == 0)
//                        dp[newI][j + 1] = dp[newI][j] + 1;
//                    else dp[newI][j + 1] = dp[newI][j];
//                } else {
//                    if (i != 0) {
//                        if (i == 1)
//                            dp[newI][j + 1] = dp[1 - newI][j] + 1;
//                        else dp[newI][j + 1] = dp[1 - newI][j];
//                    }
//                }
//            }
//
//        }
//        for (int i = 1; i <= n; i++) ans += dp[newI][i];
//        return ans;
//    }

    public static void main(String[] args) {
        Q1248_Count_Number_of_Nice_Subarrays q1248_count_number_of_nice_subarrays = new Q1248_Count_Number_of_Nice_Subarrays();
        q1248_count_number_of_nice_subarrays.numberOfSubarrays(new int[]{1,1,2,1,1},3);
    }
}
