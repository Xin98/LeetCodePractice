package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/7/13
 */

public class Q0218_The_Skyline_Problem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> buildingPoints = new LinkedList<>();
        for (int[] building : buildings) {
            buildingPoints.add(new int[]{building[0], -building[2]});
            buildingPoints.add(new int[]{building[1], building[2]});
        }
        buildingPoints.sort((a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> delayDel = new HashMap<>();
        maxHeap.offer(0);
        int lastHeight = 0;
        List<List<Integer>> ans = new LinkedList<>();
        for (int[] buildingPoint : buildingPoints) {
            if(buildingPoint[1] < 0) {
                maxHeap.offer(-buildingPoint[1]);
            } else {
                delayDel.put(buildingPoint[1], delayDel.getOrDefault(buildingPoint[1], 0) + 1);
            }
            while (!maxHeap.isEmpty()) {
                int curHeight = maxHeap.peek();
                if(delayDel.containsKey(curHeight)) {
                    delayDel.put(curHeight, delayDel.get(curHeight) - 1);
                    if(delayDel.get(curHeight) == 0) {
                        delayDel.remove(curHeight);
                    }
                    maxHeap.poll();
                } else {
                    break;
                }
            }
            int curHeight = maxHeap.peek();
            if(curHeight != lastHeight) {
                ans.add(Arrays.asList(buildingPoint[0], curHeight));
                lastHeight = curHeight;
            }
        }
        return ans;
    }
}
