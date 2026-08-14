package com.leetcode.practice._121_Best_Time_To_Buy_And_Sell_Stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.max(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}
