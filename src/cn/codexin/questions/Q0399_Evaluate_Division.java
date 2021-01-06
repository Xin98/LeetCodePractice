package cn.codexin.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xinGao 2021/1/6
 */

public class Q0399_Evaluate_Division {
    class UnionFind{
        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            Arrays.fill(weight, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int search(int x) {
            if(x != parent[x]) {
                int px = search(parent[x]);
                weight[x] *= weight[parent[x]];
                parent[x] = px;
            }
            return parent[x];
        }
        public void merge(int x, int y, double val) {
            int px = search(x);
            int py = search(y);
            parent[px] = py;
            weight[px] = val * weight[y] / weight[x];
        }

        public double getWeight(int x) {
            return weight[x];
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<>();
        for (List<String> equation : equations) {
            if(!variables.containsKey(equation.get(0))) {
                variables.put(equation.get(0), nvars++);
            }
            if(!variables.containsKey(equation.get(1))) {
                variables.put(equation.get(1), nvars++);
            }
        }
        UnionFind uf = new UnionFind(nvars);
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            uf.merge(va, vb, values[i]);
        }
        int m = queries.size();
        double[] ans = new double[m];
        for (int i = 0; i < m; i++) {
            double ret = -1.0;
            if(variables.containsKey(queries.get(i).get(0)) && variables.containsKey(queries.get(i).get(1))) {
                int va = variables.get(queries.get(i).get(0));
                int vb = variables.get(queries.get(i).get(1));
                if(uf.search(va) == uf.search(vb)) {
                    ret = uf.getWeight(va) / uf.getWeight(vb);
                }
            }
            ans[i] = ret;
        }
        return ans;
    }
}
