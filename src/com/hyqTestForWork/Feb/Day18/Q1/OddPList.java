package com.hyqTestForWork.Feb.Day18.Q1;

/**
 * @ClassName OddPList
 * @Description TODO  328. 奇偶链表  频度 medium
 * @Author huangyq
 * @Date 2022/2/18 19:57
 * @Version
 **/
public class OddPList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode odd = head;
        ListNode par = head.next;
        ListNode prev = new ListNode(-1,head);
        ListNode pPrev = par;
        while(par!=null&&par.next!=null){
            odd.next = par.next;
            odd = odd.next;
            par.next = odd.next;
            par = par.next;
        }

        odd.next = pPrev;

        return prev.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
