package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2021/6/19
 */

public class Q1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    private int ans = 0;
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;

            for (char c : s.toCharArray()) {
                int ch = c - 'a';
                if(((mask >> ch) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
            }
            if(mask > 0) {
                masks.add(mask);
            }
        }
        backtrack(masks, 0, 0);
        return ans;
    }

    private void backtrack(List<Integer> masks, int pos, int mask) {
        if(pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if((mask & masks.get(pos)) == 0) {
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }
}
