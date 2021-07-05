package com.hyq.day12;

import java.util.HashSet;

/**
 * @ClassName pailieArrayToMinmumNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/10 9:43
 * @Version
 **/
public class pailieArrayToMinmumNumber {


    public static void main(String[] args) {
        int[] test = new int[]{9,6,3,0,7,4,1,8,5,2};
        minNumber(test);
        System.out.println(min);
    }



    static String min ="";

    public static String minNumber(int[] nums){
        Assist(nums,0);
        return min;
    }

    //效率低——多余的排列
    public static void Assist(int[] nums , int position){
        if(position==nums.length-1){
            StringBuffer stringBuffer = new StringBuffer();
            for(int k =0;k<nums.length;k++){
                stringBuffer.append(nums[k]);
            }
            String temp = stringBuffer.toString();
            if(!"".equals(min))
                min = equals(temp,min);
            else
                min = temp;
            return ;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int x = position;x<nums.length;x++){
            if (set.contains(nums[x])) continue;
                swap(nums,position,x);
                Assist(nums,position+1);
                swap(nums,position,x);
            set.add(nums[x]);
        }

    }

    public static void swap(int[] nums,int position,int x){
        int temp = nums[position];
        nums[position]=nums[x];
        nums[x]=temp;
    }

    public static String equals(String str1,String str2){
        int flag =0;
        for(int i =0;i<str1.length();i++){
            if(str1.charAt(i)>str2.charAt(i)){
                flag =2;
                break;
            }else if(str1.charAt(i)<str2.charAt(i)){  //比较大小的实现？
                flag = 1;
                break;
            }
        }
        if(flag==1)
            return str1;
        else
            return str2;
    }


//自定义比较规则
    //比较器使用？
    public static String minNumber2(int[] nums){
        if(nums==null)
            return null;
        if(nums.length==0)
            return "0";

        Sort(nums,0,nums.length-1);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<nums.length;i++){
            stringBuffer.append(nums[i]);
        }
        return stringBuffer.toString();
    }

    public static void Sort(int[] nums,int start, int end){
        if(start<end){
            int position = QuickSort(nums,start,end);
            Sort(nums,start,position-1);
            Sort(nums,position+1,end);
        }
    }

    public static int QuickSort(int[] nums,int start,int end){
        int base = nums[start];
        int left = start;
        int right = end;

        while(left<right){
            while(left<right&&equal(base,nums[right]))
                right--;
            while(left<right&&equal(nums[left],base))
                left++;

            swap(nums,left,right);
        }
        swap(nums,start,left);
        return left;
    }

    public static boolean equal(int numberOne,int numberTwo){
        String str1 = numberOne+""+numberTwo;
        String str2 = numberTwo+""+numberOne;

        boolean result = true;
        for(int k =0;k<str1.length();k++){
            if(str1.charAt(k)<str2.charAt(k)){         //第一个数在左边
                result = true;
                break;
            }
            else if(str1.charAt(k)>str2.charAt(k)){       //第二个数在左边
                result = false;
                break;
            }
        }
        return result;
    }


}
