package com.hyq.leetcode.LinkList.question4;


import java.util.Stack;

/**
 * @ClassName PalindList
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/31 19:08
 * @Version
 **/
public class PalindList {

    public static boolean isPalindrome(ListNode3 head) {
        if(head==null)
            return false;

        Stack<Integer> memory = new Stack<>();

        int count = 0;
        ListNode3 currentNode = head;
        while(currentNode!=null){                    //记录长度
            count+=1;
            currentNode = currentNode.next;
        }

        int length = (count+1)/2;                 //一半长度，即中间位置

        int position = 1;
        currentNode = head;

        while(position<=length){                  //保存前一半元素
            memory.push(currentNode.val);
            currentNode = currentNode.next;
            position+=1;
        }

        if(count%2!=0)                              //奇数则不考虑中间位置元素
            memory.pop();

        while(currentNode!=null){                     //开始比较
            if(currentNode.val!=memory.peek())
                break;
            currentNode = currentNode.next;
            memory.pop();
        }

        return memory.isEmpty();
    }

    public static void main(String[] args) {
        ListNode3 head = new ListNode3(1,new ListNode3(2,new ListNode3(2,new ListNode3(1))));
        isPalindrome(head);
    }
}
class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3() {
    }

    ListNode3(int val) {
        this.val = val;
    }

    ListNode3(int val, ListNode3 next) {
        this.val = val;
        this.next = next;
    }
}