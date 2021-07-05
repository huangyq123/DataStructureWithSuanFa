package com.hyq.day13;

/**
 * @ClassName ReverseCouple
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/11 10:36
 * @Version
 **/
public class ReverseCouple {

    public static void main(String[] args) {
        int[] test = new int[]{7,6,5,4};
        int result = countReverseCouple2(test);
        System.out.println(result);
    }

    static int count = 0;
    //归并思想统计
    //问题：优化思路，怎么考虑到该方法？
       //   书写细节
    public static int countReverseCouple2(int[] nums){

        guiBing(nums,0,nums.length-1);
        return count;
    }

    public static void guiBing(int[] nums,int start,int end){
        if(start>=end)
            return ;

        int medium = (start+end)/2;
        guiBing(nums,start,medium);
        guiBing(nums,medium+1,end);

        int[] assist = new int[end-start+1];
        for(int i =0;i<assist.length;i++){
            assist[i]=nums[i+start];
        }

        int point1 = medium-start;
        int point2 = end-start;
        int point3 = end;
        while(point3>=start){
            if(point1<0){
                nums[point3--]=assist[point2--];
            }
            else if(point2<medium+1-start){
                nums[point3--]=assist[point1--];
            }
            else if(assist[point1]>assist[point2]){
                count+=(point2-medium+start);
                nums[point3--] = assist[point1--];
            }else if(assist[point1]<=assist[point2]){
                nums[point3--] = assist[point2--];
            }
        }
        return ;
    }



    //冒泡统计逆序对，时间效率过低
    public static int countReverseCouple(int[] nums){
        int count = 0;
        boolean flag = false;
        for(int m =0;m<nums.length-1;m++){
            for(int n =0;n<nums.length-1-m;n++){
                if(nums[n]>nums[n+1]){
                    swap(nums,n,n+1);
                    count++;
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
        return count;
    }

    public static void swap(int[] nums , int left, int right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right] = temp;
    }
}
