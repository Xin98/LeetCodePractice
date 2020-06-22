package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/23
 */

public class QInterview_1618_Pattern_Matching {
    public boolean patternMatching(String pattern, String value) {
        int n = value.length();
        int m = pattern.length();
        int countA = 0;
        int countB = 0;
        if(m == 0) return n == 0;
        for (int i = 0; i < m; i++) {
            if(pattern.charAt(i) == 'a') countA++;
            else countB++;
        }
        if(countA < countB){
            int tmp = countA;
            countA = countB;
            countB = tmp;
            pattern = pattern.replaceAll("a", "c");
            pattern = pattern.replaceAll("b", "a");
            pattern = pattern.replaceAll("c", "b");
        }
        if(n == 0) return countB == 0;
        // countA != 0
        String a, b;
        for(int lenA = 0; lenA * countA <= n; lenA++) {
            // la = i;
            // la * Ca + lb * Cb = lv
            // lb = (lv - la * Ca) / Cb
            int pos = 0;
            int lenB;

            if(countB == 0) {
                lenB = 0;
            }else {
                lenB = (n - lenA * countA) / countB;
            }
            if(lenA * countA + lenB * countB != n) continue;
            String aStr = "";
            String bStr = "";
            boolean flag = true;
            for(int j = 0; j < m; j++) {
                int ch = pattern.charAt(j);
                if(ch == 'a') {
                    String sub = value.substring(pos, pos + lenA);
                    if(aStr.length() == 0) {
                        aStr = sub;
                    }else if(!aStr.equals(sub)){
                        flag = false;
                        break;
                    }
                    pos += lenA;
                } else {
                    String sub = value.substring(pos, pos + lenB);
                    if(bStr.length() == 0) {
                        bStr = sub;
                    }else if(!bStr.equals(sub)){
                        flag = false;
                        break;
                    }
                    pos += lenB;
                }
            }
            if(flag && !aStr.equals(bStr)) {
                return true;
            }
        }
        return false;
    }
}
