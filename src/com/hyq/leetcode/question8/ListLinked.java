package com.hyq.leetcode.question8;

/**
 * @ClassName ListLinked
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/21 20:27
 * @Version
 **/
public class ListLinked {

    //优化——if\else的相同操作；增加头节点后的边界条件判断；多余变量
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode extra = new ListNode();
        extra.next = l1;

        ListNode currentNode = extra;
        ListNode point1 = l1;
        ListNode point2 = l2;

        while(point1!=null||point2!=null){
            if(point1==null){
                currentNode.next = point2;
                break;
            }else if(point2==null){
                currentNode.next=point1;
                break;
            }


            if(point1.val<point2.val){
                currentNode.next = point1;
                currentNode = point1;
                point1 = point1.next;
            }else{
                currentNode.next=point2;
                currentNode = point2;
                point2= point2.next;
            }
        }
        return extra.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
