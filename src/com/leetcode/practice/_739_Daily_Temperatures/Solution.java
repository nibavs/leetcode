package com.leetcode.practice._739_Daily_Temperatures;


import java.util.*;

public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temp = new int[] {55,38,53,81,61,93,97,32,43,78};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
}
