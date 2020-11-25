package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xinGao 2020/11/25
 */

public class Q1370_Increasing_Decreasing_String {
    public String sortString(String s) {
        Map<Character, Integer> freq = new TreeMap<>();
        for(char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<int[]> freqList = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            freqList.add(new int[]{entry.getKey() - 'a', entry.getValue()});
        }
        StringBuilder sb = new StringBuilder();
        while(!freqList.isEmpty()) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < freqList.size(); i++) {
                char c = (char) (freqList.get(i)[0] + 'a');
                sb1.append(c);
                if(freqList.get(i)[1] >= 2) {
                    sb2.append(c);
                    freqList.get(i)[1]--;
                }
                freqList.get(i)[1]--;
                if(freqList.get(i)[1] == 0) {
                    freqList.remove(i);
                    i--;
                }
            }
            sb.append(sb1.toString() + sb2.reverse().toString());
        }
        return sb.toString();
    }
}
