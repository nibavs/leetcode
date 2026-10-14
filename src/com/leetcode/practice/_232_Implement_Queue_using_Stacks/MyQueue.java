package com.leetcode.practice._232_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    Deque<Integer> stackMain;
    Deque<Integer> stackHelper;

    public MyQueue() {
        stackMain = new ArrayDeque<>();
        stackHelper = new ArrayDeque<>();
    }

    public void push(int x) {
        stackHelper.push(x);
    }

    public int pop() {
        peek();
        return stackMain.pop();
    }

    public int peek() {
        if (stackMain.isEmpty()) {
            while(!stackHelper.isEmpty()) {
                stackMain.push(stackHelper.pop());
            }
        }
        return stackMain.peek();
    }

    public boolean empty() {
        return stackMain.isEmpty() && stackHelper.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
