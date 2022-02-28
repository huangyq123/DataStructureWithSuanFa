package com.hyqTestForWork.Janu.Day20.Q5;

/**
 * @ClassName RenewList
 * @Description TODO 143 重排链表 频度 medium
 * @Author huangyq
 * @Date 2022/1/20 20:31
 * @Version
 **/
public class RenewList {
    public void reorderList(ListNode head){

        if(head==null||head.next==null){
            return ;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        //快慢指针找中点
        while(fast!=null){
            if(fast.next!=null){
                if(fast.next.next!=null) {
                    fast = fast.next.next;
                }else{
                    fast = fast.next;
                }
                slow = slow.next;
            }else{
                break;
            }
        }
        //切割出后半截链表
        ListNode footHalf = slow.next;
        slow.next=null;
        //反转后半截链表
        ListNode newFootHalf = ReverseList(footHalf);

        //重排链表
        ListNode headHalf = pre.next;
        while(newFootHalf!=null){
            ListNode tempHeadHalf = headHalf.next;
            ListNode tempFootHalf = newFootHalf.next;
            headHalf.next=newFootHalf;
            newFootHalf.next = tempHeadHalf;
            headHalf = tempHeadHalf;
            newFootHalf = tempFootHalf;
        }
        //删除虚拟头节点
        pre.next = null;
    }

    public ListNode ReverseList(ListNode root){
        ListNode current= null;

        while(root!=null){
            ListNode temp = root.next;
            root.next=current;
            current = root;
            root=temp;
        }

        return current;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }