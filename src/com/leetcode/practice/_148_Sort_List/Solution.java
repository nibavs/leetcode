package com.leetcode.practice._148_Sort_List;

import com.leetcode.practice.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);

        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    private ListNode findMid(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next == null ? fast.next : fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode headA, ListNode headB) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (headA != null || headB != null) {
            if (headA == null) {
                temp.next = headB;
                headB = headB.next;
            } else if (headB == null) {
                temp.next = headA;
                headA = headA.next;
            } else {
                if (headA.val < headB.val) {
                    temp.next = headA;
                    headA = headA.next;
                } else {
                    temp.next = headB;
                    headB = headB.next;
                }
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
