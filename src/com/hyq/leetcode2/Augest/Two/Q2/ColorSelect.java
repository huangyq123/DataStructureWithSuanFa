package com.hyq.leetcode2.Augest.Two.Q2;

/**
 * @ClassName ColorSelect
 * @Description TODO  75.颜色分类
 * @Author huangyq
 * @Date 2021/8/2 18:02
 * @Version
 **/
public class ColorSelect {

    //思路：双指针头尾遍历，将所有0放到最前面，再将所有1放到0的后面
    //缺点：遍历次数在1-2次之间
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;

//        int start = 0;
        boolean flag = true;
        for(int i=0;i<2;i++){
            while(left<=right){
                if(flag){
                    if(nums[left]!=i){
                        flag=false;
                    }else{
                        left++;
                    }
                }else{
                    if(nums[right]==i){
                        flag=true;
                        int temp = nums[right];
                        nums[right--]=nums[left];
                        nums[left++]=temp;
                    }else{
                        right--;
                    }
                }
            }
            right = nums.length-1;
            flag = true;
        }
    }

    //优化——指针记录尾节点法，使用指针记录 排序好的0\1的最后一个位置，使用第三个指针查找需要交换的值
    public static void sortColors2(int[] nums){
        int ptr0 = 0;
        int ptr1 = 0;
        int ptrFind = 0;

        while(ptrFind<nums.length){
            if(nums[ptrFind]==0){
                int temp = nums[ptrFind];
                nums[ptrFind] = nums[ptr0];
                nums[ptr0] = temp;
                if(ptr0<ptr1){
                    temp = nums[ptrFind];
                    nums[ptrFind] = nums[ptr1];
                    nums[ptr1] = temp;
                }
                ptr0++;
                ptr1++;
            }else if(nums[ptrFind]==1){
                int temp2 = nums[ptrFind];
                nums[ptrFind] = nums[ptr1];
                nums[ptr1] = temp2;
                ptr1++;
            }
            ptrFind++;
        }

    }

    public static void main(String[] args) {
        int[] t = new int[]{2,0,2,1,1,0};
        sortColors2(t);
        for(int i: t){
            System.out.print(i+"  ");
        }
    }
}
