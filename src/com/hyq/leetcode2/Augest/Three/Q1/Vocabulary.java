package com.hyq.leetcode2.Augest.Three.Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Vocabulary
 * @Description TODO 139.单次拆分
 * @Author huangyq
 * @Date 2021/8/3 15:25
 * @Version
 **/
public class Vocabulary {
    //问题：空间占用大； 查找顺序被规定导致会出现错误结果（查找顺序也会影响能否找到）
    public static boolean wordBreak(String s, List<String> wordDict) {
        StringBuffer temp = new StringBuffer(s);
        char[] c = s.toCharArray();
        String tt = new String(c);
        boolean[] status = new boolean[wordDict.size()];

        Arrays.fill(status,false);

        for(int i=0;i<wordDict.size();i++){
            if(s.contains(wordDict.get(i))){
                status[i]=true;
            }
        }

        boolean flag = true;
        boolean end = false;
        int index=0;
        while(!end&&index<wordDict.size()){
            if(!status[index]){
                index++;
                continue;
            }

            int tempIndex = index;
            while(tempIndex<wordDict.size()){
                if(!status[tempIndex]){
                    tempIndex++;
                    continue;
                }
                tt = tt.replaceAll(wordDict.get(tempIndex), " ");
                tempIndex++;
            }
            String trim = tt.trim();
            if(trim.length()==0){
                end = true;
                break;
            }else{
                tt=new String(c);
                index++;
            }
        }

        return end;
    }

   // 解法：动态规划
   public static boolean wordBreak2(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp,false);

        dp[0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j]==true&& wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }

        return dp[dp.length-1];
   }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("cc");
        strings.add("ac");
//        strings.add("sand");
//        strings.add("and");
//        strings.add("cat");

        boolean leetcode = wordBreak2("ccaccc", strings);
        System.out.println(leetcode);
    }
}
