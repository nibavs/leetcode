package com.leetcode.practice._703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;

public class Solution {
    static class KthLargest {
        PriorityQueue<Integer> kElem = new PriorityQueue<>();
        int kk;
        public KthLargest(int k, int[] nums) {
            kk = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            kElem.add(val);
            if (kElem.size() > kk) kElem.poll();
            return kElem.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        kthLargest.kElem.poll();
        System.out.println(kthLargest.kElem);


//        kthLargest.add(3); // return 4
//        kthLargest.add(5); // return 5
//        kthLargest.add(10); // return 5
//        kthLargest.add(9); // return 8
//        kthLargest.add(4); // return 8
    }
}
