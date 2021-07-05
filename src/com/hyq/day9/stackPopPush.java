package com.hyq.day9;

import java.util.Stack;

/**
 * @ClassName stackPopPush
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/7 9:47
 * @Version
 **/
public class stackPopPush {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null)
            return false;

        if (pushed.length != popped.length)
            return false;

        Stack<Integer> stk = new Stack<>();
        int[] comparable = new int[pushed.length];
        int count = 0;

        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[count]) {
                comparable[count++] = pushed[i];
                while (!stk.isEmpty()) {
                    if (popped[count] != stk.peek())
                        break;
                    comparable[count++] = stk.pop();
                }
            } else
                stk.push(pushed[i]);

        }
        //可以优化

//        for (int i = 0; i < pushed.length; i++) {
//            stk.push(pushed[i]);
//                while (!stk.isEmpty()) {
//                    if (popped[count] != stk.peek())
//                        break;
//                    comparable[count++] = stk.pop();
//                }
//        }

        while (!stk.isEmpty()) {
            comparable[count++] = stk.pop();
        }

        boolean flag = true;
        for (int i = 0; i < popped.length; i++) {
            if (popped[i] != comparable[i]) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed == null || popped == null)
            return false;

        if (pushed.length != popped.length)
            return false;

        Stack<Integer> stk = new Stack<>();
        //int[] comparable = new int[pushed.length];
        int count = 0;


        for (int i = 0; i < pushed.length; i++) {
            stk.push(pushed[i]);
            while (!stk.isEmpty()) {
                if (popped[count] != stk.peek())
                    break;
                stk.pop();
                count++;
            }
        }

//        while (!stk.isEmpty()) {
//            if (popped[count] != stk.peek())
//                break;
//            stk.pop();
//            count++;
//        }

//多余
        return stk.isEmpty();
    }
}
