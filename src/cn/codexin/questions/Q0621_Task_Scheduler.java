package cn.codexin.questions;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xinGao 2020/12/5
 */

public class Q0621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        int maxExec = 0;
        for(int i = 0; i < 26; i++) {
            maxExec = Math.max(maxExec, freq[i]);
        }
        int maxCnt = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] == maxExec) {
                maxCnt++;
            }
        }
        return Math.max(tasks.length, (maxExec - 1) * (n + 1) + maxCnt);
    }

    public static void main(String[] args) {
        Q0621_Task_Scheduler Q = new Q0621_Task_Scheduler();
        Q.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }
}
