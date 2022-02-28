package com.hyqTestForWork.Janu.Day19.Q3;

/**
 * @ClassName ReverseListTwo
 * @Description TODO 92  反转链表2  频度  medium
 * @Author huangyq
 * @Date 2022/1/19 19:59
 * @Version
 **/
public class ReverseListTwo {
    //代码稍显混乱，需要优化  1.20
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode pre = new ListNode();
        pre.next=head;

        ListNode rightPoint = pre;
        ListNode leftPoint = pre;
        ListNode preLeft = new ListNode();
        preLeft.next = leftPoint;

        while(right>0){
            rightPoint = rightPoint.next;
            if(right-left<=0){
                leftPoint=leftPoint.next;
                preLeft = preLeft.next ;
            }
            right--;
        }

        ListNode nextRight = rightPoint.next;
        preLeft.next=null;
        rightPoint.next=null;
        ListNode currentNode = null;
        ListNode tail = leftPoint;
        while(leftPoint!=null){
            ListNode temp = leftPoint.next;
            leftPoint.next = currentNode;
            currentNode = leftPoint;
            leftPoint = temp;
        }

        preLeft.next = currentNode;
        tail.next = nextRight;


        return pre.next;
    }

    // 一次遍历  1.20
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
