package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/12
 */

public class QInterview1603_Intersection {
    private double[] ans = new double[]{};
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], y1 = start1[1], x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1], x4 = end2[0], y4 = end2[1];
        if (((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1)) == 0) {
            //平行
            if ((x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1)) {
                //且四个点都在同一条线上
                if (inside(x1, y1, x2, y2, x3, y3)) update(x3, y3);
                if (inside(x1, y1, x2, y2, x4, y4)) update(x4, y4);
                if (inside(x3, y3, x4, y4, x1, y1)) update(x1, y1);
                if (inside(x3, y3, x4, y4, x2, y2)) update(x2, y2);
            }
        }
        else{
            double t2 = (double) ((x3 - x1) * (y2 - y1) - (y3 - y1) * (x2 - x1)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));
            double t1;
            if(y1 == y2){
                t1 = (double) ((x3 - x1) + (x4 - x3) * t2) / (x2 - x1);
            }
            else{
                t1 = (double)((y3 - y1) + (y4 - y3) * t2) / (y2 - y1);
            }
            if(t1 <= 1.0 && t1 >= 0.0 && t2 <= 1.0 && t2 >= 0.0){
                ans = new double[]{x1+t1*(x2-x1), y1+t1*(y2-y1)};
            }
        }
        return ans;
    }

    public boolean inside(int x1, int y1, int x2, int y2, int xk, int yk) {
        return (x1 == x2 || (xk <= Math.max(x1, x2) && xk >= Math.min(x1, x2))) &&
                (y1 == y2 || (yk <= Math.max(y1, y2) && yk >= Math.min(y1, y2)));
    }
    public void update(double x, double y) {
        if (ans.length == 0) {
            ans = new double[]{x, y};
            return;
        }
        if (x < ans[0]) {
            ans[0] = x;
            ans[1] = y;
            return;
        }
        if (x == ans[0] && y < ans[1]) ans[1] = y;
        return;
    }
}
