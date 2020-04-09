package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/9
 */

public class Qinterview1719_Missing_Two_Figure {

    //要求 O(N)时间 O(1)空间
    //思路二：位运算
    public int[] missingTwo(int[] nums) {
        int n = nums.length+2;
        int xor = 0;
        for (int num : nums) xor ^= num;
        for(int i = 1; i <= n; i++) xor ^= i;
        //此时xor 为 miss1 ^ miss2
        //只需要找到一个miss数组就可得到另一个
        int diff = xor & (-xor);//得到miss1 与 miss2 的最低不同位
        int missOne = 0;
        for (int num : nums) {
            //分组
            if((num & diff) != 0) {
                missOne ^= num;
            }
        }
        for(int i = 1; i <= n; i++) {
            //分组
            if((i & diff) != 0){
                missOne ^= i;
            }
        }
        return new int[]{missOne, xor ^ missOne};
    }

    //思路一，利用原来的数组，建立如下关系:
    //1. 1<= i <= len , nums[i-1] = i;
    //2. i > len 不动数组，记录该值到 hash表中  hash[i-len] = 1 即可
    // 再遍历一次数组 如果发现nums[i-1] != i 那么说明 i 缺失
    //最后判断miss 数组里是不是装满了，如果没装满就去hash表里找
    // hash[0] == 1 ,则n+1出现过。 hash[1] == 1, 则n+2出现过
//    public int[] missingTwo(int[] nums) {
//        int[] miss = new int[2];
//        int[] hash = new int[2];
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int j = nums[i];
//            if (j != i + 1) {
//                if (j > n) {
//                    hash[j - n -1] = 1;
//                    continue;
//                }
//                nums[i] = nums[j - 1];
//                nums[j - 1] = j;
//                i--;
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != i + 1) {
//                miss[count++] = i + 1;
//            }
//            if (count == 2) break;
//        }
//        if (count == 0) {
//            miss[0] = n + 1;
//            miss[1] = n + 2;
//        } else if (count == 1) {
//            miss[1] = hash[0] == 1 ? n + 2 : n + 1;
//        }
//        return miss;
//    }
    public static void main(String[] args) {
        Qinterview1719_Missing_Two_Figure qinterview1719_missing_two_figure = new Qinterview1719_Missing_Two_Figure();
        qinterview1719_missing_two_figure.missingTwo(new int[]{2});
    }
}
