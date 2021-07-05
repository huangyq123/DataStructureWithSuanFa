package com.hyq.day3.sort;

/**
 * @ClassName SelectSortTest
 * @Description TODO    选择排序
 * @Author huangyq
 * @Date 2021/2/27 11:18
 * @Version
 **/
public class SelectSortTest {

    public static void main(String[] args) {
        int[] a = new int[]{3,  6, 4, 7, 5,1};
       // DirectSelect(a);
         HeapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }

    }


    public static void HeapSort(int[] a) {
        //int k = a.length/2-1;
        for (int k = a.length / 2 - 1; k >= 0; k--) {
            HeapBuild(a, k, a.length );
        }

        for (int i = 0; i < a.length - 1; i++) {
            swap(a, 0, a.length - 1 - i);
            HeapBuild(a, 0, a.length -1 - i );
        }

    }
/**
 *@Author huangyq
 *@Description TODO
 *@Date 2021/2/27 17:36
 *@Param [array, number, length] length表示已经完成排序的最小索引，需要重建堆的索引最大为length-1
 *@return void
 *@Version
 **/
    public static void HeapBuild(int[] array, int number, int length) {
        int temp = number;
        //int x= array[number];
        int index = temp * 2 + 1;
        while ((temp * 2 + 1) <= length - 1) {
            //index = temp * 2 + 1;方式二，保证index改变
            if (temp * 2 + 2 <= length - 1) {
                if (array[temp * 2 + 1] < array[temp * 2 + 2])
                    index = temp * 2 + 2;
                else
                    index = temp * 2 + 1;

            }

            if (array[index] > array[temp]) {
                swap(array, index, temp);//交换多余
                temp = index;
            }
            //方式二
//            if (array[index] > x) {
//                array[temp] = array[index];
//                temp = index;  //只需要赋值，减少操作，
//            }
            else {
                break;
            }
        }
        //array[temp]=x;//赋值时最后需要对找到的位置赋值；
    }


    //堆排序样例实现
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && arr[k] < arr[k + 1]) {//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }


    /**
     * @return void
     * @Author huangyq
     * @Description TODO   直接选择排序（注意交换效率）
     * @Date 2021/2/27 11:27
     * @Param [a]
     * @Version
     **/
    public static void DirectSelect(int[] a) {
        for (int m = 0; m < a.length - 1; m++) {
            int max = m;
            for (int n = m + 1; n < a.length; n++) {
//                if (a[n] > a[m]) {
//                    swap(a,n,m);//非必要的交换次数过多
//
//                }
                if (a[n] > a[max])
                    max = n;
            }
            swap(a, max, m);//减少交换次数
        }
    }

    public static void swap(int[] a, int numberOne, int numberTwo) {
        int temp = a[numberOne];
        a[numberOne] = a[numberTwo];
        a[numberTwo] = temp;
    }

}
