package com.hyqTestForWork.Janu.Day9.Q10;

/**
 * @ClassName HanMingDistance
 * @Description TODO 461 汉明距离  hot100  easy
 * @Author huangyq
 * @Date 2022/1/9 19:27
 * @Version
 **/
public class HanMingDistance {
    //位运算
    public int hammingDistance(int x, int y) {

        int result = 0;
        int temp = (x^y);
        while(temp>0){
           if((temp&1)==1){
               result+=1;
           }
           temp>>=1;
        }

        return result;

    }

    //Brian Kernighan算法
    public int hammingDistance2(int x, int y){
        int temp = x^y;
        int result=0;
        while(temp!=0){
            result+=1;
            temp =temp&(temp-1);
        }

        return result;
    }
}
