package com.hyq.day3.sort;

/**
 * @ClassName Review
 * @Description TODO
 * @Author huangyq
 * @Date 2021/2/28 8:36
 * @Version
 **/
public class Review {

    //直接选择排序

    public static void DirectSelect(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int m = i + 1; m < a.length; m++) {
                if (a[m] < a[min])
                    min = m;
            }
            swap(a, min, i);
        }
    }


    //堆排序
    public static void HeapSort(int[] a) {
        for (int m = a.length / 2 - 1; m >= 0; m--) {
            HeapBuild(a, m, a.length);
        }

        for (int k = a.length - 1; k > 0; k--) {
            swap(a, 0, k);
            HeapBuild(a, 0, k);
        }
    }


    public static void HeapBuild(int[] a, int number, int length) {
        int temp = a[number];
//        int father = number;
        int index = 2 * number + 1;
        for (; index < length; index = number * 2 + 1) {
            if (index + 1 < length && a[index + 1] > a[index])
                index += 1;
            if (a[index] > temp) {
                a[number] = a[index];
                number = index;
            } else {
                break;
            }
        }
        a[number] = temp;
    }


    //冒泡排序
    public static void PopSort(int[] a) {
        for (int m = 0; m < a.length - 1; m++) {
            int flag = 0;
            for (int n = m; n < a.length - 1; n++) {
                if (a[n] > a[n + 1]) {
                    swap(a, n, n + 1);
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }
    }

    //鸡尾酒排序
    public static void DrinkSort(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int flag1 = 0;
            int flag2 = 0;
            for (int m = left; m < right; m++) {
                if (a[m] > a[m + 1]) {
                    swap(a, m, m + 1);
                    flag1 = 1;
                }
            }
            right--;
            for (int n = right; n > left; n--) {
                if (a[n] < a[n - 1]) {
                    swap(a, n, n - 1);
                    flag2 = 1;
                }
            }
            left++;

            if (flag1 == 0 || flag2 == 0)
                break;
        }
    }

    //快速排序
    public static void QuickSort(int[] a, int start, int end) {
        if (start > end) {
            return;
        }

        int temp = a[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && a[right] >= temp)
                right--;
            if (left < right)
                a[left++] = a[right];
            while (left < right && a[left] <= temp)
                left++;
            if (left < right)
                a[right--] = a[left];
        }
        a[left] = temp;

        QuickSort(a, start, left - 1);
        QuickSort(a, left + 1, end);
    }

    //考虑封装
    public static void QuickSort2(int[] a, int start, int end) {
        if (start < end) {
            int pos = partition(a, start, end);
            QuickSort2(a, start, pos - 1);
            QuickSort2(a, pos + 1, end);
        }
    }

    public static int partition(int[] a, int start, int end) {
        int temp = a[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && a[right] >= temp)
                right--;
            if (left < right)
                a[left++] = a[right];
            while (left < right && a[left] <= temp)
                left++;
            if (left < right)
                a[right--] = a[left];
        }
        a[left] = temp;
        return left;
    }

    //双指针
    public static int partition2(int[] a, int start, int end){
        int temp = a[start];
        int left = start;
        int right = end;
        while(left<right){
            while(left<right&&a[right]>=temp)
                right--;
            while(left<right&&a[left]<=temp)
                left++;
            swap(a,left,right);
        }
        swap(a,start,left);
        return left;
    }


    //三分快排
    public static void QuickSort3(int[] a,int start,int end){
        if(start<end){
            int[] pos = partition3(a,start,end);
            QuickSort3(a,start,pos[0]);
            QuickSort3(a,pos[1],end);
        }
    }


    public static int[] partition3(int[] a,int start,int end){
        int temp = a[start];
        int cur = start;
        int left = start - 1;
        int right = end + 1;
        while(cur<right){
            if(a[cur]<temp){
                swap(a,++left,cur++);
            }else if(a[cur]>temp){
                swap(a,cur,--right);
            }else{
                cur++;
            }
        }
        return new int[]{left,right};
    }

    //快速选择
    public static int QuickSelect(int[] a,int start,int end,int k){
        int location = a.length-k;
        if(start<end){
            while(start<end){
                int pos = partition(a,start,end);
                if(pos>location){
                    end = pos-1;
                }else if(pos<location){
                    start = pos+1;
                }else{
                    break;
                }
            }
        }
        return a[location];
    }


    //直接插入排序
    public static void InsertSort(int[] a){
        for(int m = 1;m<a.length;m++){
            int temp = a[m];
            for(int n = m;n>0;n--){
                if(a[n-1]>temp)
                    a[n]=a[n-1];
                else{
                    a[n]=temp;
                    break;
                }
            }
        }
    }


    //折半插入排序
    public static void HalfInsertSort(int[] a){
        for(int m = 1;m<a.length;m++){
            int temp = a[m];
            int left = 0;
            int right = m-1;
            while(left<=right){
                int medium = (left+right)/2;
                if(a[medium]>temp)
                    right = medium-1;
                else if(a[medium]<=temp)
                    left = medium+1;
            }
            for(int k = m-1;k>=left;k++){
                a[k+1]=a[k];
            }
            a[left] = temp;
        }
    }


    //shell排序
    public static void ShellSort(int[] a){
        int gap = a.length/2;
        while(gap > 0){
            for(int k = gap;k<a.length;k++){
                int temp = a[k];
                while(k>=gap){
                    if(temp<a[k-gap]){
                        a[k]=a[k-gap];
                        k-=gap;
                    }
                    else
                        break;
                }
                a[k]=temp;
            }
            gap/=2;
        }
    }


    //归并排序
    public static void GuibingSort(int[] a,int start,int end){
        if(start>=end){
            return;
        }

            int medium =(start+end)/2;
            GuibingSort(a,start,medium);
            GuibingSort(a,medium+1,end);

            GuibingAssist(a, start,end,medium);
    }

    public static void GuibingAssist(int[] a,int start,int end,int medium){
        int[] assist = new int[end-start+1];

        for(int k =0;k<assist.length;k++){
            assist[k]=a[k+start];
        }
        int location = start;
        int point1 = 0;
        int point2 = (assist.length-1)/2+1;
        for(int i=start;i<end+1;i++){
            if(point1+start>medium){
                a[location++]=assist[point2++];
            }else if(point2+start>end){
                a[location++]=assist[point1++];
            }else if(assist[point1]>assist[point2]){
                a[location++]=assist[point2++];
            }else{
                a[location++]=assist[point1++];
            }
        }
    }

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


}
