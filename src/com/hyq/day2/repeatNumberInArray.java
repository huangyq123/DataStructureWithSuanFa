package com.hyq.day2;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName repeatNumberInArray
 * @Description TODO 寻找数组中重复数字
 * @Author huangyq
 * @Date 2021/2/25 9:03
 * @Version
 **/
public class repeatNumberInArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入数组长度：");
        int len = scan.nextInt();

        int[] a = new int[len];
        System.out.println("请输入数组元素：");
        for (int i = 0; i < len; i++) {
            int t = scan.nextInt();
            a[i] = t;
        }

        boolean flag = false;
        int numberOne = 0;
        int numberTwo = 0;

        //寻找过程_ Version 1.0
//        for(int i=0;i<len;i++){
//            numberOne = a[i]; //从左往右查找
//            for(int m = i+1;m<len;m++){
//                numberTwo = a[m];
//                if(numberOne == numberTwo){
//                    flag = true;   //找到重复数字则停止查找
//                    break;
//                }
//            }
//            if(flag == true) //找到重复数字则停止查找
//                break;
//        }

        //寻找算法 Version 2.0
//        for (int i = 0; i < len; ) {
//            if (a[i] == i) {
//                i++;
//                continue;
//            } else {
//                int t = a[i];
//                if (a[i] == a[t]) {
//                    flag = true;
//                    numberOne = a[i];
//                    break;
//                } else {
//                    a[i] = a[t];
//                    a[t] = t;
//                }
//            }
//        }//时间复杂度 O（n） 空间复杂度O（1）

        //寻找算法 Version 2.1  考虑边界
        boolean flag2= true;
        for(int i=0;i<len;i++){
            if(a[i]>=len||a[i]<0){//判断是否越界
                flag2 = false;
                break;
            }
        }
        if(flag2!=true){
            for (int i = 0; i < len; ) {
                if (a[i] == i) {
                    i++;
                } else {
                    int t = a[i];
                    if (a[i] == a[t]) {
                        flag = true;
                        numberOne = a[i];
                        break;
                    } else {
                        a[i] = a[t];
                        a[t] = t;
                    }
                }
            }
        }



        //根据结果输出
        if(flag == true){
            System.out.println("重复数字为："+numberOne);
        }else{
            System.out.println("无重复数字");
        }




    }
}
