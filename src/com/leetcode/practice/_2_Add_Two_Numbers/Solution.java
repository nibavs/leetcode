package com.leetcode.practice._2_Add_Two_Numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        int extraOne = 0;
        ListNode temp = new ListNode();
        ListNode res = null;
        boolean isFirst = true;
        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                sum = l2.val + extraOne;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + extraOne;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + extraOne;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (sum >= 10) {
                sum %= 10;
                extraOne = 1;
            } else extraOne = 0;

            temp.next = new ListNode(sum);
            if (isFirst) {
                res = temp;
                isFirst = false;
            }
            temp = temp.next;
        }
        if (extraOne == 1) {
            temp.next = new ListNode(1);
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2  = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode res = addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }
}
