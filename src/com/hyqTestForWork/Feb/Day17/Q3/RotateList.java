package com.hyqTestForWork.Feb.Day17.Q3;

/**
 * @ClassName RotateList
 * @Description TODO  61. 旋转链表 频度 medium
 * @Author huangyq
 * @Date 2022/2/17 19:54
 * @Version
 **/
public class RotateList {
    //直接的两次遍历——一次计算长度，第二次找断开位置
    // 常用技巧：虚拟头节点， 前驱节点
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0){
            return head;
        }

        ListNode pre = new ListNode(-1,head);
        int length = 0;
        ListNode current = pre;
        while(current.next!=null){
            current = current.next;
            length++;
        }

        int times = length - (k%length);
        if(times==length){
            return head;
        }
        ListNode position = head;
        ListNode prevNode = pre;
        while(times>0){
            prevNode = position;
            position = position.next;
            times--;
        }

        current.next = head;
        prevNode.next = null;
        pre.next = null;
        return position;

    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
