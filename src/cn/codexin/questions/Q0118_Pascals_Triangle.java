package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/12/6
 */

public class Q0118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0; i < numRows; i++) {
            if(i == 0) {
                ans.add(Arrays.asList(1));
            } else {
                List<Integer> tmp = new LinkedList<>();
                List<Integer> last = ans.get(i - 1);
                Integer e = last.get(0);
                tmp.add(e);
                tmp.add(e);
                int len = last.size();
                for(int j = 1; j < len; j++) {
                    tmp.add(j, last.get(j - 1) + last.get(j));
                }
                ans.add(tmp);
            }

        }
        return ans;
    }
}
