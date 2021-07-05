package com.hyq.leetcode2.june.twentyOne.Q3;

import java.util.List;

/**
 * @ClassName deleteDuplicateNumbers
 * @Description TODO
 * @Author huangyq
 * @Date 2021/6/21 19:49
 * @Version
 **/
public class DeleteDuplicateNumbers {
    public static ListNode deleteDuplicates(ListNode head) {

        //直接返回的情况
        if(head==null||head.next==null){
            return head;
        }

        //辅助节点，包括虚拟头节点dummyHead、当前要判断的节点current，确定的链表中的尾节点pre，比较值temp
        ListNode dummyHead = new ListNode(head.val-1,head);
        ListNode pre=dummyHead;
        ListNode current = head;
        int temp = dummyHead.val;

        //开始删除判断
        while(current.next!=null){
            //当前结点的和后面节点值重复，删除后面节点
            if(current.val== current.next.val){
                current.next=current.next.next;
                temp = current.val;
            }
            //当前节点的重复节点删除完毕，开始删除当前节点，并开始考虑下一个节点
            else if(current.val==temp){
                pre.next=current.next;
                current=pre.next;
            }
            //当前节点无重复，继续判断下一个节点
            else {
                current=current.next;
                pre=pre.next;
            }
        }

        //末尾元素的重复也需要删除
        if(current.val==temp){
            pre.next=current.next;
        }

        return dummyHead.next;
    }
    //总结：  链表问题可以多设置几个变量存储指针，便于理清楚逻辑；   迭代、递归效果一样，根据情况选择合适的

    public static void main(String[] args) {
        ListNode testHead = new ListNode(0);
        ListNode current = testHead;
        int[] test = new int[]{1,1};
        for(int i=0;i<test.length;i++){
            current.next = new ListNode(test[i]);
            current= current.next;
        }

        ListNode result = deleteDuplicates(testHead.next);

        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }


    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}