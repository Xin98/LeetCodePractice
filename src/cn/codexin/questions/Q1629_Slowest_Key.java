package cn.codexin.questions;

/**
 * Created by xinGao 2020/12/8
 */

public class Q1629_Slowest_Key {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] keyDuration = new int[26];
        int maxDuration = 0;
        for(int i = 0; i < keysPressed.length(); i++) {
            int duration = releaseTimes[i] - (i > 0 ? releaseTimes[i - 1] : 0);
            int idx = keysPressed.charAt(i) - 'a';
            if(duration > keyDuration[idx]) {
                keyDuration[idx] = duration;
            }
            maxDuration = Math.max(maxDuration, keyDuration[idx]);
        }
        for(int i = 25; i >= 0; i--) {
            if(keyDuration[i] == maxDuration) {
                return (char)(i + 'a');
            }
        }
        return 'a';
    }
}
