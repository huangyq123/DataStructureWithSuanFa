package com.hyqTestForWork.Janu.Day13.Q5;

import java.util.Stack;

/**
 * @ClassName StackToQueue
 * @Description TODO 232  栈实现队列  easy
 * @Author huangyq
 * @Date 2022/1/13 21:13
 * @Version
 **/
public class StackToQueue {
    //基本版本——时间复杂度偏高
    private Stack<Integer> mainStack;
    private Stack<Integer> assistStack;

    public StackToQueue() {
        mainStack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        while(!mainStack.isEmpty()){
            assistStack.push(mainStack.pop());
        }
        Integer result = assistStack.pop();
        while(!assistStack.isEmpty()){
            mainStack.push(assistStack.pop());
        }
        return result;
    }

    public int peek() {
        while(!mainStack.isEmpty()){
            assistStack.push(mainStack.pop());
        }
        Integer result = assistStack.peek();
        while(!assistStack.isEmpty()){
            mainStack.push(assistStack.pop());
        }
        return result;
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}
