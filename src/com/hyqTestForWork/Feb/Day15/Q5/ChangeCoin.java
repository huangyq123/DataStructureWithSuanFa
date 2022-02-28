package com.hyqTestForWork.Feb.Day15.Q5;

import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName ChangeCoin
 * @Description TODO  518. 零钱兑换 II  频度 medium
 * @Author huangyq
 * @Date 2022/2/15 20:43
 * @Version
 **/
public class ChangeCoin {

    //超时——且理解有问题
    //TODO  背包类问题解法总结？？
    private int result =0;
    private Stack<Integer> stack = new Stack<>();
    public int change(int amount, int[] coins){

        dfs(amount,coins,0);
        return result;
    }

    public void dfs(int target,int[] coins,int index){

        if(index>=coins.length){
            return ;
        }

        if(target==0){
            result+=1;
//            Stack<Integer> testStack = (Stack<Integer>) stack.clone();
//            while(!testStack.isEmpty()){
//                System.out.print(" "+testStack.pop());
//            }
//            System.out.println();
            return ;
        }

        dfs(target,coins,index+1);
        if(coins[index]-target<=0){
//            stack.push(coins[index]);
            dfs(target-coins[index],coins,index);
//            stack.pop();
        }

        return ;
    }

    @Test
    public void Test(){
        int[] test = new int[]{1,2,5};
        int change = change(5, test);
        System.out.println(change);
    }

    //todo  dp实现
}
