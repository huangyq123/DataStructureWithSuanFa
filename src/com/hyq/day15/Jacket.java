package com.hyq.day15;

/**
 * @ClassName Jacket
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/14 9:55
 * @Version
 **/
public class Jacket {

    //问题：理清楚判断条件、边界条件；搞清楚判断对象（哪个数组的元素？）
    //空间效率优化
    public static boolean isStraight(int[] nums) {
        int[] flag = new int[14];
        int point1 = 0;
        int point2 = 0;
        int point3 = 0;
        int point4 = 0;
        int point5 = 0;
        for (int i = 0; i < nums.length; i++) {
            flag[nums[i]] += 1;
        }

        boolean result = true;
        int count = 0;
        for (int k = 1; k < flag.length; k++) {
            if (flag[k] >= 2){
                result=false;
                break;
            }
            if (flag[k] == 1)
                switch (count) {
                    case 0:
                        point1 = k;
                        count++;
                        break;
                    case 1:
                        point2 = k;
                        count++;
                        break;
                    case 2:
                        point3 = k;
                        count++;
                        break;
                    case 3:
                        point4 = k;
                        count++;
                        break;
                    case 4:
                        point5 = k;
                        count++;
                        break;
                }
        }

        if(result&&point4==0){
            if((point3-point1)>4)
                result=false;
        }
        else if(result&&point5==0){
            if((point4-point1)>4)
                result=false;
        }else if(result){
        if((point5-point1)>4)
            result=false;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,7,5,9,2};
        boolean r = isStraight(test);
        System.out.println(r);
    }

}
