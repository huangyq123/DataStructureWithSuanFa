package com.hyq.leetcode.LinkList.question2;



/**
 * @ClassName ReverseLinkList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/30 17:41
 * @Version
 **/
public class ReverseLinkList {

    public ListNode2 reverseList(ListNode2 head) {
        if(head==null)
            return head;

        ListNode2 currentNode =  head;
        ListNode2 pre = null;
        while(currentNode!=null){
            ListNode2 next = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = next;
        }

        return pre;
    }

    //递归法
    public static ListNode2 reverseList2(ListNode2 head) {
        if(head==null)
            return head;

        return Recur(null,head);

    }

    public static ListNode2 Recur(ListNode2 pre,ListNode2 root){
        if(root==null)
            return pre;

        ListNode2 next = root.next;
        root.next = pre;

        return Recur(root,next);
    }
}
class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}