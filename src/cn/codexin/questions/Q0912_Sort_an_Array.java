package cn.codexin.questions;

/**
 * Created by xinGao 2020/3/31
 */

public class Q0912_Sort_an_Array {
    //三种排序都是升序
    //排序1:快排
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
    void sort(int[] nums, int l, int r){
        if(l >= r) return;
        int m = partition(nums, l, r);
        sort(nums, l, m-1);
        sort(nums, m+1, r);
    }
    int partition(int[] nums, int l, int r){
        int i = l, j = r+1, f = nums[i];
        while(true){
            while(i < r && nums[++i] <= f);
            while(j > l && nums[--j] >= f);
            if(i >= j) break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[l] = nums[j];
        nums[j] = f;
        return j;
    }
    //排序2: 堆排序
//    public int[] sortArray(int[] nums) {
//        heapSort(nums);
//        return nums;
//    }
//    void maxHeapify(int[] nums, int i, int len){
//        int leftChild, rightChild, large;
//        for(; (i << 1)+1 <= len;){
//            large = i;
//            leftChild = (i << 1) + 1;
//            rightChild = (i << 1) + 2;
//            if(leftChild > len) break;
//            if(nums[large] < nums[leftChild]) {
//                large = leftChild;
//            }
//            if(rightChild <= len && nums[large] < nums[rightChild]) {
//                large = rightChild;
//            }
//            if(large != i){
//                int tmp = nums[large];
//                nums[large] = nums[i];
//                nums[i] = tmp;
//                i = large;
//            }
//            else break;
//        }
//    }
//    void buildMaxHeap(int[] nums, int len){
//        for(int i = (len-1)/2; i >=0 ; i--){
//            maxHeapify(nums, i, len);
//        }
//    }
//    void heapSort(int[] nums){
//        int len = nums.length-1;
//        buildMaxHeap(nums, len);
//        for(; len >= 1;){
//            int tmp = nums[0];
//            nums[0] = nums[len];
//            nums[len] = tmp;
//            len--;
//            maxHeapify(nums, 0, len);
//        }
//    }
    //排序3:归并排
//    private int[] tmp;
//    public int[] sortArray(int[] nums) {
//        int len = nums.length;
//        tmp = new int[len];
//        mergeSort(nums, 0, len);
//        return nums;
//    }
//
//    void mergeSort(int[] nums, int l, int r){
//        if(l >= r) return;
//        int m = (l + r) >> 1;
//        mergeSort(nums, l, m);
//        mergeSort(nums, m + 1, r);
//        int i = l, j = m+1, cnt = l;
//        while(i <= m && j <= r){
//            if(nums[i] <= nums[j]){
//                tmp[cnt++] = nums[i++];
//            }
//            else{
//                tmp[cnt++] = nums[j++];
//            }
//        }
//        while(i <= m) tmp[cnt++] = nums[i++];
//        while(j <= r) tmp[cnt++] = nums[j++];
//        for(int k = l; k <= r; k++) nums[k] = tmp[k];
//    }
    public static void main(String[] args) {
        Q0912_Sort_an_Array q0912_sort_an_array = new Q0912_Sort_an_Array();
        int[] nums = {5, 2, 3, 1};
        q0912_sort_an_array.sortArray(nums);
        for(int n : nums) System.out.println(n+" ");
    }
}
