package cn.codexin.questions;

/**
 * Created by xinGao 2020/11/3
 */

public class Q1275_Find_Winner_on_a_Tic_Tac_Toe_Game {
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        int k = 3;
        int[] col = new int[k];
        int[] row = new int[k];
        int[] diag = new int[2 * k - 1];
        int[] revDiag = new int[2 * k - 1];
        for(int i = n - 1; i >= 0; i-= 2) {
            int r = moves[i][0];
            int c = moves[i][1];
            row[r]++;
            col[c]++;
            diag[k - 1 - r + c]++;
            revDiag[r + c]++;
            if(row[r] == k|| col[c] == k|| diag[k - 1 - r + c] == k|| revDiag[r + c] == k) {
                return i % 2 == 0? "A": "B";
            }
        }
        return n == k * k? "Draw": "Pending";
    }
}
