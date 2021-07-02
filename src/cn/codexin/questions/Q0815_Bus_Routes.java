package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/6/28
 */

public class Q0815_Bus_Routes {
    // method1 : 44/45
//    class BusRoute{
//        Integer bus;
//        Set<Integer> visitedBuses;
//
//        public BusRoute(Integer bus) {
//            this.bus = bus;
//            visitedBuses = new HashSet<>();
//        }
//    }
//    public int numBusesToDestination(int[][] routes, int source, int target) {
//        if(source == target) {
//            return 0;
//        }
//        Map<Integer, List<Integer>> stopBusMap = new HashMap<>();
//        int n = routes.length;
//        for (int i = 0; i < n; i++) {
//            for (int stop : routes[i]) {
//                if(!stopBusMap.containsKey(stop)) {
//                    stopBusMap.put(stop, new LinkedList<>());
//                }
//                stopBusMap.get(stop).add(i);
//            }
//        }
//        // save buses
//        Queue<BusRoute> queue = new LinkedList<>();
//        for (Integer bus : stopBusMap.get(source)) {
//            queue.offer(new BusRoute(bus));
//        }
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            for (int i = 0; i < size; i++) {
//                BusRoute busRoute = queue.poll();
//                Integer bus = busRoute.bus;
//                Set<Integer> visitedBuses = busRoute.visitedBuses;
//                visitedBuses.add(bus);
//                for (int stop : routes[bus]) {
//                    if(stop == target) {
//                        return depth;
//                    }
//                    for (Integer nextBus : stopBusMap.get(stop)) {
//                        if(visitedBuses.contains(nextBus)) {
//                            continue;
//                        }
//                        BusRoute next = new BusRoute(nextBus);
//                        next.visitedBuses = visitedBuses;
//                        queue.offer(next);
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    // method2

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> stopBusMap = new HashMap<>();
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                List<Integer> buses = stopBusMap.getOrDefault(stop, new LinkedList<>());
                for (Integer j : buses) {
                    edge[i][j] = edge[j][i] = true;
                }
                buses.add(i);
                stopBusMap.put(stop, buses);
            }
        }
        // save buses
        Queue<Integer> queue = new LinkedList<>();
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        for (Integer bus : stopBusMap.getOrDefault(source, new LinkedList<>())) {
            queue.offer(bus);
            dis[bus] = 1;
        }
        while (!queue.isEmpty()) {
            Integer curBus = queue.poll();
            for (int nextBus = 0; nextBus < n; nextBus++) {
                if(edge[curBus][nextBus] && dis[nextBus] == -1) {
                    queue.offer(nextBus);
                    dis[nextBus] = dis[curBus] + 1;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Integer bus : stopBusMap.getOrDefault(target, new LinkedList<>())) {
            if(dis[bus] != -1) {
                ans = Math.min(ans, dis[bus]);
            }
        }
        return ans == Integer.MAX_VALUE? -1: ans;
    }
}
