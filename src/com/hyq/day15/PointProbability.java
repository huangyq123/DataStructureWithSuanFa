package com.hyq.day15;

import java.util.*;

/**
 * @ClassName PointProbability
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/14 8:11
 * @Version
 **/
public class PointProbability {


    public double[] dicesProbability(int n) {
        HashMap map = new LinkedHashMap();
        int count = 0;
        Pailie(map, count, n);
        double total = Math.pow(6,n);

        double[] result = new double[map.size()];
        int index = 0;
        Set<Integer> setOfKey = map.keySet();
        for(int x: setOfKey){
           int temp = (int) map.get(x);
            result[index++]=((double)temp)/total;
        }

//        double[] arr = new double[result.length];
//        Arrays.sort(result);
//
//        for(int i =0; i< result.length;i++)
//            arr[i] =((double)result[result.length-1-i])/total;

         return result;
    }


    public static void Pailie(HashMap<Integer, Integer> map, int count, int number) {
        if (number <= 0) {
            if (!map.containsKey(count))
                map.put(count, 1);
            else
                map.put(count, map.get(count) + 1);
            return;
        }

        for (int k = 1; k <= 6; k++) {
            count += k;
            Pailie(map, count, number - 1);
            count -= k;
        }
    }
}
