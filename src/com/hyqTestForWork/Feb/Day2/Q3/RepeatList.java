package com.hyqTestForWork.Feb.Day2.Q3;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName RepeatList
 * @Description TODO  234. 回文链表  频度 easy
 * @Author huangyq
 * @Date 2022/2/2 20:39
 * @Version
 **/
public class RepeatList {
    //思路——找到中间节点，使用栈存储后半部分，然后从头开始比较前半部分和栈存储的后半部分
    // bug—— 注意链表节点的变化有没有写
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode pre = new ListNode();
        pre.next=head;
        ListNode slow = pre;
        ListNode fast = pre;

        while(fast!=null){
            if(fast.next!=null){
                fast = fast.next.next;
            }else{
                break;
            }
            slow = slow.next;
        }

        Stack<Integer> memory = new Stack<>();
        fast = slow.next;
        while(fast!=null){
            memory.push(fast.val);
            fast = fast.next;
        }

        fast = head;
        while(fast!=slow){
            Integer pop = memory.pop();
            if(pop!=fast.val){
                return false;
            }
            //这一步忘了出了bug
            fast = fast.next;
        }
        if(!memory.isEmpty()&&(fast.val!=memory.pop())){
            return false;
        }

        return true;
    }

    @Test
    public void Test(){
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(2);
        test.next.next.next = new ListNode(1);
        isPalindrome(test);
    }

    //TODO 快慢指针+反转链表   减小空间复杂度
    public boolean isPalindrome2(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode pre = new ListNode();
        pre.next=head;
        //反转链表核心：以及反转好的链表的头节点，下一个需要反转的节点 —— slow next
        ListNode slow = null;
        ListNode fast = pre;
        ListNode next = head;

        boolean flagIsOdd = true;
        while(fast!=null){
            if(fast.next!=null){
                fast = fast.next.next;
            }else{
                flagIsOdd = false;
                break;
            }

            ListNode temp = next.next;
            next.next = slow;
            slow = next;
            next = temp;
        }

        if(flagIsOdd){
            slow = slow.next;
        }

        while(slow!=null){
            if(slow.val!=next.val){
                return false;
            }
            slow = slow.next;
            next = next.next;
        }

        return true;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
