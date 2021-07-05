package com.hyq.day14;

/**
 * @ClassName ReverseOrderOfVacabulary
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/12 13:51
 * @Version
 **/
public class ReverseOrderOfVocabulary {


    public static String ReverseVocabulary(String s){
        if(s==null)
            return null;
        if(s.length()==0)
            return "";

        int low = s.length()-1;
        int high = low ;

        StringBuffer temp= new StringBuffer();

        while(low>=0&&high>=0){
            if(s.charAt(high)==' '){
                high--;
                continue;
            }

            low = high;
            while(low>=0&&s.charAt(low)!=' ')       //边界考虑
                low--;

            temp.append(s.substring(low+1,high+1)+" ");
            high = low;
        }

        String result = temp.toString();
        return result.trim();
    }
}
