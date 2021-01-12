package cn.codexin.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xinGao 2021/1/12
 */

public class Q1203_Sort_Items_by_Groups_Respecting_Dependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> groupItems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            groupItems.add(new ArrayList<>());
        }
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            groupGraph.add(new ArrayList<>());
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        int leftGroupId = n - 1;
        for (int i = 0; i < n; i++) {
            if(group[i] == -1) {
                group[i] = leftGroupId--;
            }
            groupItems.get(group[i]).add(i);
        }
        int[] groupDeg = new int[n];
        int[] itemDeg = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> beforeItem = beforeItems.get(i);
            int curGroup = group[i];
            for (Integer item : beforeItem) {
                int itemGroup = group[item];
                if(curGroup != itemGroup) {
                    groupDeg[curGroup]++;
                    groupGraph.get(itemGroup).add(curGroup);
                } else {
                    itemDeg[i]++;
                    itemGraph.get(item).add(i);
                }
            }
        }
        List<Integer> items = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            items.add(i);
        }
        List<Integer> sortedGroup = topSort(groupDeg, groupGraph, items);
        if(sortedGroup.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int idx = 0;
        for (Integer groupId : sortedGroup) {
            int size = groupItems.get(groupId).size();
            if(size == 0) {
                continue;
            }
            List<Integer> res = topSort(itemDeg, itemGraph, groupItems.get(groupId));
            if(res.size() == 0) {
                return new int[0];
            }
            for (Integer e : res) {
                ans[idx++] = e;
            }
        }
        return ans;
    }

    public List<Integer> topSort(int[] deg, List<List<Integer>> graph, List<Integer> items) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer item : items) {
            if(deg[item] == 0) {
                queue.offer(item);
            }
        }
        List<Integer> ans = new LinkedList<>();
        while(!queue.isEmpty()) {
            int u = queue.poll();
            ans.add(u);
            for (Integer v : graph.get(u)) {
                deg[v]--;
                if(deg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return ans.size() == items.size() ? ans : new LinkedList<>();
    }
}
