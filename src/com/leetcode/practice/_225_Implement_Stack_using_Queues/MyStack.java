package com.leetcode.practice._225_Implement_Stack_using_Queues;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
    Queue<Integer> queueHelper;
    Queue<Integer> queueMain;


    public MyStack() {
        queueHelper = new ArrayDeque<>();
        queueMain = new ArrayDeque<>();
    }

    public void push(int x) {
        if (!queueHelper.isEmpty()) {

            queueMain.offer(queueHelper.poll());
        }
        queueHelper.offer(x);
    }

    public int pop() {
        top();
        return queueHelper.poll();
    }

    public int top() {
        if (queueHelper.isEmpty() && queueMain.isEmpty()) {
            throw new RuntimeException();
        } else if (queueHelper.isEmpty()){
            while(!queueMain.isEmpty()) {
                queueHelper.offer(queueMain.poll());
            }
            while(queueHelper.size() > 1) {
                queueMain.offer(queueHelper.poll());
            }
        }
        return queueHelper.peek();
    }

    public boolean empty() {
        return queueHelper.isEmpty() && queueMain.isEmpty();
    }
}
