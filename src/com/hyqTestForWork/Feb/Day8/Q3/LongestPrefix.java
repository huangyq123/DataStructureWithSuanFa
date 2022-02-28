package com.hyqTestForWork.Feb.Day8.Q3;

/**
 * @ClassName LongestPrefix
 * @Description TODO  14. 最长公共前缀  频度 easy
 * @Author huangyq
 * @Date 2022/2/8 21:17
 * @Version
 **/
public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null){
            return null;
        }

        String tempPrefix = strs[0];
        int length = strs[0].length();
        for(int i =1;i< strs.length;i++){
            int tempLength = 0;
            for(int m=0;m<Math.min(length,strs[i].length());m++){
                char c1 = tempPrefix.charAt(m);
                char c2 = strs[i].charAt(m);
                if(c1==c2){
                    tempLength+=1;
                }else{
                    break;
                }
            }

            if(tempLength==0){
                tempPrefix = "";
                break;
            }else{
                tempPrefix = strs[i].substring(0,tempLength);
                length = tempLength;
            }
        }

        return tempPrefix;
    }

    //TODO  二分
}
