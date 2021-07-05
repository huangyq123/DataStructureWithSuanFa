package com.hyq.day4;

/**
 * @ClassName ReverseArrayFind
 * @Description TODO  旋转数组查找
 * @Author huangyq
 * @Date 2021/3/1 8:46
 * @Version
 **/
public class ReverseArrayFind {
    public static void main(String[] args) {
        int[] a = new int[]{10,1,10,10,10};
        System.out.println(BinaryFind(a));
    }


    //大小判断方式
    public static int Find(int[] array){
        int temp = array[0];
        int index = 0;
        for(int i =1;i<array.length;i++){
            if(temp>array[i]){
                index = i;
                break;
            }
        }
        return array[index];
    }

    //二分查找方式
    /**
     *@Author huangyq
     *@Description TODO  书本思路实现：将数组二分，根据三个值（首、尾、中）判断下一次查找数组
     *                        应该是左子数组还是右子数组，进行循环查找。考虑到重复元素会导致无法判断，
     *                        因此三值相等则进行顺序查找。
     *@Date 2021/3/1 9:46
     *@Param [numbers]
     *@return int
     *@Version
     **/
    public static int BinaryFind(int[] numbers){
        int point1 = 0;
        int point2 = numbers.length-1;
        int medium = 0;
        if(numbers[point1]<numbers[point2]){
            return numbers[medium];
        }
        while(point1+1<point2){
            medium = (point1+point2)/2;
            if(numbers[point1]==numbers[medium]&&numbers[point2]==numbers[medium]){
                point2 = find(numbers,point1,point2);
                break;
            }
            else if(numbers[point1]<=numbers[medium])
                point1 = medium;
            else if(numbers[point2]>=numbers[medium])
                point2 = medium;
        }
        return numbers[point2];
    }

    public static int find(int[] a,int left,int right) {
        int temp = a[left];
        int index = left;
        for (int i = left + 1; i < right; i++) {
            if (temp > a[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

//leetcode題解
    /*根据中间值与右边界进行比较来确定变化：小则选择去掉右边界(保留中间值），
    大则去掉左边界（包括中间值)，相等则可以缩小右边界
         */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-by-leetcode-s/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
