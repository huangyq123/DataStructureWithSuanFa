package com.hyqTestForWork.Janu.Day4.Q1;

/**
 * @ClassName CircleList
 * @Description TODO  141 环形链表  hot100
 * @Author huangyq
 * @Date 2022/1/4 20:57
 * @Version
 **/
public class CircleList {
    //快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next=head;

        ListNode fast=pre;
        ListNode slow=pre;
        boolean flag=false;
        while(true){
            if(slow.next!=null){
                slow=slow.next;
            }else{
                flag=false;
                break;
            }
            if(fast.next!=null&&fast.next.next!=null){
                fast=fast.next.next;
            }else{
                flag=false;
                break;
            }

            if(slow==fast){
                flag=true;
                break;
            }
        }
        return flag;
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
