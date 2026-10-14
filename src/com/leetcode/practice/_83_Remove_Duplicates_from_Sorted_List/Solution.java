package com.leetcode.practice._83_Remove_Duplicates_from_Sorted_List;

import com.leetcode.practice.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (current.val != prev.val) {
                prev.next = current;
                prev = current;
            }
            current = current.next;
        }
        prev.next = null;

        return head;
    }
}
