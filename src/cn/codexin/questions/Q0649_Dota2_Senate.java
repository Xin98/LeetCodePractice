package cn.codexin.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xinGao 2020/12/11
 */

public class Q0649_Dota2_Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while(!radiant.isEmpty() && !dire.isEmpty()) {
            if(radiant.peek() < dire.peek()) {
                radiant.offer(radiant.peek() + n);
            } else {
                dire.offer(dire.peek() + n);
            }
            radiant.poll();
            dire.poll();
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
