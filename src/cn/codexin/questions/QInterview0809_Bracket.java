package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/6/11
 */

public class QInterview0809_Bracket {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, 0, 0, n);
        return ans;
    }

    // 回溯法
    private void dfs(List<String> ans, StringBuilder sb, int leftPa, int rightPa, int n) {
        if(leftPa == n && rightPa == n) {
            ans.add(sb.toString());
            return;
        }
        // 当前位置(对应dfs中的深度)的括号类型只有两种可能
        //1. 左括号
        if(leftPa < n) {
            sb.append("(");
            dfs(ans, sb, leftPa + 1, rightPa, n);
            sb.deleteCharAt(sb.length()-1);
        }
        //2. 右括号
        if(rightPa < n && rightPa <leftPa) {
            sb.append(")");
            dfs(ans, sb, leftPa, rightPa + 1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
