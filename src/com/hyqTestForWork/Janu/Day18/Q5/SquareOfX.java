package com.hyqTestForWork.Janu.Day18.Q5;

/**
 * @ClassName SquareOfX
 * @Description TODO 69 X的平方根  频度 easy
 * @Author huangyq
 * @Date 2022/1/18 21:48
 * @Version
 **/
public class SquareOfX {

    //  看题解  1.19
    public int mySqrt(int x){


        for(int i=0;i<x;i++){
            long temp = i*i;
            if(temp>x){
                return i-1;
            }if(temp==x){
                return i;
            }
        }
        return -1;
    }
}
