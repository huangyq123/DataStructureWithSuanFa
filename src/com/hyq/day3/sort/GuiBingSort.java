package com.hyq.day3.sort;

/**
 * @ClassName GuiBingSort
 * @Description TODO
 * @Author huangyq
 * @Date 2021/2/27 15:46
 * @Version
 **/
public class GuiBingSort {

    public static void main(String[] args) {
        int[] a=getRandomArray(10,2,12);
        for(int k:a){
            System.out.print(k+"   ");
        }
        System.out.println(" ");
        MergeSort(a,0,a.length-1);
        for(int k:a){
            System.out.print(k+"   ");
        }
    }


    public static void MergeSort(int[] a, int left,int right){
        if(left>=right){//等号意义
            return;
        }

        int medium = (left+right)/2;
        MergeSort(a,left,medium);
        MergeSort(a,medium+1,right);
        merge(a,left,medium,right);
    }

    public static void merge(int[] a,int left,int medium,int right){
        int[] assist = new int[right-left+1];

        int pointOne = left;
        int pointTwo = medium+1;
        for(int i=0;i<right-left+1;i++){
            if(pointOne>medium)
                assist[i]=a[pointTwo++];
            else if(pointTwo>right)
                assist[i]=a[pointOne++];//赋值与自加的顺序
            else if(a[pointOne]>a[pointTwo])
                assist[i]=a[pointTwo++];
            else
                assist[i]=a[pointOne++];
        }

        for(int m=0;m<assist.length;m++){
            a[m+left]=assist[m];
        }
    }

//测试数组生成
    public static int[] getRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = (int)(Math.random() * (rangeR - rangeL +1)) + rangeL;
        }
        return arr;
    }

}
