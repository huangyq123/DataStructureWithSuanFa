package com.hyqTestForWork.Janu.Day21.Q1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName DeleteDuplicateElements
 * @Description TODO 82  删除排序链表中的重复元素2  频度 medium
 * @Author huangyq
 * @Date 2022/1/21 18:41
 * @Version
 **/
public class DeleteDuplicateElements {
    //分类处理：查找到重复的；  当前节点值第一次出现则考虑前一节点值是否重复；
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(-101);
        pre.next = head;
        ListNode preFront = new ListNode(-102);
        preFront.next=pre;
        Map<Integer,Boolean> memory = new LinkedHashMap<>();
        ListNode current = head;
        ListNode front = pre;

        while(current!=null){
            if(memory.containsKey(current.val)){
                memory.put(current.val,true);
                front.next = current.next;
                current.next = null;
                current = front.next;
            }else if(memory.containsKey(front.val)&&memory.get(front.val)==true){
                memory.remove(front.val);
                preFront.next = current;
                front.next=null;
                front = preFront.next;
                current = front.next;
                memory.put(front.val, false);
            }else{
                memory.put(current.val, false);
                current = current.next;
                front = front.next;
                preFront = preFront.next;
            }
        }
        //注意末尾的处理，可能出现最后一个重复值未被处理的情况
        if(memory.containsKey(front.val)&&memory.get(front.val)==true){
            memory.remove(front.val);
            preFront.next = current;
            front.next=null;
            front = preFront.next;
        }

        return pre.next;

    }

    //TODO 算法优化  1.22
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}