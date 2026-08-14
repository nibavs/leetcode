package com.leetcode.practice._206_Reverse_Linked_List;


public class Solution {
    static public class ListNode {
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

    public static ListNode reverseList(ListNode head) {
        ListNode node = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        ListNode temp = node;
        for (int i = 0; i < 5; i++) {
            temp.next = new ListNode(i + 2);
            temp = temp.next;
        }
        reverseList(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }




    }


}
