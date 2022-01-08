package com.hyqTestForWork.Janu.Day5.Q1;

import java.util.List;

/**
 * @ClassName MaxSubArraySum
 * @Description TODO  21 合并两个升序链表  hot100  easy
 * @Author huangyq
 * @Date 2022/1/4 20:21
 * @Version
 **/
public class MergeTwoList {

    /**迭代方式实现——使用虚拟头节点来保存最后的结果链表，使用一个前驱pre来延申链表；
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null&&list2==null){
            return null;
        }else if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }

        ListNode pre = new ListNode(-1);
        ListNode currentHead = pre;
        ListNode pointOne = list1;
        ListNode pointTwo = list2;

        while(list1!=null||list2!=null){
            if(list1==null){
                pre.next=list2;
                break;
            }else if(list2==null){
                pre.next=list1;
                break;
            }else {

                if (list1.val <= list2.val) {
                    pre.next = list1;
                    list1 = list1.next;
                    pre = pre.next;
                    pre.next = null;
                } else {
                    pre.next = list2;
                    list2 = list2.next;
                    pre = pre.next;
                    pre.next = null;
                }
            }
        }

        return currentHead.next;
    }

    //题解：1、迭代；2、递归

    //递归实现
    public ListNode mergeTwoListsByDeep(ListNode list1, ListNode list2){
        if(list1==null&&list2==null){
            return null;
        }else if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }

        ListNode temp=null;
        if(list1.val>list2.val){
            temp = list2;
            list2=list2.next;
            temp.next=null;
        }else{
            temp = list1;
            list1=list1.next;
            temp.next=null;
        }

        temp.next=mergeTwoListsByDeep(list1,list2);

        return temp;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
