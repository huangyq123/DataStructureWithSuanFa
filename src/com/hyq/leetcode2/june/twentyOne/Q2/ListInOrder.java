package com.hyq.leetcode2.june.twentyOne.Q2;

/**
 * @ClassName ListInOrder
 * @Description TODO
 * @Author huangyq
 * @Date 2021/6/21 18:47
 * @Version
 **/
public class ListInOrder {

    public static ListNode sortList(ListNode head) {

       return recur(head);

    }

    //归并排序第一步——分解
    public static ListNode recur(ListNode head){
        //分解终止条件
        if(head==null||head.next==null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        //快慢指针查找中点
        while(fast.next!=null){
            if(fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else {
                fast=fast.next;
            }
        }

        ListNode temp = slow.next;
        //考虑到每一个链表的尾指针情况
        slow.next = null;
        //递归分解
        ListNode result1 = recur(head);
        ListNode result2 = recur(temp);

        //归并第二步——合并
        ListNode result = merge(result1, result2);
        return result;
    }

    public static ListNode merge(ListNode head1,ListNode head2){
        //建立虚拟头节点
        ListNode tempHead = new ListNode(0);
        ListNode current = tempHead;

        //比较链表得到要指向的节点
        while(head1!=null||head2!=null){
            if(head1 == null){
                current.next = head2;
                break;
            }else if(head2==null){
                current.next = head1;
                break;
            } else if(head1.val<head2.val){
                current.next=head1;
                current = current.next;
                head1=head1.next;
            }else if(head1.val>=head2.val){
                current.next=head2;
                current = current.next;
                head2=head2.next;
            }
        }

        //合并完的链表作为返回结果
        return tempHead.next;
    }

    //问题： 看类题解才有完整思路  没看题解前——想到了排序算法，可以满足视角复杂度，但是卡在了空间效率无法满足的问题
    //归并排序应用在链表和数组时的区别——实现、时间复杂度、空间复杂度

    //体会：  遇到排序——考虑几大排序算法； 时间、空间要求——选择合适的排序算法  数据结构——不同数据结构实现算法时时间、空间复杂度不一样
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(4);
//        listNode.next=new ListNode(2);
//        listNode.next.next=new ListNode(1);
//        listNode.next.next.next=new ListNode(3);

        ListNode listNode = new ListNode(-1);
        listNode.next=new ListNode(5);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(0);


        ListNode result = sortList(listNode);

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