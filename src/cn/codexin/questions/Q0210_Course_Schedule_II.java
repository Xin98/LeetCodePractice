package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/5/17
 */

public class Q0210_Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        int[] indegs = new int[numCourses];
        List<Integer> ans = new ArrayList<>(numCourses);
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) edges.add(new LinkedList<>());
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            indegs[prerequisite[0]]++;
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegs[i] == 0) queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            ans.add(course);
            for (int adjCourse : edges.get(course)) {
                indegs[adjCourse]--;
                if(indegs[adjCourse] == 0) queue.offer(adjCourse);
            }
        }
        return ans.size() == numCourses ? ans.stream().mapToInt(Integer::valueOf).toArray() : new int[]{};
    }
}
