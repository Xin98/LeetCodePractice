package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/24
 */

public class Q1024_Video_Stitching {
    public int videoStitching(int[][] clips, int T) {
        int[] endBounds = new int[T + 1];
        for(int[] clip : clips) {
            endBounds[clip[0]] = Math.max(clip[1], endBounds[clip[0]]);
        }
        int beginBound = 0, endBound = 0, cnt = 0;
        while(beginBound <= endBound) {
            cnt++;
            System.out.println(endBound);
            if(endBound >= T) {
                return cnt;
            }
            int tmp = endBound;
            for(int i = beginBound; i <= endBound; i++) {
                tmp = Math.max(tmp, endBounds[i]);
            }
            beginBound = endBound + 1;
            endBound = tmp;
        }
        return -1;

    }

    public static void main(String[] args) {
        Q1024_Video_Stitching Q = new Q1024_Video_Stitching();
        Q.videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}, 10);
    }
}
