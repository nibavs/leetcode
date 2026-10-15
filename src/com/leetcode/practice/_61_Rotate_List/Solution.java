package com.leetcode.practice._61_Rotate_List;

import com.leetcode.practice.ListNode;

public class Solution {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        k = k % size;
        if (k == 0) return head;

        temp = head;
        int iterCount = size - k - 1;

        while (iterCount != 0) {
            temp = temp.next;
            iterCount--;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        temp = newHead;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head = newHead;

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.println(rotateRight(head, 4));
    }
}
