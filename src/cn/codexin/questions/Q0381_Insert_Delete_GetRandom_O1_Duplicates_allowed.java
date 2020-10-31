package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/10/31
 */

public class Q0381_Insert_Delete_GetRandom_O1_Duplicates_allowed {
    class RandomizedCollection {
        Map<Integer, Set<Integer>> dataIndexMap;
        List<Integer> data;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            data = new ArrayList<>();
            dataIndexMap = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean exist = false;
            if(!dataIndexMap.containsKey(val)) {
                exist = true;
                dataIndexMap.put(val, new HashSet<>());
            }
            dataIndexMap.get(val).add(data.size());
            data.add(val);
            return exist;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!dataIndexMap.containsKey(val)) {
                return false;
            }
            Set<Integer> indexSet = dataIndexMap.get(val);
            int index = (Integer)(indexSet.iterator().next());
            indexSet.remove(index);
            if(indexSet.size() == 0) {
                dataIndexMap.remove(val);
            }
            // 如果当前的值不是最后一个，那么需要把当前需要删除的值与最后一个元素的值进行交换，然后删除 使得时间复杂度为O(1)
            if(data.size() != index + 1) {
                int replaceVal = data.get(data.size() - 1);
                data.set(index, replaceVal);
                // 更新indexMap
                dataIndexMap.get(replaceVal).remove(data.size() - 1);
                dataIndexMap.get(replaceVal).add(index);
            }
            // 删除当前值
            data.remove(data.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return data.get((int)(Math.random() * data.size()));
        }
    }
}
