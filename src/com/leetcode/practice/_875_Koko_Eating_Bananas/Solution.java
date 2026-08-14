package com.leetcode.practice._875_Koko_Eating_Bananas;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0) return 0;
        int max = piles[0];
        int min = 1;

        for (int p : piles) {
            max = Math.max(max, p);
        }

        int res = max;
        while (max >= min) {
            int mid = min + (max - min) / 2;

            if (canFinish(piles, h, mid)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += p/k;
            if (p % k != 0) hours++;
            if (hours > h) return false;
        }
        return true;
    }
}
