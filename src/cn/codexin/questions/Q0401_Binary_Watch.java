package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/6/21
 */

public class Q0401_Binary_Watch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i <= turnedOn; i++) {
            List<String> hours = getHours(i);
            List<String> minutes = getMinutes(turnedOn - i);
            for (String hour : hours) {
                for (String minute : minutes) {
                    ans.add(hour + ":" + minute);
                }
            }
        }
        return ans;
    }

    private List<String> getMinutes(int count) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 60; i++) {
            if(Integer.bitCount(i) == count) {
                ans.add((i < 10 ? "0" : "") + String.valueOf(i));
            }
        }
        return ans;
    }

    private List<String> getHours(int count) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            if(Integer.bitCount(i) == count) {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

}
