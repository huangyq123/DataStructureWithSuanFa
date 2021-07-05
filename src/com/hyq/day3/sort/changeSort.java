package com.hyq.day3.sort;

/**
 * @ClassName changeSort
 * @Description TODO   交换排序实现
 * @Author huangyq
 * @Date 2021/2/26 15:34
 * @Version
 **/
public class changeSort {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 6, 4, 7, 5,1};
        //PopSort(a);
        QuickSort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }

    }


    /**
     * @return void
     * @Author huangyq
     * @Description TODO   冒泡排序
     * @Date 2021/2/26 15:47
     * @Param [a]
     * @Version
     **/
    public static void PopSort(int[] a) {
        int temp = 0;
        for (int m = 0; m < a.length - 1; m++) {//决定循环次数，冒泡排序次数为 长度-1
            for (int n = 0; n < a.length - 1 - m; n++) {//每一轮比较次数，次数为 长度-1-排序完成个数（也可以是n改变，取决于将排序结果放在头还是尾）
                if (a[n] > a[n + 1]) {
                    temp = a[n];
                    a[n] = a[n + 1];
                    a[n + 1] = temp;
                }
            }
        }
    }




    /**
     *@Author huangyq
     *@Description TODO  快排实现：基准元素、左右边界、左右子数组分治
     *                   理解：每一次划分过程中，当从一侧开始寻找找到了交换元素后，会根据循环顺序进入
     *                   下一个方向的循环；直到不满足条件说明l=r，表示找到了基准元素的位置；
     *                   注意点：l<r是因为如果l<=r则最后外层循环结束时l不等于r，由于不能确定
     *                         最后一次是从哪个方向查找，无法确定基准元素位置；
     *                         start>end是因为当考虑边界条件（如数组为两个相等元素时，会在递归过程中
     *                         直接出现start>end的情况，这时使用start==end会无法结束递归）。
     *@Date 2021/2/27 10:16
     *@Param [a, start, end]
     *@return void
     *@Version
     **/
    public static void QuickSort(int[] a, int start, int end) {
        if(start>end){
            return;
        }

        int temp = a[start];
        int l=start;
        int r = end;
        while(l<r){
            while(l<r&&a[r]>=temp)
                r--;
            if (l < r)
            a[l++]=a[r];
            while(l<r&&a[l]<=temp)//当从右边找到交换元素后，开始从左边开始查找
                l++;
            if (l < r)
            a[r--]=a[l];
        }
        a[l]=temp;
        QuickSort(a,start,l-1);
        QuickSort(a,l+1,end);

    }

    //封装形式快排
    public static void Quicksort2(int array[], int left, int right) {
        if(left < right){
            int pos = partition(array, left, right);//partition2
            Quicksort2(array, left, pos - 1);
            Quicksort2(array, pos + 1, right);
        }
    }

    //”挖坑“快排
    public static int partition(int[] array,int left,int right) {
        int key = array[right];//初始坑
        while(left < right) {
            //left找大
            while(left < right && array[left] <= key )
                left++;
            array[right] = array[left];//赋值，然后left作为新坑
            //right找小
            while(left <right && array[right] >= key)
                right--;
            array[left] = array[right];//right作为新坑
        }
        array[left] = key;
       /*将key赋值给left和right的相遇点，
        保持key的左边都是比key小的数，key的右边都是比key大的数*/
        return left;//最终返回基准
    }


   //双指针形式的快排
    public static int partition2(int[] array,int left,int right) {
        int begin = left;
        int end = right;
        int key = right;

        while( begin < end ) {
            //begin找大
            while(begin < end && array[begin] <= array[key])//
                begin++;
            //end找小
            while(begin < end && array[end] >= array[key])
                end--;
            swap(array,begin,end);
        }
        swap(array,begin,right);//begin先停，保证该数比基准数大
        return begin;   //返回基准位置
    }

    public static void swap(int[] a,int numberOne, int numberTwo) {
        int temp = a[numberOne];
        a[numberOne] = a[numberTwo];
        a[numberTwo] = temp;
    }

}
