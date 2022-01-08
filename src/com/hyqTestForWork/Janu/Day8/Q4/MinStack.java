package com.hyqTestForWork.Janu.Day8.Q4;

import java.util.Stack;

/**
 * @ClassName MINStack
 * @Description TODO  155 最小栈 hot100 easy
 * @Author huangyq
 * @Date 2022/1/8 21:20
 * @Version
 **/
public class MinStack {
//    private Stack<Integer> memory;
//    private Stack<Integer> minStack;
////    private int min=Integer.MAX_VALUE;
//    //没考虑出来结构——看题解得到结果
//    public MinStack() {
//        memory=new Stack<>();
//        minStack=new Stack<>();
//    }
//
//    public void push(int val) {
//        memory.push(val);
////        if(val<min){
////            min=val;
////        }
////        minStack.push(min);
//        if(!minStack.isEmpty()) {
//            int temp = minStack.peek();
//            if(temp>val) {
//                minStack.push(val);
//            }else{
//                minStack.push(temp);
//            }
//        }else{
//            minStack.push(val);
//        }
//    }
//
//    public void pop() {
//        memory.pop();
//        minStack.pop();
//    }
//
//    public int top() {
//        Integer peek = memory.peek();
//        return peek;
//    }
//
//    public int getMin() {
//        Integer peek = minStack.peek();
//        return peek;
//    }

    //无辅助栈实现：辅助变量+差值栈
    //做差值要考虑到边界的越界问题，使用long型处理（这里写了double）
    private Stack<Double> memory;
    private double min;

    public MinStack() {
        memory=new Stack<>();
    }

    public void push(int val) {
        if(memory.isEmpty()){
            memory.push((double)0);
            min=val;
            return ;
        }

        memory.push((double)val-min);
        if(val<min) {
            min = val;
        }
    }

    public void pop() {
        double temp = memory.pop();
        if(temp<=0){
            min=min-temp;
        }
    }

    public int top() {
        double peek = memory.peek();
        if(peek>0){
            return (int)(min+peek);
        }else{
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }


}
