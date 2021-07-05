package com.hyq.leetcode2.june.sixteen;

/**
 * @ClassName CommonSequence
 * @Description TODO
 * @Author huangyq
 * @Date 2021/6/16 17:06
 * @Version
 **/
public class CommonSequence {

    //看题解作出来的 而且还不是很理解状态转移 需要理解；
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1==null||text2==null){
            return 0;
        }

        //准备存储矩阵
        int[][] memory = new int[text1.length()+1][text2.length()+1];
        //初始化边界值
        for(int i=0;i<memory.length;i++){
            memory[i][0]=0;
        }
        for(int k=0;k<memory[0].length;k++){
            memory[0][k]=0;
        }

        //开始赋值，进行状态转移
        for(int m=1;m<memory.length;m++){
            for(int n=1;n<memory[0].length;n++){
                dp(memory, text1, m, text2, n);
            }
        }


        //返回结果
        return memory[text1.length()][text2.length()];
    }

    public static void dp(int[][] memory,String s1,int i,String s2,int j){
        //某一个字符串已经遍历完毕
        if(i>=s1.length()||j>=s2.length()){
            return ;
        }

        //状态转移，当前字符相同
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            memory[i][j]=memory[i-1][j-1]+1;
        }
        //当前字符不同
        else{
            memory[i][j]=Math.max(memory[i][j-1],memory[i-1][j]);
        }
        return ;
    }

    public static void main(String[] args) {
        int i = longestCommonSubsequence("abcde", "ace");
    }
}
