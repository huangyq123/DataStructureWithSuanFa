package com.hyq.day4;

import jdk.jfr.Unsigned;

/**
 * @ClassName BinaryNumber
 * @Description TODO   获取二进制中1的个数
 * @Author huangyq
 * @Date 2021/3/1 16:56
 * @Version
 **/
public class BinaryNumber {

    public static void main(String[] args) {
        //int x = Count(-3);
        int x = Count3(-3);
        System.out.println(x);
    }

    //死循环
    public static int Count(int a){
        int count = 0;
        while(a!=0){
            if((a & 1)==1){
                count++;
            }
            a=a>>1;
            //a=a>>>1;解决死循环问题
        }
      return count;
    }

    //实现二
    public static int Count2(int a){
        int count = 0;
         int temp = 1;
        while(temp!=0){
            if((a & temp)==temp){
                count++;
            }
            temp=temp<<1;
        }
        return count;
    }

    //实现三
    public static int Count3(int a){
        int count =0;
        while(a!=0){
            a=a&(a-1);
            count++;
        }
        return count;
    }

}
