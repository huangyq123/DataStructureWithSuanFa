package com.hyqTestForWork.Janu.Day20.Q1;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName CircleListTwo
 * @Description TODO  142  环形链表2  频度 medium
 * @Author huangyq
 * @Date 2022/1/20 15:28
 * @Version
 **/
public class CircleListTwo {
    //第二步和第三步可以优化成一段逻辑（时间上没有区别）—— 优化的理解：从数量关系上进行判断快慢指针步数  1.21
    public ListNode detectCycle(ListNode head){
        if(head==null){
            return null;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode fast = pre;
        ListNode slow = pre;
        //有无环判断
        while(fast!=null){
            if(fast.next!=null){
                fast = fast.next.next;
            }else{
                fast = fast.next;
                break;
            }
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        //统计环长
        if(fast==null){
            return null;
        }
        int length = 1;
        fast = fast.next;
        while(fast!=slow){
            fast=fast.next;
            length+=1;
        }

        //开始寻找环的起始节点
        slow = pre;
        fast = pre;
        while(slow==pre||slow!=fast){
            fast = fast.next;
            length--;
            if (length < 0) {
                slow=slow.next;
            }
        }

        return slow;
    }


    //哈希表解法
    public ListNode detectCycle2(ListNode head){
        if(head==null){
            return null;
        }

        Set<ListNode> memory = new HashSet<>();

        ListNode current = head;
        while(current!=null){
            if(memory.contains(current)){
                return current;
            }else{
                memory.add(current);
                current = current.next;
            }
        }

        return null;
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
