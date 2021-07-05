package com.hyq.leetcode2.june.seventeen;

import java.util.Stack;

/**
 * @ClassName RebuildList
 * @Description TODO  重排链表 143
 * @Author huangyq
 * @Date 2021/6/17 18:20
 * @Version
 **/
public class RebuildList {

    public void reorderList(ListNode head) {
        //使用两个栈分别来存储前半个链表和后半个链表
        Stack<ListNode> memory1 = new Stack<>();
        Stack<ListNode> memory2 = new Stack<>();

        int count=0;

        //使用第一个栈存储整个链表并统计链表长度
        ListNode current = head;
        while(current!=null){
            memory1.push(current);
            current = current.next;
            count+=1;
        }

        //将后半部分链表存到另一个栈，若是奇数则前半部分多一个节点
        count/=2;
        for(;count>0;count--){
            memory2.push(memory1.pop());
        }

        //开始重建链表
        current=null;
        ListNode temp = null;
        //奇数情况先从1号栈（前半部分链表）开始取
        if(memory1.size()>memory2.size()){
            temp = memory1.pop();
            temp.next=null;   //避免出现环
            current = temp;
        }
        //依从从2号栈、1号栈取元素连接连接链表
        while(!memory1.isEmpty()){
            current=memory2.pop();
            current.next=temp;
            temp = current;

            current = memory1.pop();
            current.next=temp;
            temp = current;
        }
        head= current;
        return ;
    }//通过测试用例  时间空间效率都不高——O(N) O(N)
    //优化角度：  使用栈不如直接用ArrayList, 先存储后取值；
    //           或者使用反转链表的方式反转后半部分在重构
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }