package com.leetcode.practice._155_Min_Stack;

import java.util.*;

class MinStack {
    List<int[]> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int value) {
        int[] top = stack.isEmpty() ? new int[] {value, value} : stack.get(stack.size() - 1);
        int minVal = top[1];
        if (minVal > value) {
            minVal = value;
        }
        stack.add(new int[] {value, minVal});
        System.out.println(value + " " + minVal);
    }

    public void pop() {
        if (!stack.isEmpty()) stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1)[0];
    }

    public int getMin() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1)[1];
    }

    public static void main(String[] args) {
        var obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
//        System.out.println(obj.getMin());
        obj.pop();
//        System.out.println(obj.getMin());
        obj.pop();
//        System.out.println(obj.getMin());
        obj.pop();
        obj.push(-2);
        obj.push(-1);
        obj.push(-2);
//        System.out.println(obj.getMin());
        obj.pop();
//        System.out.println(obj.top());
//        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
