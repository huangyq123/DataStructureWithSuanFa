package com.hyqTestForWork.March.Day1.Q4;

import java.util.Stack;

/**
 * @ClassName StackPushPop
 * @Description TODO  剑指 Offer 31. 栈的压入、弹出序列  medium
 * @Author huangyq
 * @Date 2022/3/1 19:46
 * @Version
 **/
public class StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> memory = new Stack<>();
        int indexOfPushed = 0;
        int indexOfpopped = 0;
        while (indexOfPushed < pushed.length) {

            memory.push(pushed[indexOfPushed]);
            indexOfPushed++;

            while(!memory.isEmpty()&&memory.peek()==popped[indexOfpopped]){
                memory.pop();
                indexOfpopped++;
            }
        }

        return memory.isEmpty();
    }
}
