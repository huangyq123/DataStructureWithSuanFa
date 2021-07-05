package com.hyq.day14;

/**
 * @ClassName SumOfNumber
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/12 10:22
 * @Version
 **/
public class SumOfNumber {

    //
    public static int[] twoSum2(int[] nums, int target){
        int[] result = new int[2];
        int point1 = 0;
        int point2 = nums.length-1;

        while(point1<point2){
            if((nums[point1]+nums[point2])==target){
                result[0]=nums[point1];
                result[1]=nums[point2];
                break;
            }
            else if((nums[point1]+nums[point2])<target){
                point1++;
            }else
                point2--;
        }
        return result;
    }



    //状态划分错误
    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        int point1 = 0;
        int point2 = nums.length-1;
        int flag = (nums[point1]+nums[point2])>target?0:1;
        while(point1<point2){          //point1只能右移、point2只能左移——？
            if((nums[point1]+nums[point2])==target){
                result[0]=nums[point1];
                result[1]=nums[point2];
                break;
            }
            else if((nums[point1]+nums[point2])<target){
                if(flag==0){
                    point1++;
                    flag=1;
                }else if(flag==1&&point2<nums.length-1){
                    point2++;
                } else if(flag==1&&point2==nums.length-1){
                    flag=0;
                    point1++;
                }
            }
            else{
                if(flag==1){
                    point2--;
                    point1++;
                }else if(flag == 0){
                    point2--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,9,27,35,42,56,65,69,92,97};
        int[] result = twoSum(test, 119);
        System.out.println(result);
    }
}
