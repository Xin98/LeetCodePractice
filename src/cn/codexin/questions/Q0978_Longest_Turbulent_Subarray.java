package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/24
 */

public class Q0978_Longest_Turbulent_Subarray {
    // 法1
//    public int maxTurbulenceSize(int[] arr) {
//        int len = arr.length;
//        if(len == 0) {
//            return 0;
//        }
//        int ans = 1, cnt = 1;
//        for(int i = 1; i < len; i++) {
//            if(arr[i] > arr[i-1]) {
//                if(cnt >= 2 && arr[i-1] < arr[i-2]) {
//                    cnt++;
//                } else {
//                    ans = Math.max(ans, cnt);
//                    cnt = 2;
//                }
//            } else if(arr[i] < arr[i-1]) {
//                if(cnt >= 2 && arr[i-1] > arr[i-2]) {
//                    cnt++;
//                } else {
//                    ans = Math.max(ans, cnt);
//                    cnt = 2;
//                }
//            } else {
//                ans = Math.max(ans, cnt);
//                cnt = 1;
//            }
//        }
//        ans = Math.max(ans, cnt);
//        return ans;
//    }
    // 法2
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int anchor = 0, ans = 1;
        for(int i = 1; i < len; i++) {
            int c = Integer.compare(arr[i-1], arr[i]);
            if(i == len - 1 || (c * Integer.compare(arr[i], arr[i+1])) != -1) {
                if(c != 0) {
                    ans = Math.max(ans, i - anchor + 1);
                }
                anchor = i;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Q0978_Longest_Turbulent_Subarray Q = new Q0978_Longest_Turbulent_Subarray();
        Q.maxTurbulenceSize(new int[]{0,8,45,88,48,68,28,55,17,24});
    }
}
