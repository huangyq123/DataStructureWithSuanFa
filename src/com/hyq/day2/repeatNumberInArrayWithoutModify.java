package com.hyq.day2;

import java.util.Scanner;

/**
 * @ClassName repeatNumberInArrayWithoutModify
 * @Description TODO 寻找重复数字，不修改数组
 * @Author huangyq
 * @Date 2021/2/25 10:22
 * @Version
 **/
public class repeatNumberInArrayWithoutModify {
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


        //Version 1.0  辅助数组查找
        int[] a1 = new int[len];
        for (int i = 0; i < len; ) {
            numberOne = a[i];
            if (numberOne >= len || numberOne == 0) {
                break;
            }
            if (a1[numberOne] != numberOne) {
                a1[numberOne] = numberOne;
                i++;
            } else {
                flag = true;
                break;
            }
        }


        //Version 2.0 二分法
        int i = find(1, len - 1, a);

        //根据结果输出
        if (flag == true) {
            System.out.println("重复数字为：" + numberOne);
        } else {
            System.out.println("无重复数字");
        }


    }

//    public int Count(int left, int right, int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] >= array.length || array[i] <= 0)
//                return 0;
//        }
//
//
//        if (left == right) {
//            return left;
//        }
//
//        if (left < right) {
//            int medium = (left + right) / 2;
//            int countLeft = 0;
//            int countRight = 0;
//            for (int i = 0; i < array.length; i++) {
//                if (array[i] >= left && array[i] <= medium) {
//                    countLeft += 1;
//                } else if (array[i] <= right && array[i] > medium) {
//                    countRight += 1;
//                }
//            }
//            if (countLeft > (medium - left + 1)) {
//                return Count(left, medium, array);
//            } else {
//                return Count(medium + 1, right, array);
//            }
//        }
//        return 1;
//    }


    public static int Count2(int left, int right, int[] array) {
        int countNumber=0;
          for(int i=0;i<array.length;i++){
              if(array[i]>=left&&array[i]<=right)
                  countNumber+=1;
          }
          return countNumber;
    }

    public static int find(int start, int end, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= array.length || array[i] <= 0)
                return -1;
        }
        while (start <= end) {
            int medium = (start + end) / 2;
            int count = Count2(start, medium, array);
            if (start == end) {
                if(count>1){
                    return start;
                }else
                    break;
            }
            if (count > (medium - start + 1)) {
                end = medium;
            } else {
                start = medium + 1;
            }
        }
        return -1;
    }


}
