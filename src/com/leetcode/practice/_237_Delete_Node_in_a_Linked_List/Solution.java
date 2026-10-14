package com.leetcode.practice._237_Delete_Node_in_a_Linked_List;

import com.leetcode.practice.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;

        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
