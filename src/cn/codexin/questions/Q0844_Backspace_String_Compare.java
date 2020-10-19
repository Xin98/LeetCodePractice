package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/10/19
 */

public class Q0844_Backspace_String_Compare {
    public boolean backspaceCompare(String S, String T) {
        List<Character> sList= build(S);
        List<Character> tList= build(T);
        if(sList.size() != tList.size()) {
            return false;
        }
        for(int i = 0; i < sList.size(); i++) {
            if(!sList.get(i).equals(tList.get(i))) {
                return false;
            }
        }
        return true;
    }
    public List<Character> build(String s) {
        List<Character> ans = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c != '#') {
                ans.add(c);
            } else if(ans.size() > 0) {
                ans.remove(ans.size() - 1);
            }
        }
        return ans;
    }
}
