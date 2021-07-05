package com.hyq.leetcode.LinkList.question1;

/**
 * @ClassName ReversePartOfLinkList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/29 22:18
 * @Version
 **/
public class ReversePartOfLinkList {

    //出现问题：思路乱，没有搞清楚反转过程就开始写，
    //         边界情况考虑得不够细致，当low为1的情况没分析清楚
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return head;
        if (left == right)            //不需要反转
            return head;

        ListNode low = new ListNode(-1, head);               //指针标记
        ListNode finalNode = low;
        ListNode high = low;

        int count = 0;
        while (count < (right - left)) {                   //链表是否足够长
            if (high.next == null)
                break;
            high = high.next;
            count += 1;
        }
        if (count < (right - left))
            return head;

        count = 0;
        ListNode pre = new ListNode(-2, low);
        while (count < left) {                                 //链表是否足够长
            if (high.next == null)
                break;
            pre = pre.next;
            low = low.next;
            high = high.next;
            count += 1;
        }
        if (count < left)
            return head;

        ListNode currentNode = low.next;               //标记要改变的节点
        low.next = high.next;


        if(left==(right-1)){                            //相差1只需要改变一次
            high.next = low;
            pre.next = high;
            return finalNode.next;
        }

        ListNode next = currentNode.next;                 //递归反转
        while (next != high) {
            currentNode.next = low;
            low = currentNode;
            currentNode = next;
            next = currentNode.next;           //顺序会影响边界操作
        }
        currentNode.next = low;                       //最后两个节点的反转
        low = currentNode;
        high.next = currentNode;

        pre.next = high;

        return finalNode.next;
    }

    //重构
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null||left<=0||right<=0)
            return head;

        ListNode lastInOrder = new ListNode(-1,head);           //标记连接到反转后链表的节点
        ListNode firstHead = lastInOrder;             //虚拟头节点，用于返回值的查找

        ListNode low = head;           //查找要反转的位置
        ListNode high = head;
        right-=1;
        while(right>0||high!=null){
            high = high.next;
            right-=1;
        }
        if(high==null)
            return head;
        left-=1;
        while(left>0){
            lastInOrder = low;
            low = low.next;
            left-=1;
        }

        ListNode pre = high.next;                  //本次反转相当于反转前n-m个节点
        high.next = null;
        while(low!=null){
            ListNode next = low.next;
            low.next = pre;
            pre = low;
            low = next;
        }

        lastInOrder.next = pre;                        //考虑前面有一段未进行反转

        return firstHead.next;


    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode currentNode = head;
        for(int k =2;k<=5;k++){
            currentNode.next = new ListNode(k);
            currentNode = currentNode.next;
        }

        reverseBetween(head,2,4);
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