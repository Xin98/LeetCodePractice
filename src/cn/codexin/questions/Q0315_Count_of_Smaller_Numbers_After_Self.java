package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/7/11
 */

public class Q0315_Count_of_Smaller_Numbers_After_Self {
    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        discretization(nums);
        init(nums.length + 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            int id = getId(nums[i]);
            res.add(query(id-1));
            update(id);
        }
        Collections.reverse(res);
        return res;
    }

    private int getId(int num) {
        return Arrays.binarySearch(a, num) + 1;
    }

    private void init(int size) {
        c = new int[size];
        Arrays.fill(c, 0);
    }

    public int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }
        return ret;
    }
    public void update(int pos) {
        while(pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int lowBit(int pos) {
        return pos & (-pos);
    }

    public void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        a = new int[set.size()];
        int idx = 0;
        for (Integer num : set) {
            a[idx++] = num;
        }
        Arrays.sort(a);
    }
}
