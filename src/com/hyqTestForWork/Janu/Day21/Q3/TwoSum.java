package com.hyqTestForWork.Janu.Day21.Q3;

/**
 * @ClassName TwoSum
 * @Description TODO  2  两数相加  频度 medium
 * @Author huangyq
 * @Date 2022/1/21 19:38
 * @Version
 **/
public class TwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(-1);
        ListNode current = pre;
        int c = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                while (l2 != null) {
                    int temp = (c + l2.val) % 10;
                    c = (c + l2.val) / 10;
                    current.next = new ListNode(temp);
                    current = current.next;
                    l2 = l2.next;
                }
            } else if (l2 == null) {
                while (l1 != null) {
                    int temp = (c + l1.val) % 10;
                    c = (c + l1.val) / 10;
                    current.next = new ListNode(temp);
                    current = current.next;
                    l1 = l1.next;
                }
            } else {
                int temp = (c + l1.val+l2.val) % 10;
                c = (c + l1.val+l2.val) / 10;
                current.next = new ListNode(temp);
                current = current.next;
                l2 = l2.next;
                l1 = l1.next;
            }
        }

        if(c!=0){
            current.next = new ListNode(c);
            current = current.next;
        }

        return pre.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
