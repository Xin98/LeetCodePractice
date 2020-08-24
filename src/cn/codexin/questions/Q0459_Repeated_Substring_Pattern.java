package cn.codexin.questions;

/**
 * Created by xinGao 2020/8/24
 */

public class Q0459_Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
