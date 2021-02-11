package cn.codexin.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xinGao 2021/2/11
 */

public class Q0703_Kth_Largest_Element_in_a_Stream {
    class KthLargest {
        private PriorityQueue<Integer> greater;
        private int k;
        public KthLargest(int k, int[] nums) {
            greater = new PriorityQueue<>();
            for (int num : nums) {
                if(greater.size() < k) {
                    greater.offer(num);
                } else if(num > greater.peek()) {
                    greater.poll();
                    greater.offer(num);

                }
            }
            this.k = k;
        }

        public int add(int val) {
            if(greater.size() < k) {
                greater.offer(val);
            } else if(val > greater.peek()) {
                greater.poll();
                greater.offer(val);
            }
            return greater.peek();
        }
    }

}
