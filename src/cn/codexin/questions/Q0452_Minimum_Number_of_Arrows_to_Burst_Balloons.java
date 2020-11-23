package cn.codexin.questions;

import java.util.Arrays;

/**
 * Created by xinGao 2020/11/23
 */

public class Q0452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (x, y)-> x[1] < y[1] ? -1 : x[1] > y[1] ? 1 : 0);
        int right = points[0][1];
        int ans = 1;
        for(int[] point : points) {
            System.out.println(point[0] + "," + point[1]);
            if(point[0] > right) {
                ans++;
                right = point[1];
            }
        }
        return ans;
    }
}
