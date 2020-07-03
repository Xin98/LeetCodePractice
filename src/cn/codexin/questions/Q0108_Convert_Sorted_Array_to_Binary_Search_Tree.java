package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/3
 */

public class Q0108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedTree(nums, 0, nums.length - 1);
    }
    public TreeNode buildBalancedTree(int[] nums, int left, int right) {
        if(left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = buildBalancedTree(nums, left, mid - 1);
        head.right = buildBalancedTree(nums, mid + 1, right);
        return head;
    }
}
