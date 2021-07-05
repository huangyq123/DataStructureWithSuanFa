package com.hyq.day5;

/**
 * @ClassName LinkNodeDelete
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/2 14:07
 * @Version
 **/
public class LinkNodeDelete {


    //时间复杂度O(n)
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode currentNode = head;
        ListNode beDeletdNode = null;

        if (head.val == val) {
            beDeletdNode = head;
            head = beDeletdNode.next;
            beDeletdNode.next = null;
        }


        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                beDeletdNode = currentNode.next;
                currentNode.next = beDeletdNode.next;
                beDeletdNode.next = null;
            } else
                currentNode = currentNode.next;
        }
        return head;
    }

    //给定要删除节点的情况
    public static ListNode deleteNode2(ListNode head, ListNode beDeletedNode) {

        if (head == null || beDeletedNode == null)
            return head;

        if (beDeletedNode == head)
            return null;

        if (beDeletedNode.next == null) {
            ListNode currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next == beDeletedNode) {
                    currentNode.next = beDeletedNode.next;
                    beDeletedNode.next = null;
                }
            }
        }


        beDeletedNode.val = beDeletedNode.next.val;
        beDeletedNode.next = beDeletedNode.next.next;

        return head;
    }


    //删除重复节点(删除多余）
    public static ListNode DeleteCopyNode(ListNode head) {

        if (head == null || head.next == null)
            return head;


        ListNode pNodeOne = head;
        ListNode pNodeTwo = null;
        ListNode beDeleteNode = null;

        while (pNodeOne.next != null) {
            pNodeTwo = pNodeOne;
            while (pNodeTwo.next != null) {
                if (pNodeTwo.next.val == pNodeOne.val) {
                    beDeleteNode = pNodeTwo.next;
                    pNodeTwo.next = beDeleteNode.next;
                    beDeleteNode.next = null;
                }
                pNodeTwo = pNodeTwo.next;
            }
            if (pNodeOne.next != null)
                pNodeOne = pNodeOne.next;
        }

        return head;

    }

    //排序链表删除重复节点（所有重复）——不正确
    public static ListNode deleteCopy(ListNode head) {
        if (head == null || head.next == null)//只有一个节点
            return head;


        ListNode preNode = head;
        ListNode pNodeOne = head.next;
        ListNode pNodeTwo = head.next;
        ListNode bedeleteNode = null;

        if (preNode.val == pNodeOne.val) {//需要删除头节点
            if (pNodeOne.next == null) //只有两个节点且值相等
                return null;
            else {
                boolean flag = false;
                while (pNodeOne.next != null) {//往下寻找是否存在不重复的节点，找到或者链表查找结束未找到则结束循环
                    if (pNodeOne.next.val != preNode.val) {//存在
                        preNode = pNodeOne.next;
                        head = preNode;
                        pNodeOne = head.next;
                        flag = true;      //记录
                        break;
                    }
                    pNodeOne = pNodeOne.next;//未找到，继续寻找，直到找到或者后面无节点
                }
                if (!flag)
                    return null;                    //全都是重复节点
            }
        }
        //问题若果连续出现头节点重复？

        //只有一个节点
        if (pNodeOne == null) //
            return head;

        //
        while (pNodeOne.next != null) {
            if (pNodeOne.next.val == pNodeOne.val) {
                pNodeOne = pNodeOne.next;
            } else {
                pNodeTwo = pNodeOne.next;
                preNode.next = pNodeTwo;
                bedeleteNode = pNodeOne;
                bedeleteNode.next = null;
                pNodeOne = pNodeTwo;
            }
        }
        if (preNode.next != pNodeOne) {
            preNode.next = pNodeOne.next;
        }
        return head;

    }


    //排序链表删除重复节点（所有重复）
    public static ListNode deleteCopy2(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode preNode = first;
        ListNode currentNode = head;
        ListNode nextNode = null;

        while (currentNode != null && currentNode.next != null) {
            nextNode = currentNode.next;
            if(nextNode.val==currentNode.val){
                while (nextNode != null && nextNode.val == currentNode.val) {
                    nextNode = nextNode.next;
                }
                currentNode = nextNode;
                preNode.next = currentNode;
            }else{
                preNode = preNode.next;
                currentNode = nextNode;
            }
        }
        return first.next;
    }
}


class ListNode {
    public int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}