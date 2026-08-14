package com.leetcode.practice._11_Container_With_Most_Water;



public class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (right > left) {
            int s = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, s);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
