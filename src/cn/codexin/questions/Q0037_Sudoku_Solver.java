package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/9/15
 */

public class Q0037_Sudoku_Solver {
    private List<Set<Character>> rowSets;
    private List<Set<Character>> colSets;
    private List<Set<Character>> subBoxSets;
    private List<int[]> restCellList;
    private boolean finished;
    public void solveSudoku(char[][] board) {
        rowSets = new ArrayList<>();
        colSets = new ArrayList<>();
        subBoxSets = new ArrayList<>();
        int[][] boxIndex = new int[][]{{0,0}, {0,3}, {0,6}, {3,0}, {3,3}, {3,6}, {6,0}, {6,3}, {6,6}};
        restCellList = new LinkedList<>();
        finished = false;
        // initial hashset
        for(int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> subBoxSet = new HashSet<>();
            rowSets.add(rowSet);
            colSets.add(colSet);
            subBoxSets.add(subBoxSet);
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    rowSet.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    colSet.add(board[j][i]);
                }
            }
            int boxJ = boxIndex[i][0];
            int boxK = boxIndex[i][1];
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(board[boxJ + j][boxK + k] != '.') {
                        subBoxSet.add(board[boxJ + j][boxK + k]);
                    }
                }
            }
        }
        // inittial dfs list
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    restCellList.add(new int[]{i, j});
                }
            }
        }
        dfs(board, 0);
    }
    public void dfs(char[][] board, int compeleted) {
        if(finished) {
            return;
        }
        if(compeleted == restCellList.size()) {
            finished = true;
            return;
        }
        int[] cell = restCellList.get(compeleted);
        Set<Character> rowSet = rowSets.get(cell[0]);
        Set<Character> colSet = colSets.get(cell[1]);
        Set<Character> subBoxSet = subBoxSets.get((cell[0] / 3) * 3 + cell[1] / 3);
        for(int i = 1; i <= 9; i++) {
            char num = (char)('0' + i);
            if(rowSet.contains(num) || colSet.contains(num) || subBoxSet.contains(num)) {
                continue;
            }
            rowSet.add(num);
            colSet.add(num);
            subBoxSet.add(num);
            board[cell[0]][cell[1]] = num;
            dfs(board, compeleted + 1);
            rowSet.remove(num);
            colSet.remove(num);
            subBoxSet.remove(num);
        }
    }

    public static void main(String[] args) {
        Q0037_Sudoku_Solver Q = new Q0037_Sudoku_Solver();
        Q.solveSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }

}
