package com.hyqTestForWork.Janu.Day18.Q4;

/**
 * @ClassName KthNodeInList
 * @Description TODO 剑指22 链表中倒数第K个节点 频度 easy
 * @Author huangyq
 * @Date 2022/1/18 21:41
 * @Version
 **/
public class KthNodeInList {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next=head;

        ListNode fast = pre;
        ListNode slow = pre;
        int count=k-1;

        while(fast!=null){
            if(k<=0){
                slow=slow.next;
            }
            fast=fast.next;
            k--;
        }

        if(slow!=pre){
            return slow;
        }else{
            return null;
        }

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
