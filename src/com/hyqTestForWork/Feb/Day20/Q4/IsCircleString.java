package com.hyqTestForWork.Feb.Day20.Q4;

/**
 * @ClassName IsCircleString
 * @Description TODO  125. 验证回文串  频度 easy
 * @Author huangyq
 * @Date 2022/2/20 20:38
 * @Version
 **/
public class IsCircleString {

    public boolean isPalindrome(String s) {

        boolean result = true;

        int index=0;
        StringBuilder strB = new StringBuilder();
        while(index<s.length()){
            if(isCharOrDigit(s,index)<0){
                index++;
                continue;
            }
            strB.append(s.charAt(index));
        }


        String newS = strB.toString().toLowerCase();
        int left = 0;
        int right = newS.length()-1;
        while(left<=right){
            if(newS.charAt(left)!=newS.charAt(right)){
                result = false;
                break;
            }
            left++;
            right--;
        }

        return result;
    }

    public int isCharOrDigit(String s,int index){
        char temp = s.charAt(index);
        if(temp<='Z'&&temp>='A'){
            return temp-'A';
        }else if(temp<='z'&&temp>='a'){
            return temp-'a';
        }else if(temp<='9'&&temp>='0'){
            return temp-'0';
        }

        return -1;
    }

}
