package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/8/27
 */

public class Q0332_Reconstruct_Itinerary {
    private Map<String, Queue<String>> map = new HashMap<>();
    private List<String> ans = new ArrayList<>();
    private boolean isEnd = false;
    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size() + 1;
        for (List<String> ticket : tickets) {
            Queue<String> queue = map.getOrDefault(ticket.get(0), new PriorityQueue<String>());
            queue.offer(ticket.get(1));
            map.putIfAbsent(ticket.get(0), queue);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String node) {
        while(map.containsKey(node) && map.get(node).size() > 0) {
            String tmp = map.get(node).poll();
            dfs(tmp);
        }
        ans.add(node);
    }
}
