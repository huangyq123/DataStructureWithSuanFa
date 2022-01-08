package com.hyqTestForWork.Janu.Day5.Q3;

/**
 * @ClassName MaxSubArraySum
 * @Description TODO  160 相交链表  hot100  easy
 * @Author huangyq
 * @Date 2022/1/4 20:21
 * @Version
 **/
public class CrossList {

    /**
     *@Author admin
     *@Description TODO   //双指针遍历：考虑长度关系判断相交
     *@Date 2022/1/5 10:50
     *@Param [headA, headB]
     *@return com.hyqTestForWork.Janu.Day5.Q3.ListNode
     *@Version
     **/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }

        ListNode pointOne = headA;
        ListNode pointTwo = headB;

        boolean flagA = false;
        boolean flagB = false;

        while(!(flagA&&flagB)){
            if(pointOne==pointTwo){
                return pointOne;
            }

            if(pointOne.next!=null) {pointOne=pointOne.next;}
            else {pointOne = headB; flagA=true;}

            if(pointTwo.next!=null) {pointTwo=pointTwo.next;}
            else {pointTwo=headA; flagB=true;}

        }

        ListNode result = null;

        while(pointOne!=null){
            if(pointOne==pointTwo){
                result=pointOne;
                break;
            }
            pointOne=pointOne.next;
            pointTwo=pointTwo.next;
        }

        return result;

        //代码优化，从flagA定义开始
        //理解：两个循环的核心相同——链表遍历+判断位置，因此考虑使用一个循环处理； 通过判断指针本身而不是next来保证第二轮循环结束后都到达null时能够结束循环
//
//        while(pointOne!=pointTwo){
//
//            if(pointOne!=null) {pointOne=pointOne.next;}
//            else {pointOne = headB; }
//
//            if(pointTwo!=null) {pointTwo=pointTwo.next}
//            else {pointTwo=headA;}
//
//        }
//
//        return pointOne;


    //题解：1、哈希集；2、双指针
        // 哈希集简单，看看思想就行

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
