package com.hyq.leetcode2.june.fifteen;

import javax.management.StandardEmitterMBean;

/**
 * @ClassName longRepeatedArray
 * @Description TODO  最长重复子数组  718
 * @Author huangyq
 * @Date 2021/6/15 20:44
 * @Version
 **/
public class longRepeatedArray {

    public static int findLength(int[] nums1, int[] nums2) {

//        int position1=0;
//        int position2=0;
//
//        int length1=0;
//        int length2=0;
//
//        int result=0;
//
//        for(int i=0;i<nums1.length;i++){
//            for(int k=0;)
//        }

        StringBuffer s1=new StringBuffer();
        for(int i=0;i<nums1.length;i++){
            s1.append(nums1[i]+"-");
        }
      //  s1.substring(0,s1.length()-1);


        StringBuffer s2=new StringBuffer();
        for(int i=0;i<nums2.length;i++){
            s2.append(nums2[i]+"-");
        }
        //s2.substring(0,s2.length()-1);


        int left=0;
        int right=1;
        int start=0;
        int end=0;
        int length=0;
        int result=0;
        String temp=null;
        if(s1.length()>=s2.length()){
            while(right<=s2.length()){
                if(s1.indexOf(s2.substring(left,right))>=0){
                    if(length<right-left){
                        length=right-left;
                        start=left;
                        end=right;
                    }
                    right++;
                }else{
                    left++;
                    right=Math.max(right,left+1);
                }
            }
            temp = s1.substring(start,end);
        }else{
            while(right<=s1.length()){
                if(s2.indexOf(s1.substring(left,right))>=0){
                    if(length<right-left){
                        length=right-left;
                        start=left;
                        end=right;
                    }
                    right++;
                }else{
                    left++;
                    right=Math.max(right,left+1);
                }
            }
            temp = s2.substring(start,end);
        }
        if(!temp.endsWith("-")){
            return 0;
        }

        for(int k=0;k<temp.length();k++){
            if(temp.charAt(k)=='-'){
                result+=1;
            }
        }
        if(temp.startsWith("-")){
            result-=1;
        }


        return  result;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{16,33,14,2,98};
        int[] test2 = new int[]{55,24,97,50,38};
        int length = findLength(test1, test2);
        System.out.println(length);
    }
}
