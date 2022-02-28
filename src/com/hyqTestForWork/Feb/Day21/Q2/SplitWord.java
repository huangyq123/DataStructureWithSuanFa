package com.hyqTestForWork.Feb.Day21.Q2;

import java.util.List;

/**
 * @ClassName SplitWord
 * @Description TODO 139. 单词拆分 频度 medium
 * @Author huangyq
 * @Date 2022/2/21 18:58
 * @Version
 **/
public class SplitWord {

    //看题解写的——TODO  重新复习
    //理解：  通过遍历所有字典中的组合作为新字典，使用新字典进行拆分字符串可以实现判断——由于可以暴力，则可以考虑dp
    //  dp想法——组合所有子字典——  问题，难以描述dp状态含义
    //  关键点：既然可以互粉子字典，那么也可以划分子字符串
    public boolean wordBreak(String s, List<String> wordDict){

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1;i<dp.length;i++){
            for(int m =0;m<=i;m++){
                String substring = s.substring(m, i + 1);
                boolean temp = wordDict.contains(substring);
                if(temp&&dp[m]){
                    dp[i]=true;
                    break;
                }
            }
        }


        return dp[dp.length-1];
    }
}
