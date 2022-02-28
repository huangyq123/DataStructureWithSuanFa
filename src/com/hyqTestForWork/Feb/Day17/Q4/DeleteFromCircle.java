package com.hyqTestForWork.Feb.Day17.Q4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName DeleteFromCircle
 * @Description TODO  剑指 Offer 62. 圆圈中最后剩下的数字  频度 easy
 * @Author huangyq
 * @Date 2022/2/17 20:16
 * @Version
 **/
public class DeleteFromCircle {
    //超时
    public int lastRemaining(int n, int m) {

        Queue<Integer> memory = new LinkedList<>();
        for(int i=0;i<n;i++){
            memory.add(i);
        }

        while(memory.size()>1){
            for(int i=1;i<m;i++){
                Integer poll = memory.poll();
                memory.add(poll);
            }
            memory.poll();
        }


        return memory.poll();
    }

    //TODO  约瑟夫环
    public int lastRemaining2(int n, int m){
        int temp = 0;

        for(int i=2;i<=n;i++){
            temp = (temp+m)%i;
        }

        return temp;
    }

}
