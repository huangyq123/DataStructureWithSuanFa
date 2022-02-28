package com.hyqTestForWork.Feb.Day18.Q3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName QueuetoStack
 * @Description TODO 225. 用队列实现栈 频度 easy
 * @Author huangyq
 * @Date 2022/2/18 20:42
 * @Version
 **/
//public class MyStack {
//    //细节：注意empty的结果和调用的isempty的关系——  理清楚细节
//    private Queue<Integer> queue1;
//    private Queue<Integer> queue2;
//    private int n = 0;
//    public MyStack() {
//        queue1 = new LinkedList<>();
//        queue2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        if(n==0){
//            queue1.add(x);
//        }else{
//            queue2.add(x);
//        }
//    }
//
//    public int pop() {
//        if(n==0){
//            while(queue1.size()>1){
//                Integer poll = queue1.poll();
//                queue2.add(poll);
//            }
//            Integer result = queue1.poll();
//            n=(n+1)%2;
//            return result;
//        }else{
//            while(queue2.size()>1){
//                Integer poll = queue2.poll();
//                queue1.add(poll);
//            }
//            Integer result = queue2.poll();
//            n=(n+1)%2;
//            return result;
//        }
//    }
//
//    public int top() {
//        if(n==0) {
//            int pop = pop();
//            queue2.add(pop);
//            return pop;
//        }else {
//            int pop = pop();
//            queue1.add(pop);
//            return pop;
//        }
//    }
//
//    public boolean empty() {
//        return queue1.isEmpty()||queue2.isEmpty();
//    }
//
//    public static void main(String[] args) {
//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        int top = myStack.top();
//        int pop = myStack.pop();
//        boolean empty = myStack.empty();
//        System.out.println(1);
//    }
//}

//TODO  单队列实现
public class MyStack {
    private Queue<Integer> queue1;
    private int n = 0;
    public MyStack() {
        queue1 = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue1.size();
        queue1.add(x);
        while(size>0){
            Integer poll = queue1.poll();
            queue1.add(poll);
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();
        int pop = myStack.pop();
        boolean empty = myStack.empty();
        System.out.println(1);
    }
}
