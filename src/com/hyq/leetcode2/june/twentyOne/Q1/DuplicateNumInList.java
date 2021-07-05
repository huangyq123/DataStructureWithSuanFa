package com.hyq.leetcode2.june.twentyOne.Q1;

/**
 * @ClassName DuplicateNumInList
 * @Description TODO  删除排序链表中的重复元素 83
 * @Author huangyq
 * @Date 2021/6/21 18:36
 * @Version
 **/
public class DuplicateNumInList {

    public static ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return head;
        }

        ListNode current = head;

        while(current.next!=null){
            if(current.val== current.next.val){
                ListNode temp = current.next;
                current.next=temp.next;
                temp.next=null;
            }else{
                current=current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(1);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(3);
        listNode.next.next.next.next=new ListNode(3);
        deleteDuplicates(listNode);
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
