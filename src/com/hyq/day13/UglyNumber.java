package com.hyq.day13;

import java.util.ArrayList;

/**
 * @ClassName UglyNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 7:31
 * @Version
 **/
public class UglyNumber {

    //递推代码优化
    public int nthUglyNumber3(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }


//找递推关系——代码过于繁琐
     public static int nthUglyNumber2(int n){
         if(n==0)
             return 0;

         int pointToTwo = 0;
         int pointToThree = 0;
         int pointToFive = 0;

         ArrayList<Integer> memory = new ArrayList<>();
         memory.add(1);
         while(memory.size()<n){
             if(memory.get(pointToTwo)*2>memory.get(pointToThree)*3){
                 if(memory.get(pointToThree)*3>memory.get(pointToFive)*5){
                     memory.add(memory.get(pointToFive)*5);
                     pointToFive++;
                 }else if (memory.get(pointToThree)*3<memory.get(pointToFive)*5){
                     memory.add(memory.get(pointToThree)*3);
                     pointToThree++;
                 }else{
                     memory.add(memory.get(pointToThree)*3);
                     pointToThree++;
                     pointToFive++;
                 }

             }
             else if(memory.get(pointToTwo)*2<memory.get(pointToThree)*3){
                 if(memory.get(pointToTwo)*2>memory.get(pointToFive)*5){
                     memory.add(memory.get(pointToFive)*5);
                     pointToFive++;
                 }else if(memory.get(pointToTwo)*2<memory.get(pointToFive)*5){
                     memory.add(memory.get(pointToTwo)*2);
                     pointToTwo++;
                 }else{
                     memory.add(memory.get(pointToTwo)*2);
                     pointToTwo++;
                     pointToFive++;
                 }
             } else {
                 if(memory.get(pointToTwo)*2>memory.get(pointToFive)*5){
                     memory.add(memory.get(pointToFive)*5);
                     pointToFive++;
                 }else if(memory.get(pointToTwo)*2<memory.get(pointToFive)*5){
                     memory.add(memory.get(pointToTwo)*2);
                     pointToTwo++;
                     pointToThree++;
                 }else{
                     memory.add(memory.get(pointToTwo)*2);
                     pointToTwo++;
                     pointToThree++;
                     pointToFive++;
                 }
             }
         }
         return memory.get(memory.size()-1);
     }


    //效率低
    //问题： 理清思路再实现
    public static int nthUglyNumber(int n) {
        if(n<0)
            return -1;
        if(n<=5)
            return n;

        ArrayList<Integer> memory = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            memory.add(i + 1);

        int number = 6;
        while (memory.size() < n) {
            int index = 1;
            int temp = memory.get(index);
            boolean flag = false;
            while (temp <= ((int) Math.sqrt(number))) {
                if (number % temp == 0) {
                    if (memory.contains(number / temp)) {
                        temp = memory.get(++index);
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    temp = memory.get(++index);
                }
            }
            if (flag)
                memory.add(number);
            number++;
        }

        return memory.get(memory.size()-1);
    }


    public static void main(String[] args) {
       int result = nthUglyNumber(296);
        System.out.println(result);

        int result2 = nthUglyNumber2(10);
        System.out.println(result2);
    }
}
