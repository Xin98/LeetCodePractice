package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/7/6
 */

public class Q1418_Display_Table_of_Food_Orders_in_a_Restaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<String, Integer> foodMap = new TreeMap<>();
        Map<Integer, Map<String, Integer>> ordersMap = new TreeMap<>();
        for (List<String> order : orders) {
            int table = Integer.valueOf(order.get(1));
            String food = order.get(2);
            Map<String, Integer> foodCnt = ordersMap.getOrDefault(table, new HashMap<>());
            foodCnt.put(food, foodCnt.getOrDefault(food, 0) + 1);
            ordersMap.put(table, foodCnt);
            foodMap.put(food, 0);
        }
        List<List<String>> ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        List<String> header = ans.get(0);
        header.add("Table");
        header.addAll(foodMap.keySet());
        for (Map.Entry<Integer, Map<String, Integer>> tableOrder : ordersMap.entrySet()) {
            int table = tableOrder.getKey();
            Map<String, Integer> foodCnt = tableOrder.getValue();
            TreeMap<String, Integer> foodDisplayMap = new TreeMap<>(foodMap);
            foodDisplayMap.putAll(foodCnt);
            List<String> info = new LinkedList<>();
            info.add(String.valueOf(table));
            for (Map.Entry<String, Integer> entry : foodDisplayMap.entrySet()) {
                info.add(String.valueOf(entry.getValue()));
            }
            ans.add(info);
        }
        return ans;
    }
}
