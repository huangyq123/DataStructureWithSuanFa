package com.hyqTestForWork.Feb.Day6.Q5_7;

/**
 * @ClassName ChangeNodeInListByTwo
 * @Description TODO  24. 两两交换链表中的节点  频度 medium
 * @Author huangyq
 * @Date 2022/2/6 18:09
 * @Version
 **/
public class ChangeNodeInListByTwo {
    public ListNode swapPairs(ListNode head) {

        ListNode pre = new ListNode(-1,head);
        ListNode current = pre;
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null){
            ListNode temp = fast.next;
            current.next = fast;
            fast.next = slow;
            slow.next = temp;

            current = slow;
            slow = slow.next;
            if(slow==null){
                break;
            }else{
                fast = slow.next;
            }
        }

        return pre.next;
    }

    //TODO  递归 2.7
    public ListNode swapPairs2(ListNode head){

        ListNode result = dfs(head);

        return result;
    }

    public ListNode dfs(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode temp = head.next;
        ListNode current = head.next.next;
        head.next.next = null;

        temp.next = head;
        head.next = dfs(current);

        return temp;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }