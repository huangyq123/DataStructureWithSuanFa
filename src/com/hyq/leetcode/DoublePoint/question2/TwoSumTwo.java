package com.hyq.leetcode.DoublePoint.question2;

/**
 * @ClassName TwoSumTwo
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/1 14:38
 * @Version
 **/
public class TwoSumTwo {

    //反转链表再求和
    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode1 head1 = Reverse(l1);                 //反转加数链表
        ListNode1 head2 = Reverse(l2);

        ListNode1 currentNode1 = head1;                //查找节点
        ListNode1 currentNode2 = head2;
        int extra = 0;
        ListNode1 newHead = new ListNode1(-1);          //新链表虚拟头节点，避免头节点的特殊处理；
        ListNode1 currentNewNode = newHead;                //新链表结点指针
        while (currentNode1 != null || currentNode2 != null) {
            int temp = 0;                                      //计算并建立节点
            if (currentNode1 == null) {
                temp = (currentNode2.val + extra) % 10;
                extra = (currentNode2.val + extra) / 10;
                currentNewNode.next = new ListNode1(temp);
                currentNode2 = currentNode2.next;
            } else if (currentNode2 == null) {
                temp = (currentNode1.val + extra) % 10;
                extra = (currentNode1.val + extra) / 10;
                currentNewNode.next = new ListNode1(temp);
                currentNode1 = currentNode1.next;
            } else {
                temp = (currentNode1.val + currentNode2.val + extra) % 10;
                extra = (currentNode1.val + currentNode2.val + extra) / 10;
                currentNode1 = currentNode1.next;
                currentNode2 = currentNode2.next;
            }
            currentNewNode.next = new ListNode1(temp);                  //继续查找下一个
            currentNewNode = currentNewNode.next;
        }
        if (extra != 0)
            currentNewNode.next = new ListNode1(extra);                  //最后的进位另作考虑

        ListNode1 result = Reverse(newHead.next);                       //反转得到结果
        newHead.next = null;

        Reverse(head1);                                           //还原链表
        Reverse(head2);

        return result;
    }

    public static ListNode1 Reverse(ListNode1 head) {
        ListNode1 pre = null;
        ListNode1 currentNode = head;
        while (currentNode != null) {
            ListNode1 next = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = next;
        }
        return pre;
    }



    public static void main(String[] args) {
        ListNode1 l1 = new ListNode1(7,new ListNode1(2,new ListNode1(4,new ListNode1(3))));
        ListNode1 l2 = new ListNode1(5,new ListNode1(6, new ListNode1(4)));
        addTwoNumbers(l1,l2);
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
    }
    ListNode1(int x, ListNode1 nextNode){
        val = x;
        next = nextNode;
    }
}