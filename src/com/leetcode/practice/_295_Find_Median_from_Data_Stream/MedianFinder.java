package com.leetcode.practice._295_Find_Median_from_Data_Stream;

import java.util.*;

public class MedianFinder {
    private final PriorityQueue<Integer> right;
    private final PriorityQueue<Integer> left;

    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }

        return ((long) left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
