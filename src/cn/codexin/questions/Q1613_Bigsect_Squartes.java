package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/13
 */

public class Q1613_Bigsect_Squartes {
    public double[] cutSquares(int[] square1, int[] square2) {
        //计算两个正方形的中心点
        double[] circle1 = {square1[0] + square1[2]/2.0,
                            square1[1] + square1[2]/2.0};
        double[] circle2 = {square2[0] + square2[2]/2.0,
                            square2[1] + square2[2]/2.0};
        double[] ans = new double[4];
        if(circle1[0] == circle2[0]) {
            //垂直的直线
            ans[0] = ans[2] = circle1[0];
            ans[1] = Math.min(square1[1], square2[1]);
            ans[3] = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
            return ans;
        }
        //计算斜率
        double k = (circle2[1] - circle1[1]) / (circle2[0] - circle1[0]);
        if(Math.abs(k) < 1) {
            //和垂直的边相交
            double leftX = Math.min(square1[0], square2[0]);
            double rightX = Math.max(square1[0] + square1[2], square2[0] + square2[2]);
            double leftY = k * (leftX - circle1[0]) + circle1[1];
            double rightY = k * (rightX - circle1[0]) + circle1[1];
            return new double[]{leftX, leftY, rightX, rightY};
        } else {
            //和水平的边相交
            double bottonY = Math.min(square1[1], square2[1]);
            double topY = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
            double bottonX = (bottonY - circle1[1]) / k + circle1[0];
            double topX = (topY - circle1[1]) / k + circle1[0];
            return bottonX < topX ? new double[]{bottonX, bottonY, topX, topY}
                                    : new double[]{topX, topY, bottonX, bottonY};
        }
    }
}
