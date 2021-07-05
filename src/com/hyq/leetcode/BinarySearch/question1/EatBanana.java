package com.hyq.leetcode.BinarySearch.question1;

import java.util.Arrays;

/**
 * @ClassName EatBanana
 * @Description TODO
 * @Author huangyq
 * @Date 2021/4/1 11:00
 * @Version
 **/
public class EatBanana {

    public static int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0)
            return -1;

        int speed = 1;              //初始速度
        Arrays.sort(piles);
        for (; speed <= piles[piles.length - 1]; speed++) {               //对每一种速度情况进行统计
            int count = 0;
            for (int number : piles) {                           //每一堆次数\时间
                if (number % speed == 0)
                    count += number / speed;
                else
                    count += number / speed + 1;
            }
            if (count <= h)                                             //规定时间内吃完
                break;
        }
        return speed > piles[piles.length - 1] ? -1 : speed;
    }

    //二分减少线性查询
    public static int minEatingSpeed2(int[] piles, int h) {
        if (piles == null || piles.length == 0)
            return -1;

        int startSpeed = 1;              //初始速度
        Arrays.sort(piles);
        int endSpeed = piles[piles.length-1];
        while(startSpeed<=endSpeed) {               //对每一种速度情况进行统计
            int midSpeed = startSpeed+(endSpeed-startSpeed)/2;
            int count = 0;
            for (int number : piles) {                           //每一堆次数\时间
                if (number % midSpeed == 0)
                    count += number / midSpeed;
                else
                    count += number / midSpeed + 1;
            }

            if(count>h)
                startSpeed = midSpeed+1;
            else if(count<=h)
                endSpeed = midSpeed-1;

        }
        return startSpeed>piles[piles.length-1]?-1:startSpeed;
    }
}
