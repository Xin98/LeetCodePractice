package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/2
 */

public class Q0289_Game_of_Life {
    /*
    * 定义两个额外的状态即可：
    * LIVE_TO_DIE表示这一轮细胞将要从活变死
    * DIE_TO_LIVE表示这一轮细胞将要从死变活
    *
    * 计算周围的细胞有多少存活的时候，LIVE 和 LIVE_TO_DIE 都需要计算成活的。
    *
    * 最后将这两个状态变成真正的状态即可
    * LIVE_TO_DIE -> DIE
    * DIE_TO_LIVE -> LIVE
    * */
    public static final int DIE = 0;
    public static final int LIVE = 1;
    public static final int LIVE_TO_DIE = 2;
    public static final int DIE_TO_LIVE = 3;
    public void gameOfLife(int[][] board) {
        int rSize = board.length, cSize = board[0].length;
        int[] dr = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
        int[] dc = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
        for(int r = 0; r < rSize; r++){
            for(int c = 0; c < cSize; c++){
                int liveCellCount = 0;
                for(int i = 0; i < 8; i++){
                    int newR = r + dr[i], newC = c + dc[i];
                    if(newR < 0 || newR >= rSize || newC < 0 || newC >= cSize) continue;
                    if(board[newR][newC] == LIVE || board[newR][newC] == LIVE_TO_DIE) liveCellCount++;
                }
                if(board[r][c] == LIVE){
                    if(liveCellCount < 2 || liveCellCount > 3) {
                        board[r][c] = LIVE_TO_DIE;
                    }
                }
                else if(liveCellCount == 3) board[r][c] = DIE_TO_LIVE;
            }
        }
        for(int r = 0; r < rSize; r++){
            for(int c = 0; c < cSize; c++){
                if(board[r][c] == LIVE_TO_DIE) board[r][c] = DIE;
                else if(board[r][c] == DIE_TO_LIVE) board[r][c] = LIVE;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        Q0289_Game_of_Life q0289_game_of_life = new Q0289_Game_of_Life();
        q0289_game_of_life.gameOfLife(board);
    }
}
