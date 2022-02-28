package com.hyqTestForWork.Janu.Day11.Q1;

import org.junit.Test;

/**
 * @ClassName ReverseList
 * @Description TODO 206 反转链表  频度排序 1
 * @Author huangyq
 * @Date 2022/1/11 20:35
 * @Version
 **/
public class ReverseList {
    //迭代+双指针
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;

        ListNode current = head;

        while(current!=null){
            ListNode temp = current.next;
            current.next=pre;
            pre=current;
            current=temp;
        }

        return pre;
    }

    //递归实现 -1.12  需要理解这个做法，以及适用场景
    //理解： 正常顺序处理，先反转一个节点，再反转剩下的，而剩下的看作是一条链表进行反转，因此可以考虑递归；   迭代必然可以递归
    public ListNode reverseList2(ListNode head){

        ListNode result = dfs(head);
        return result;
    }

    public ListNode dfs(ListNode head){
        if(head.next==null){
            return head;
        }

        ListNode returnValue = dfs(head.next);
        head.next.next=head;
        //注意——预先设置为null，否则最后反转结束尾指针会成环
        head.next=null;

        return returnValue;
    }

    @Test
    public void Test(){
        ListNode test = new ListNode(1);
        ListNode current = test;
        for(int i=2;i<6;i++) {
            current.next = new ListNode(i);
            current=current.next;
        }

        reverseList2(test);
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
