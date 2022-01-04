package com.hyq.leetcode3.m11d30;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NthNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/11/30 19:43
 * @Version
 **/
public class NthNumber {

    public static int findNthDigit(int n) {

        if(n<=9){
            return n;
        }

        long n1 = n;
        List<Long> memory = new ArrayList<>();
//        int i=0;
        long count = 0 ;
        long base = 1;
        long length =1;

        int result = 0;
        while(count<n1){
            count = count + 9*base*length;
            memory.add(count);
            base*=10;
            length+=1;
        }

        if(count==n1){
            return 9;
        }

        long temp = memory.get(memory.size()-2);
         n1 = n1-temp;

        long indexOfNumber = n1/(length-1);
        count = ((long) Math.pow(10,length-2)) + indexOfNumber;
        long indexOfDigit = n1-indexOfNumber*(length-1);
        if(indexOfDigit==0){
            count-=1;
            result = (int) count%10;
        }else{
//            count+=1;
            String resultStr = Long.toString(count);
            result = resultStr.charAt(((int)indexOfDigit-1))-'0';
        }

        return result;

    }

    public static void main(String[] args) {
        int nthDigit = findNthDigit(15);
        System.out.println(nthDigit);
    }
}
