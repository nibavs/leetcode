package com.leetcode.practice._69_Sqrt_x;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int mySqrt(int x) {
        int l = 1;
        int r = x;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (x / m == m) return m;
            if (x / m < m) r = m - 1;
            else l = m + 1;
        }
        return r;
    }

    public static class A {}
    public static class B extends A {}

    public static void main(String[] args) {
//        List<A> list = new ArrayList<B>();

    }
}
