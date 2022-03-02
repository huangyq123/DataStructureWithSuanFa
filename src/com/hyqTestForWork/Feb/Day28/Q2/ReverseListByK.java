package com.hyqTestForWork.Feb.Day28.Q2;

import org.junit.Test;

/**
 *@Author admin
 *@Description TODO  25. K 个一组翻转链表  hard
 *@Date 2022/2/28 21:27
 *@Param
 *@return
 *@Version
 **/
public class ReverseListByK {
    //思路——每次取K个节点进行翻转，不足k个则直接连接；   使用虚拟头节点进行简化操作
    //细节：搞清楚每个节点含义，以及停止循环的条件，；
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode pre = new ListNode(-1);
        ListNode current = pre;
        while(head!=null){
            int temp = k-1;
            ListNode tempHead = head;
            while(temp>0&&tempHead.next!=null){
                tempHead = tempHead.next;
                temp--;
            }

            if(temp>0){
                current.next = head;
                break;
            }else{
                ListNode nextHead = tempHead.next;
                tempHead.next = null;
                ReverseList(head);
                current.next = tempHead;
                current = head;
                //剩余链表的头节点
                head = nextHead;
            }
        }

        return pre.next;
    }

    public void ReverseList(ListNode head){

        if(head==null){
            return ;
        }

        ListNode pre = null;
        //当head为null，则说明反转完毕
        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            //剩余链表的节点头
            head = temp;
        }
    }

    @Test
    public void Test(){
        ListNode test = new ListNode(1);
        ListNode current = test;
        for(int i=2;i<6;i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        reverseKGroup(test,2);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
