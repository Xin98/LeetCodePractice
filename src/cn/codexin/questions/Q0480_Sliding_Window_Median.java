package cn.codexin.questions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by xinGao 2021/2/3
 */

public class Q0480_Sliding_Window_Median {
    class DualHeep{
        private int k;
        private int smallSize;
        private int largeSize;
        private PriorityQueue<Integer> smallHeep;
        private PriorityQueue<Integer> largeHeep;
        private Map<Integer, Integer> delayDeletedMap;

        public DualHeep(int k) {
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
            this.smallHeep = new PriorityQueue<>(Comparator.reverseOrder());
            this.largeHeep = new PriorityQueue<>(Integer::compareTo);
            this.delayDeletedMap = new HashMap<>();
        }

        public void insert(int num) {
            if(smallHeep.isEmpty() || num <= smallHeep.peek()) {
                smallHeep.offer(num);
                smallSize++;
            } else {
                largeHeep.offer(num);
                largeSize++;
            }
            makeBalance();
        }

        public double getMedianNum() {
            return ((k & 1) == 1) ? smallHeep.peek() : ((double)smallHeep.peek() + largeHeep.peek()) / 2;
        }

        public void erase(int num) {
            delayDeletedMap.put(num, delayDeletedMap.getOrDefault(num, 0) + 1);
            if(num <= smallHeep.peek()) {
                smallSize--;
                if(num == smallHeep.peek()) {
                    prune(smallHeep);
                }
            } else {
                largeSize--;
                if(num == largeHeep.peek()) {
                    prune(largeHeep);
                }
            }
            makeBalance();
        }

        private void prune(PriorityQueue<Integer> heep) {
            while (!heep.isEmpty()) {
                Integer num = heep.peek();
                if(delayDeletedMap.containsKey(num)) {
                    heep.poll();
                    delayDeletedMap.put(num, delayDeletedMap.get(num) - 1);
                    if(delayDeletedMap.get(num) == 0) {
                        delayDeletedMap.remove(num);
                    }
                } else {
                    break;
                }
            }
        }

        private void makeBalance() {
            if(largeSize > smallSize) {
                largeSize--;
                smallSize++;
                smallHeep.offer(largeHeep.poll());
                prune(largeHeep);
            } else if(smallSize > largeSize + 1) {
                largeSize++;
                smallSize--;
                largeHeep.offer(smallHeep.poll());
                prune(smallHeep);
            }
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        DualHeep heep = new DualHeep(k);
        for (int i = 0; i < k; i++) {
            heep.insert(nums[i]);
        }
        ans[0] = heep.getMedianNum();
        for (int i = k; i < n; i++) {
            heep.erase(nums[i - k]);
            heep.insert(nums[i]);
            ans[i - k + 1] = heep.getMedianNum();
        }
        return ans;
    }
}
