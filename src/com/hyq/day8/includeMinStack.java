package com.hyq.day8;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName includeMinStack
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/5 11:20
 * @Version
 **/
public class includeMinStack {
}


class MinStack {
    private Stack<Integer> stackMemory;
    private Stack<Integer> stackAssist;
    private Integer min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackMemory = new Stack<>();
        stackAssist = new Stack<>();
    }

    public void push(int x) {
        stackMemory.push(x);
        if(stackAssist.empty()){
            stackAssist.push(x);
            min = x;
        }else{
            if(x<=min){
                stackAssist.push(x);
                min = x;
            }
        }
    }

    public void pop() {
        Integer temp = stackMemory.pop();
        if(temp.equals(min)){
            stackAssist.pop();
            if(!stackAssist.empty()){
                min = stackAssist.pop();
                stackAssist.push(min);
            }else{
                min = 0x80000000;
            }
        }
    }

    public int top() {
        Integer result = stackMemory.pop();
        stackMemory.push(result);
        return result;
    }

    public int min() {
        Integer result = stackAssist.pop();
        stackAssist.push(result);
        return result;
    }
}