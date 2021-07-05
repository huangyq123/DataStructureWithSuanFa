package com.hyq.leetcode2.june.twelve;

/**
 * @ClassName CircleList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/6/12 18:11
 * @Version
 **/
public class CircleList {

    public static ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) {
            return null;
        }
        if(head.next==head){
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode pointFast = pre;
        ListNode pointSlow = pre;

        while(pointSlow!=pointFast||(pointSlow==pointFast&&pointSlow==pre)){

            pointSlow=pointSlow.next;

//            if(pointFast!=null) {
//                pointFast=pointFast.next;
//                if(pointFast!=null){
//                    pointFast=pointFast.next;
//                }else{
//                    break;
//                }
//            } else {
//                break;
//            }

            //优化
            if(pointFast==null||pointFast.next==null){
                break;
            }
            pointFast=pointFast.next.next;
        }

        if(pointFast==null||pointFast.next==null){
            return null;
        }else{
            pointFast=pre;
            //多余  通过计算位置关系就可以得知只需要一轮就可以找到入口
//            int count=0;
//            while(pointFast!=pointSlow){
//                pointFast=pointFast.next;
//                count+=1;
//            }
//
//            pointFast=pre;
//            pointSlow=pre;
//            for(;count>0;){
//                pointFast=pointFast.next;
//                count--;
//            }
            while(pointFast!=pointSlow){
                pointFast=pointFast.next;
                pointSlow=pointSlow.next;
            }
        }


        return pointSlow;
    }


    public static void main(String[] args) {
        ListNode test = new ListNode(3);
        test.next = new ListNode(2);
        test.next.next = new ListNode(0);
        test.next.next.next = new ListNode(-4);
        test.next.next.next.next = test.next;
        ListNode listNode = detectCycle(test);
        System.out.println(listNode);
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
