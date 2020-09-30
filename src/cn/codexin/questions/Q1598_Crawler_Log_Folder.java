package cn.codexin.questions;

/**
 * Created by xinGao 2020/9/30
 */

public class Q1598_Crawler_Log_Folder {
    public int minOperations(String[] logs) {
        int depth = 0;
        for(String log : logs) {
            if("../".equals(log)) {
                depth = Math.max(0, depth - 1);
            } else if(!"./".equals(log)) {
                depth++;
            }
        }
        return depth;
    }
}
