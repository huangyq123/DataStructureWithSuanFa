package com.hyq.day6;

/**
 * @ClassName deleteKthNodeInList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/3 14:37
 * @Version
 **/
public class deleteKthNodeInList {


    //两次遍历，一次计数，一次寻找，效率不高
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        int count = 1;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            count += 1;
            currentNode = currentNode.next;
        }

        if (count < k)
            return null;
        else if (count == k)
            return head;

        currentNode = head;
        while (count != k) {
            currentNode = currentNode.next;
            count--;
        }

        return currentNode;
    }


    //改进版本——快慢指针
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        ListNode pointLow = head;
        ListNode pointFast = head;
        int count = 1;
        while (pointFast.next != null) {
//            if(count<k){
//                pointFast = pointFast.next;
//                count++;
//            }
//            else{
//                pointFast = pointFast.next;
//                pointLow = pointLow.next;
//                count++;
//            }

            //简化写法
            if (count >= k) pointLow = pointLow.next;
            pointFast = pointFast.next;
            count++;

        }

        if (count < k)
            return null;
        else
            return pointLow;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
