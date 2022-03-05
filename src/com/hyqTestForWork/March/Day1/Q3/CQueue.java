package com.hyqTestForWork.March.Day1.Q3;

import java.util.Stack;

/**
 * @ClassName stackImplementQueue
 * @Description TODO
 * @Author huangyq
 * @Date 2022/3/1 19:45
 * @Version
 **/
public class CQueue {
    private Stack<Integer> stack1 = null;
    private Stack<Integer> stack2 = null;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {

        if (stack2.isEmpty() && stack1.isEmpty()) {
            return -1;
        }else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }


    }
}
