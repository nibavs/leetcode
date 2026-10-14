package com.leetcode.practice._1011_Capacity_To_Ship_Packages_Within_D_Days;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(w, left);
            right += w;
        }

        while (left <= right) {
            int mid = left + (right - left)/2;
            int daysNeed = 1;
            int counter = 0;

            for (int w : weights) {
                if (counter + w > mid) {
                    counter = 0;
                    daysNeed++;
                }
                counter += w;
            }
            if (daysNeed > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
