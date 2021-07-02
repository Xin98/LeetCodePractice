package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/29
 */

public class Q0168_Excel_Sheet_Column_Title {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int num = (columnNumber - 1) % 26;
            sb.append((char)('A' + num));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
