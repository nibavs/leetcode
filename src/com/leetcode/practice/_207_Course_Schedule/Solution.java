package com.leetcode.practice._207_Course_Schedule;


import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses];


        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(i, graph, state)) return false;
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;

        state[node] = 1;

        for (int next : graph.get(node)) {
            if (hasCycle(next, graph, state)) return true;
        }

        state[node] = 2;
        return false;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
