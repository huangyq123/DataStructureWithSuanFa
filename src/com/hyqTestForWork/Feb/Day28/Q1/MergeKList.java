package com.hyqTestForWork.Feb.Day28.Q1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *@Author admin
 *@Description TODO  23. 合并K个升序链表  hard
 *@Date 2022/2/28 21:13
 *@Param
 *@return
 *@Version
 **/

public class MergeKList {
    //优先队列——思路：两个链表使用原地算法就可以合并；  多个链表时，考虑如何从多个节点中查找最小值？——多个值查找最小，并保证下一次依然能快速找到最小值，典型的优先队列
    //  注意细节：比较器的判断和最后的升序降序的关系；  虚拟头节点进行存储
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                queue.add(lists[i]);
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode current = pre;

        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            if(temp.next!=null){
                queue.add(temp.next);
            }
            current.next = temp;
            current = current.next;
        }

        return pre.next;
    }


    //TODO  分治法 3.1
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
