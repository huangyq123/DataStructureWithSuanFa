package com.hyq.day12;

/**
 * @ClassName DigitOfNumberSerializable
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/10 8:27
 * @Version
 **/
public class DigitOfNumberSerializable {


    public int findNthDigit(int n) {
        int count = -1;
        int result = -1;

        for (int i = 0; count < n; i++) {
            String tempString = Integer.toString(i);
            int length = tempString.length();
            if ((count + length) < n) {
                count += length;
                continue;
            }

            for (int k = 0; k < length; k++) {
                if ((count + k + 1) == n) {
                    result = tempString.charAt(k) ;
                    break;
                }
            }
            break;

        }
        return result-48;
    }

    public static int findNthDigit2(int n){
        if(n<0)
            return -1;
        if(n<10)
            return n;

        int range = 9;
        int digitLength = 1;
        int length =0;
        while(n>(range*digitLength+length)){
            length+=range*digitLength;
            range*=10;
            digitLength+=1;
        }

        int countLength = n-length;
        int tempResult = 0;
        int leftNumber = countLength%digitLength;
        if(leftNumber==0)
            tempResult = countLength/digitLength-1+((int) Math.pow(10,digitLength-1));
        else
            tempResult = countLength/digitLength+((int) Math.pow(10,digitLength-1));


        String tempString = Integer.toString(tempResult);
        if(leftNumber==0)
            return tempString.charAt(tempString.length()-1) - 48;
        else
            return tempString.charAt(leftNumber-1) -48;

    }

}
