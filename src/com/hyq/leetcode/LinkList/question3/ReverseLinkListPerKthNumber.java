package com.hyq.leetcode.LinkList.question3;


/**
 * @ClassName ReverseLinkListPerKthNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/31 16:02
 * @Version
 **/
public class ReverseLinkListPerKthNumber {

    public static ListNode3 reverseKGroup(ListNode3 head, int k) {

        ListNode3 fast = head;
        ListNode3 newHead = new ListNode3(-1, head);
        ListNode3 pre = newHead;
        int count = 1;
        int flag = 0;
        while (fast != null) {
            fast = fast.next;
            count += 1;
            if (count != k)
                continue;

            ListNode3 tail = fast.next;
            ListNode3 currentNode = pre.next;
            ListNode3 temp = currentNode;
            pre.next = null;
            fast.next = null;
            ListNode3 t = tail;
            while (currentNode != null) {
                ListNode3 next = currentNode.next;
                currentNode.next = t;
                t = currentNode;
                currentNode = next;
            }
            pre.next = t;
            flag = 0;
            count = 1;
            pre = temp;
            fast = pre.next;

        }
        return newHead.next;
    }


    //头插法


    public static void main(String[] args) {
        ListNode3 head = new ListNode3(1, new ListNode3(2,new ListNode3(3, new ListNode3(4, new ListNode3(5)))));
        reverseKGroup(head, 2);
    }
}

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }
}