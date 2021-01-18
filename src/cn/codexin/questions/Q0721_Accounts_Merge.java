package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2021/1/18
 */

public class Q0721_Accounts_Merge {
    class UnionFind {
        private int[] f;

        public UnionFind(int n) {
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int search(int x) {
            if (x != f[x]) {
                f[x] = search((f[x]));
            }
            return f[x];
        }

        public void merge(int x, int y) {
            int fx = search(x);
            int fy = search(y);
            if (fx != fy) {
                f[fx] = fy;
            }
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> email2index = new HashMap<>();
        Map<String, String> email2name = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if(!email2index.containsKey(email)){
                    email2index.put(email, emailCount++);
                    email2name.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailCount);
        for (List<String> account : accounts) {
            int size = account.size();
            for (int i = 2; i < size; i++) {
                uf.merge(email2index.get(account.get(i - 1)), email2index.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> index2emails = new HashMap<>();
        for (String email : email2index.keySet()) {
            int index = uf.search(email2index.get(email));
            if(!index2emails.containsKey(index)) {
                index2emails.put(index, new LinkedList<>());
            }
            index2emails.get(index).add(email);
        }
        List<List<String>> ans = new LinkedList<>();
        for (Map.Entry<Integer, List<String>> entry : index2emails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String name = email2name.get(emails.get(0));
            List<String> account = new LinkedList<>();
            account.add(name);
            account.addAll(emails);
            ans.add(account);
        }
        return ans;
    }
}
