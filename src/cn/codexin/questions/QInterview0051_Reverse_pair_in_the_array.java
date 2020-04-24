package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/24
 */

public class QInterview0051_Reverse_pair_in_the_array {
    // 利用归并排序的过程 完成逆序检测  后面部分插入的时候 前面剩余的部分全部都是逆序（因为全部大于插入的值）
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if(len < 2) return 0;
        int[] tmp = new int[len];
        return reversePairs(nums, 0, len-1, tmp);
    }

    /**
     * 排序并计算num[left..right]的逆序数
     * @param nums
     * @param left
     * @param right
     * @param tmp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] tmp) {
        if(left == right) return 0;
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid+1, right, tmp);
        if(nums[mid] <= nums[mid+1]){
            return leftPairs + rightPairs;
        }
        return leftPairs + rightPairs + mergeAndCount(nums, left, mid, right, tmp);

    }

    /**
     * nums[left..mid] 有序  nums[mid+1..right]有序
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param tmp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {
        for(int i = left; i <= right; i++){
            tmp[i] = nums[i];
        }
        int i = left;
        int j = mid+1;
        int count = 0;
        for(int k = left; k <= right; k++){
            if(i == mid+1){
                nums[k] = tmp[j++];
            }
            else if(j == right+1){
                nums[k] = tmp[i++];
            }
            else{
                if(tmp[i] <= tmp[j]){
                    nums[k] = tmp[i++];
                }
                else{
                    nums[k] = tmp[j++];
                    count += (mid + 1 - i);
                }
            }
        }
        return count;
    }
}
