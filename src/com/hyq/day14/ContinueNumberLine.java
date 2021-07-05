package com.hyq.day14;

import java.util.ArrayList;

/**
 * @ClassName ContinueNumberLine
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/12 11:51
 * @Version
 **/
public class ContinueNumberLine {

    public static int[][] getTnstance(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        int medium = (target % 2 == 0) ? (target / 2) : (target / 2 + 1);
        int start = 1;
        int count = 0;
        int end = 1;
        while (end <= medium) {
            if ((count + end) < target) {
                count += end;
                end++;
            } else if ((count + end) > target) {
                count -= start;
                start += 1;
            } else {
                count += end;
                int[] temp = new int[end - start + 1];
                for (int t = start; t <= end; t++)
                    temp[t - start] = t;
                result.add(temp);

                count -= start;
                start += 1;
                end++;
            }
        }

//        int[][] trueResult = new int[result.size()][];
//        for(int i =0 ; i<trueResult.length;i++)
//            trueResult[i]=result.get(i);
//
//        return trueResult;
        return result.toArray(new int[0][]);
    }
}
