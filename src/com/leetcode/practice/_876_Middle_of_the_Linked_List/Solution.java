package com.leetcode.practice._876_Middle_of_the_Linked_List;

import java.util.ArrayDeque;
import java.util.Deque;

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


    public static ListNode middleNode(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();

        int counter = 0;
        while (head != null) {
            stack.push(head);
            head = head.next;
            counter++;
        }

        int max = counter;

        ListNode res = null;
        while (counter > max / 2) {
            res = stack.pop();
            counter--;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);
        ListNode temp = node;
        for (int i = 0; i < 4; i++) {
            temp.next = new ListNode(i + 2);
            temp = temp.next;
        }

        System.out.println(middleNode(node));

//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }




    }
}
