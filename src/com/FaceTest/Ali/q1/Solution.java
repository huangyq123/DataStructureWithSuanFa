package com.FaceTest.Ali.q1;

import org.junit.Test;

public class Solution {

    public static void main(String[] args) {

    }

    public int count(int side,int time){
        int sum = 1;
        int lastSide = 1;

        while(time>0){
            lastSide+=(side-2);
            sum+=lastSide;
            time--;
        }
        return sum;
    }

    public int TriangleSum(int n){

        return ((n-1)*(n-2))*n/3/2-((n/2-1)*(n/2)/2*n);
    }

    @Test
    public void Test(){
//        int count = count(3, 4);
//        int count1 = count(5, 3);
//        System.out.println(count);
//        System.out.println(count1);
        int i = TriangleSum(6);
        System.out.println(i);
    }
}
