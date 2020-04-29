package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/29
 */

public class Q1095_Find_in_Mountain_Array {
    //二分查找 (3次)
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0, right = len-1;
        while(left < right){
            //第一次二分找最高点
            int top = left + (right - left) / 2;

            if(mountainArr.get(top) < mountainArr.get(top+1)){
                left = top + 1;
            }
            else right = top;
        }
        int top = left;
        int topValue = mountainArr.get(top);
        int leftValue = mountainArr.get(0);
        int rightValue = mountainArr.get(len-1);
        int leftIdx = -1;
        int rightIdx = -1;

        if(target >= leftValue && target < topValue)
            //第二次二分找左边是否存在target
            leftIdx = binarySearch(target, mountainArr, 0, top-1, true);
        if(target >= rightValue && target <= topValue)
            //第三次二分找右边是否存在target
            rightIdx =  binarySearch(target, mountainArr, top, len-1, false);

        return leftIdx != -1 ? leftIdx : rightIdx != -1 ? rightIdx : -1;
    }
    private int binarySearch(int target, MountainArray mountainArr, int left, int right, boolean isAsc) {
        while(left <= right){
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if(value == target) return mid;
            else if(value < target){
                if(isAsc) left = mid + 1;
                else right = mid - 1;
            }
            else{
                if(isAsc) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
    interface MountainArray {
        public int get(int index);
        public int length();
    }
    public static void main(String[] args) {
        Q1095_Find_in_Mountain_Array Q = new Q1095_Find_in_Mountain_Array();
        Q.findInMountainArray(3, new MountainArray() {
            private int[] data = {1,2,3,4,5,3,1};
            @Override
            public int get(int index) {
                return data[index];
            }
            @Override
            public int length() {
                return data.length;
            }
        });
    }
}
