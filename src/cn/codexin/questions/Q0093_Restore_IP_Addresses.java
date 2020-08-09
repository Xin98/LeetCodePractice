package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2020/8/9
 */

public class Q0093_Restore_IP_Addresses {
    private List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        dfs(s, "", 0, 0, n);
        return ans;
    }
    public void dfs(String s, String tmp, int begin, int depth, int n) {
        if(depth == 4) {
            if(begin == n) {
                ans.add(tmp.substring(1));
            }
            return;
        }
        if(begin >= n) {
            return;
        }
        if(s.charAt(begin) == '0') {
            dfs(s, tmp + ".0", begin + 1, depth + 1, n);
        } else {
            for (int i = 1; i <= 3; i++) {
                if(begin + i > n) {
                    break;
                }
                String value = s.substring(begin, begin + i);
                Integer intValue = Integer.valueOf(value);
                if(intValue > 255 || intValue < 0) {
                    continue;
                }
                dfs(s, tmp + '.' + value, begin + i, depth + 1, n);
            }
        }
    }

    public static void main(String[] args) {
        Q0093_Restore_IP_Addresses q = new Q0093_Restore_IP_Addresses();
        q.restoreIpAddresses("25525511135");
    }
}
