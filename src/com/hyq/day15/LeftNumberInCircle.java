package com.hyq.day15;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LeftNumberInCircle
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/14 10:34
 * @Version
 **/
public class LeftNumberInCircle {

    //动态规划
    public int lastRemaining3(int n, int m){
        int x = 0;
        int count = 1;

        while(count<n){
            x=(x+m)%(count+1);
            count++;
        }
        return x;
    }

    //时间效率不够高 O(N2)
    public int lastRemaining2(int n, int m){
        Queue<Integer> circle = new LinkedList<>();
        for(int i =0;i<n;i++)
            circle.add(i);

        int count = 0 ;
        while(circle.size()>1){
            count = m%circle.size();
            if(count==0)
                count+= circle.size();
            while(count>1){
                circle.add(circle.poll());
                count--;
            }
            circle.poll();
        }
        return circle.poll();
    }

    //时间效率低 O(NM)
    public int lastRemaining(int n, int m){
        if(n<0||m<=0)
            return -1;
        if(n==0)
            return 0;

        Queue<Integer> circle = new LinkedList<>();
        for(int i =0;i<n;i++)
            circle.add(i);

        int count = 0 ;
        while(circle.size()>1){
            count++;
            if(count!=m)
                circle.add(circle.poll());
            else{
                circle.poll();
                count=0;
            }
        }
        return circle.poll();
    }
}

class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }
}