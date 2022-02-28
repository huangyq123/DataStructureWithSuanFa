package com.hyqTestForWork.Janu.Day21.Q4;

/**
 * @ClassName SortList
 * @Description TODO 148 排序链表 频度 medium
 * @Author huangyq
 * @Date 2022/1/21 19:47
 * @Version
 **/
public class SortList {
    //自顶向下归并
    public ListNode sortList(ListNode head){


        return split(head);
    }

    public ListNode split(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode pre = new ListNode(-1,head);
        ListNode fast = pre;
        ListNode slow = pre;

        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next=null;
        ListNode temp = slow.next;
        slow.next=null;
        ListNode returnNode1 = split(head);
        ListNode returnNode2 = split(temp);

        ListNode result = merge(returnNode1, returnNode2);

        return result;
    }

    public ListNode merge(ListNode l1,ListNode l2){

        ListNode pre = new ListNode(-1);
        ListNode current = pre;

        while(l1!=null||l2!=null){
            if(l1==null){
                current.next = l2;
                ListNode result = pre.next;
                pre.next=null;
                return result;
            }else if(l2==null){
                current.next = l1;
                ListNode result = pre.next;
                pre.next=null;
                return result;
            }else{
                if(l1.val>l2.val){
                    current.next = l2;
                    l2 = l2.next;
                    current = current.next;
                    current.next=null;
                }else{
                    current.next = l1;
                    l1 = l1.next;
                    current = current.next;
                    current.next=null;
                }
            }
        }

        return null;
    }

    //TODO 1.22 自底向上归并
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
