package com.hyq.day3.sort;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author huangyq
 * @Date 2021/2/27 15:12
 * @Version
 **/
public class ShellSort {

    public static void ShellSortImpl(int[] a){
        int gap  = a.length/2;//当长度为偶数，则第一组多一个元素，不影响过程
        int temp =0;
        while(gap>0){
            for(int m=gap;m<a.length;m++){
                int k=m;
                //多余赋值操作
//                while(k>=gap){
//                    if(a[k]<a[k-gap]){
//                        temp = a[k-gap];
//                        a[k-gap]=a[k];
//                        a[k]=temp;
//                    }else
 //                       break;
//                    k-=gap;
//                }

                //减少赋值
                temp = a[m];
                while(k>=gap){
                    if(a[k]<a[k-gap]){
                        a[k]=a[k-gap];
                    }else
                        break;
                    k-=gap;
                }
                a[k]=temp;

                //for循环方式
//                for(; k>=gap && temp<a[k-gap]; k-=gap)
//                    arr[k] = arr[k-gap]; //原有序数组最大的后移一位
//                arr[k] = temp;


            }
            gap=gap/2;
        }
    }

}
