package com.leetcode.practice._234_Palindrome_Linked_List;

import com.leetcode.practice.ListNode;


class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next == null ? fast.next : fast.next.next;
        }

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (prev != null && head != null) {
            if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }


        return true;
    }
}


