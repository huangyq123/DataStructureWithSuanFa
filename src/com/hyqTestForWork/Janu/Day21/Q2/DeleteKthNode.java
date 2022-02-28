package com.hyqTestForWork.Janu.Day21.Q2;

/**
 * @ClassName DeleteKthNode
 * @Description TODO 19 删除链表的倒数第K个节点 频度 medium
 * @Author huangyq
 * @Date 2022/1/21 19:30
 * @Version
 **/
public class DeleteKthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n<=0){
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next=head;

        int length = n;
        ListNode fast = pre;
        ListNode slow = pre;
        while(fast!=null){
            fast = fast.next;
            if(length<0){
                slow = slow.next;
            }
            length--;
        }
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;
        return pre.next;
    }

    //TODO  1.22 栈实现

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
