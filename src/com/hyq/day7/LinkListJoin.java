package com.hyq.day7;

/**
 * @ClassName LinkListJoin
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/4 10:07
 * @Version
 **/
public class LinkListJoin {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists(l1, l2);
        System.out.println(1);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode currentNodeOne = l1;
        ListNode currentNodeTwo = l2;
        ListNode preNode = null;
        boolean flag = true;
        if (currentNodeTwo.val < currentNodeOne.val) {
            flag = false;
            preNode = currentNodeTwo;
            currentNodeTwo = currentNodeTwo.next;
        } else {
            preNode = currentNodeOne;
            currentNodeOne = currentNodeOne.next;
        }
        ListNode head = preNode;

        while (currentNodeOne != null || currentNodeTwo != null) {
            if (currentNodeOne == null) {
                if (flag) {
                    preNode.next = currentNodeTwo;
                    flag = false;
                }
                preNode = currentNodeTwo;
                currentNodeTwo = currentNodeTwo.next;
            } else if (currentNodeTwo == null) {
                if (!flag) {
                    preNode.next = currentNodeOne;
                    flag = true;
                }
                preNode = currentNodeOne;
                currentNodeOne = currentNodeOne.next;
            } else if (currentNodeOne.val >= currentNodeTwo.val) {
                if (flag) {
                    preNode.next = currentNodeTwo;
                    flag = false;
                }
                preNode = currentNodeTwo;
                currentNodeTwo = currentNodeTwo.next;

            } else if (currentNodeTwo.val >= currentNodeOne.val) {
                if (!flag) {
                    preNode.next = currentNodeOne;
                    flag = true;
                }
                preNode = currentNodeOne;
                currentNodeOne = currentNodeOne.next;
            }
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}