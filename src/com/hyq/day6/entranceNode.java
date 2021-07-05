package com.hyq.day6;

/**
 * @ClassName entranceNode
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/3 15:14
 * @Version
 **/
public class entranceNode {

    public static ListNode findLoop(ListNode head) {
//设置快慢指针
        ListNode pointLow = head;
        ListNode pointFast = head;

        while (pointLow == pointFast&&pointFast.next != null) {//如果存在环，则两指针会指向同一节点，同时有环会保证下一节点一定存在

            pointFast = pointFast.next;//快指针先走第一步

            if (pointFast.next == null)//若果没有环，快指针不能保证走第二步
                break;

            pointFast = pointFast;      //快指针走第二步
            pointLow = pointLow.next;   //慢指针走一步
        }

        if (pointFast.next == null)    //无环则最后结束时快指针指向末尾节点
            return null;

        return pointLow;    //有环则慢指针指向的是环中节点
    }


    public static int CountNumber(ListNode start) {

        int count = 1;
        ListNode current = start;   //环中节点
        while (current.next != start) {   //使用指针在环中行走直到走完一圈
            current = current.next;
            count++;              //统计环长度
        }
        return count;
    }

    public static ListNode findEntrance(ListNode head) {
        if (head == null)   //边界处理
            return null;

        ListNode result = null;

        ListNode positionInLoop = findLoop(head);     //确定是否有环
        if (positionInLoop != null) {      //有环
            int length = CountNumber(positionInLoop);    //得到环长度 length
            ListNode pointLow = head;
            ListNode pointFast = head;
            for (int i = 0; i < length; i++)      //快指针先走length步
                pointFast = pointFast.next;

            while(pointFast!=pointLow){     //快慢指针第一次相遇点为入口
                pointFast = pointFast.next;
                pointLow = pointLow.next;
            }
            result = pointLow;
        }
        return result;
    }
}
