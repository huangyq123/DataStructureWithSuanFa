package com.hyqTestForWork.Feb.Day7.Q3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName MaxNum
 * @Description TODO 179  最大数  频度 medium
 * @Author huangyq
 * @Date 2022/2/7 9:47
 * @Version
 **/
public class MaxNum {
    //思路——排序，对于相同开头的数字，两数拼接判断顺序（证明先忽略，但是能保证正确性）；
    //  细节：  注意 comparator 的返回值对排序结果的影响；   注意边界——以 0 开头；  对象类使用equals判断
    public String largestNumber(int[] nums) {

        //这里转为Integer 更省空间
        String[] memory = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            memory[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(memory, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0)!=o2.charAt(0)){
                    return -o1.charAt(0)+o2.charAt(0);
                }else{
                    String s1 = o1+o2;
                    String s2 = o2+o1;
                    return s1.compareTo(s2)<=0?1:-1;
                }
            }
        });

        if("0".equals(memory[0])){
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<memory.length;i++){
            stringBuilder.append(memory[i]);
        }

        return stringBuilder.toString();
    }

    @Test
    public void Test(){
        int[] test = new int[]{10,2};
        largestNumber(test);
    }
}
