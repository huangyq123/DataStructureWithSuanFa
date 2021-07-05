package com.hyq.leetcode.question5;

import org.w3c.dom.Node;

/**
 * @ClassName KthNodeInList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/19 21:25
 * @Version
 **/
public class KthNodeInList {

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null)
            return null;

        ListNode currentNode = head;
        int count = 1;
        while(count<n+1&&currentNode!=null){
            currentNode = currentNode.next;
            count++;
        }

        if(currentNode==null&&count<n+1)
            return head;

        if(currentNode==null&&count==(n+1)){
            head = head.next;
            return head;
        }

        ListNode preNode = head;
        while(currentNode.next!=null){
            currentNode = currentNode.next;
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;

        ListNode currentNode = head;
        int count = 1;
        while(count<n&&currentNode!=null){
            currentNode = currentNode.next;
            count++;
        }

        if(currentNode==null)
            return head;

        if(currentNode.next==null){
            head = head.next;
            return head;
        }

        ListNode deleteNode = head.next;
        ListNode pre = head;
        currentNode = currentNode.next;
        while(currentNode.next!=null){
            currentNode = currentNode.next;
            deleteNode = deleteNode.next;
            pre = pre.next;
        }
        pre.next = deleteNode.next;

        return head;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }