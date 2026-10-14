package com.leetcode.practice._24_Swap_Nodes_in_Pairs;

import com.leetcode.practice.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = first.next;
        ListNode prev = new ListNode();
        head = head.next;

        // 1,2,3,4
        while (first != null && second != null) {
            ListNode temp = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
            first.next = temp;
            first = temp;
            if (first == null) break;
            second = first.next;
        }


        return head;
    }
}
