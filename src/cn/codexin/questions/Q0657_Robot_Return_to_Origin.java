package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/16
 */

public class Q0657_Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char dir : moves.toCharArray()) {
            if(dir == 'D') y--;
            if(dir == 'U') y++;
            if(dir == 'L') x--;
            if(dir == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
