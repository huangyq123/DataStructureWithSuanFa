package com.hyq.day3.sort;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author huangyq
 * @Date 2021/2/27 13:54
 * @Version
 **/
public class InsertSort {

    public static void HalfInsertSort(int[] a){
        int left = 0;
        int right = 0;
        int medium = 0;
        for(int m=1;m<a.length;m++){
            left=0;
            right = m-1;
            int temp = a[m];
            while(left<=right){//等于的作用？避免第一次不进行比较就直接对换元素

                medium = (left+right)/2;
                if(a[m]>a[medium]){
//                    left++;
                    left=medium+1;
                }else{
                    //right++;
                    right=medium-1;
                }
            }
            //不论最后是移动left还是right，left的位置都是本轮排序元素位置（比他大则最后是right右移，比他小则是left左移）
            for(int k = m;k>left;k--){
                a[k]=a[k-1];
            }
            a[left]=temp;//
        }


    }


    public static void main(String[] args) {
        int[] a = new int[]{2,3,4,1,2};
        //DirestInsert(a);
        HalfInsertSort(a);
        for(int x:a){
            System.out.println(x);
        }
    }

       public static void DirestInsert(int[] a){
           for(int i=1;i<a.length;i++){
               int temp = a[i];
               int m=i-1;
               for(;m>=0;m--){
                   if(a[m]>temp)
                       a[m+1]=a[m];
                   else
                       break;
               }
               a[m+1]=temp;    //赋值不交换，减少交换次数

//               for(int m=i;m>0;m--){
//                   //交换多余
//                   if(a[m]<a[m-1])
//                       swap(a,m,m-1);
//                  else
//                       break;
//               }
           }
       }

    public static void swap(int[] a, int numberOne, int numberTwo) {
        int temp = a[numberOne];
        a[numberOne] = a[numberTwo];
        a[numberTwo] = temp;
    }
}
