package com.hyq.leetcode2.june.fifteen;

/**
 * @ClassName Rain
 * @Description TODO  接雨水 42
 * @Author huangyq
 * @Date 2021/6/15 19:00
 * @Version
 **/
public class Rain {

    public static int trap(int[] height) {

        //对撞指针起始位置
        int left  =0;
        int right = height.length-1;

        //起始高度
        int high=1;
        int result = 0;
        //对撞判断
        while(left<right){
            //寻找左侧指针位置—— 左侧最低处
            while(left<height.length&&height[left]<high){
                left++;
            }
            //寻找右侧指针位置—— 右侧最低处
            while(right>=0&&height[right]<high){
                right--;
            }

            //保证符合条件
            if(left>=right){
                break;
            }else{
                //开始统计数量，每次增量为1就循环一轮
                for(int k =left;k<=right;k++){
                    if(height[k]<high){
                        result+=1;
                    }
                }
            }
            //准备下一轮对撞
            high+=1;
        }

        return result;
    }//有一个用例超时

    //优化
    public static int trap2(int[] height) {

        //对撞指针起始位置
        int left  =0;
        int right = height.length-1;

        //起始高度
        int high=0;
        int result = 0;
        //对撞判断
        while(left<right){
            //寻找左侧指针位置—— 左侧最低处
            while(left<height.length&&height[left]<=high){
                left++;
            }
            //寻找右侧指针位置—— 右侧最低处
            while(right>=0&&height[right]<=high){
                right--;
            }

            //保证符合条件
            if(left>=right){
                break;
            }else{
                //开始统计数量,优化：每次按找到的最低高度来计算增量，减少循环次数
                for(int k =left;k<=right;k++){
                    int temp = Math.min(height[left],height[right]);
                    if(height[k]<temp){
                        result+=(temp-Math.max(height[k],high));
                    }
                }
            }
            //准备下一轮对撞
            high=Math.min(height[left],height[right]);
        }

        return result;
    }//通过所有用例     时间复杂度：最差：0(n2)  最好O(n)

    public static void main(String[] args) {
        int[] test = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] test = new int[]{4,2,0,3,2,5};

        int trap = trap2(test);
        System.out.println(trap);
    }
}
