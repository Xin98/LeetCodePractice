package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/27
 */

public class Q0033_Search_in_Rotated_Sorted_Array {
    //要求时间复杂度O(log n)
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        int leftMin = nums[0], rightMax = nums[len-1];
        if(rightMax >= leftMin){
            //说明排序没有被旋转或者长度为1
            if(target >= leftMin && target <= rightMax)
                return binarySearch(nums, 0, len-1, target);
            else return -1;
        }
        else{
            //找出分界点
            int i = 0, j = len-1;
            while(i < j){
                int mid = i + (j-i)/2;
                if(nums[mid] > nums[mid+1]) {
                    i = mid;
                    break;
                }
                if(nums[mid] > nums[i]) i = mid;
                else if(nums[mid] < nums[j]) j = mid;
            }
            //i为左右两区间分界点 左:(0..i) 右:(i+1..len-1)
            if(target >= leftMin && target <= nums[i]) {
                //在左区间搜索
                return binarySearch(nums, 0, i, target);
            }else if(target >= nums[i+1] && target <= rightMax){
                //在右区间搜索
                return binarySearch(nums, i+1, len-1, target);
            }
            else return -1;
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if(left > right) return -1;
        if(left == right) {
            if(nums[left] == target) return left;
            else return -1;
        }
        int mid = left + (right-left)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return binarySearch(nums, left, mid - 1, target);
        else return binarySearch(nums, mid + 1, right, target);
    }

    public static void main(String[] args) {
        Q0033_Search_in_Rotated_Sorted_Array q = new Q0033_Search_in_Rotated_Sorted_Array();
        System.out.println(q.search(new int[]{4,5,1,2,3}, 5));
    }
}
