package com.hyq.day13;

/**
 * @ClassName FirstCommonNodeOfTwoLinkList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 13:15
 * @Version
 **/
public class FirstCommonNodeOfTwoLinkList {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int count1 = 0;
        int count2 = 0;
        ListNode nodeOne = headA;
        ListNode nodeTwo = headB;

        while (true) {

//问题 if-else逻辑，理清楚实现流程
//理解题意——数据结构形式

            if (nodeOne.next == null && count1 == 0) {
                nodeOne = headB;
                count1 = 1;
            } else
                nodeOne = nodeOne.next;

            if (nodeTwo.next == null && count2 == 0) {
                nodeTwo = headA;
                count2 = 1;
            } else
                nodeTwo = nodeTwo.next;

            if ((count1==count2&&count1 ==1)&&(nodeOne == nodeTwo))
                break;

//            if ((nodeOne == null && nodeTwo == null) || (nodeOne == nodeTwo))
//                break;
//            if (count1 == 0) {        //第一轮
//                if (nodeOne.next != null)
//                    nodeOne = nodeOne.next;
//                else {
//                    count1 = 1;
//                    nodeOne = headB;
//                }
//            } else if (count1 == 1)            //第二轮
//                nodeOne = nodeOne.next;


//            if (count2 == 0) {          //第一轮
//                if (nodeTwo.next != null)
//                    nodeTwo = nodeTwo.next;
//                else {
//                    count2 = 1;
//                    nodeTwo = headA;
//                }
//            } else if (count2 == 1)            //第二轮
//                nodeTwo = nodeTwo.next;

        }

        return nodeOne;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        ListNode currentNode1 = test1;
        for (int i = 3; i <= 21; ) {
            currentNode1.next = new ListNode(i);
            currentNode1 = currentNode1.next;
            i += 2;
        }
        ListNode test2 = new ListNode(2);

        currentNode1 = getIntersectionNode(test1, test2);
        System.out.println(currentNode1.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
