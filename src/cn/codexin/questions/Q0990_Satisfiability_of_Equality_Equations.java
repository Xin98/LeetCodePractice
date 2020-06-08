package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/8
 */

public class Q0990_Satisfiability_of_Equality_Equations {
    //并查集
    private int[] parent = new int[26];

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if(p1 != p2) {
            parent[p2] = p1;
        }
    }

    public boolean equationsPossible(String[] equations) {
        for(int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if(equation.charAt(1) == '=') {
                union(equation.charAt(0)-'a', equation.charAt(3)-'a');
            }
        }
        for (String equation : equations) {
            if(equation.charAt(1) == '!') {
                if(find(equation.charAt(0)-'a') == find(equation.charAt(3)-'a')) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q0990_Satisfiability_of_Equality_Equations Q = new Q0990_Satisfiability_of_Equality_Equations();
        Q.equationsPossible(new String[]{"a==b","e==c","b==c","a!=e"});
    }
}
