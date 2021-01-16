package cn.codexin.questions;

/**
 * Created by xinGao 2021/1/17
 */

public class Q1232_Check_If_It_Is_a_Straight_Line {
    public double getSlope(int[] point1, int[] point2) {
        if(point1[0] == point2[0]) {
            return Integer.MAX_VALUE;
        }
        return (double)(point1[1] - point2[1]) / (point1[0] - point2[0]);
    }
    public boolean checkStraightLine(int[][] coordinates) {
        double k = getSlope(coordinates[0], coordinates[1]);
        int n = coordinates.length;
        for(int i = 2; i < n; i++) {
            if(k != getSlope(coordinates[i], coordinates[i-1])){
                return false;
            }
        }
        return true;
    }
}
