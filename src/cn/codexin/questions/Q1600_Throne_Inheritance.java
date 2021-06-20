package cn.codexin.questions;

import java.util.*;

public class Q1600_Throne_Inheritance {
    class ThroneInheritance {
        Map<String, List<String>> edges;
        Set<String> dead;
        String king;
        public ThroneInheritance(String kingName) {
            king = kingName;
            edges = new HashMap<>();
            dead = new HashSet<>();
        }

        public void birth(String parentName, String childName) {
            if(!edges.containsKey(parentName)) {
                edges.put(parentName, new LinkedList<>());
            }
            List<String> edge = edges.get(parentName);
            edge.add(childName);
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<>();
            preOrder(ans, king);
            return ans;
        }

        private void preOrder(List<String> ans, String name) {
            if(!dead.contains(name)) {
                ans.add(name);
            }
            List<String> children = edges.getOrDefault(name, new LinkedList<>());
            for (String child : children) {
                preOrder(ans, child);
            }
        }
    }
}
