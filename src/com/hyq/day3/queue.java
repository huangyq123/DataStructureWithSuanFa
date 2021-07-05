package com.hyq.day3;

import org.w3c.dom.Node;

import java.util.Stack;

/**
 * @ClassName queue
 * @Description TODO   使用双栈实现队列的增删
 * @Author huangyq
 * @Date 2021/2/26 11:28
 * @Version
 **/
public class queue {
    private Stack<queueNode> stack1;
    private Stack<queueNode> stack2;

    public queue(){
          this.stack1=new Stack<>();
          this.stack2= new Stack<>();
    }

/**
 *@Author huangyq
 *@Description TODO    问题：每次删元素要进行所有元素的出栈入栈操作两次，时间复杂度O（2n),空间复杂度O（2n）
 *@Date 2021/2/26 13:36
 *@Param [n]
 *@return void
 *@Version
 **/
    public void appendTail(queueNode n){
        stack1.push(n);
    }

    public int delete(){
        if(stack1.empty()){
            return -1;
        }

        while(!stack1.empty()){
            queueNode q = (queueNode) stack1.pop();
            stack2.push(q);
        }
        queueNode result = (queueNode) stack2.pop();
        while(!stack2.empty()){
            queueNode q = (queueNode) stack2.pop();
            stack1.push(q);
        }
        return result.Value;
    }

    public static void main(String[] args) {
        queue q = new queue();
        System.out.println( q.delete());
        q.appendTail(new queueNode(5));
        q.appendTail(new queueNode(2));
        System.out.println(q.delete());
        System.out.println(q.delete());
    }


/**
 *@Author huangyq
 *@Description TODO   书本样例   原理：栈1用来存储添加元素，栈2用于维护需要删除地元素，每次删除先删除栈2的元素，
 *                             无元素再将栈1的元素放到栈2中进行删除。
 *@Date 2021/2/26 13:35
 *@Param [node]
 *@return void
 *@Version
 **/
    // 入栈，时间复杂度： O(1) ，空间复杂度： O(n)
    public void push(queueNode node) {
        stack1.push(node);
    }
    // 出栈，时间（摊还）复杂度： O(1) ，空间复杂度： O(1)
    public queueNode pop() throws Exception {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("栈为空！");
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
