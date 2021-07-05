package com.hyq.day6;

import java.util.ArrayList;

/**
 * @ClassName ReverseList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/3 17:02
 * @Version
 **/
public class ReverseList {

    public static void main(String[] args) {

    }

    public static ListNode2 reverseList(ListNode2 head){
        if(head == null)
            return null;

        ArrayList<Integer> assist = new ArrayList<>();
        ListNode2 currentNode = head;
        while(currentNode!=null){
            assist.add(currentNode.val);
            currentNode = currentNode.next;
        }

        currentNode = head;
        for(int i = assist.size()-1;i>=0;i++){
            currentNode.val = assist.get(i);
            currentNode = currentNode.next;
        }
        return head;
    }

    //双指针实现
    public static ListNode2 reverseList2(ListNode2 head){
        if(head == null)
            return null;

        ListNode2 currentNode = head;
        ListNode2 completeHead = null;
        ListNode2 temp = currentNode.next;

        while(currentNode.next!=null){
            currentNode.next = completeHead;
            completeHead = currentNode;
            currentNode = temp;
            temp = currentNode.next;
        }
        currentNode.next = completeHead;
        return currentNode;
    }

    //递归实现
    public static ListNode2 reverseList3(ListNode2 head){
        if(head == null)
            return null;

        return     Reverse(head,null);
    }

    public static ListNode2 Reverse(ListNode2 head, ListNode2 newHead){
        ListNode2 temp = head.next;
        head.next = newHead;
        newHead = head;
        head = temp;
        if(head!=null)
            newHead = Reverse(head,newHead);

        return newHead;
    }

}


 class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2(int x) { val = x; }
  }