package com.hyq.leetcode2.june.fifteen;

/**
 * @ClassName SquareOfX
 * @Description TODO  x的平方根  69
 * @Author huangyq
 * @Date 2021/6/15 19:57
 * @Version
 **/
public class SquareOfX {

    public static int mySqrt(int x) {

        //边界考虑不仔细—— x=1 ;  i*i=x ;  i*i<x (i+1)*(i+1)>int_max ;
        int result=0;
        for(int i=0;i<=x;i++){
            int temp=i*i;
            if(temp>x||temp<0){
                result=i-1;
                break;
            }else if(temp==x){
                result=i;
                break;
            }
        }
        return result;
    }  //时间效率太低

    //优化——二分法求解  注意标准的中间值取法 l+(r-l)/2;注意结束条件;注意分类情况
    public static int mySqrt2(int x) {

        int result=0;
        int left = 0;
        int right=x;
        while(left<=right){
            int temp=((left+(right-left)/2));
           if((long) temp*temp<=x){
               result=temp;
               left = (left+right)/2+1;
           }else if((long) temp*temp >x){
               right = (left+right)/2-1;
           }
        }
        return result;

//        int l = 0, r = x, ans = -1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if ((long) mid * mid <= x) {
//                ans = mid;
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return ans;

    }


    //1、一定注意判断边界条件；
    //2、注意int等数值类型的越界问题
    //3、顺序查找注意使用二分法
    //4、二分法套路

    //拓展 ： 牛顿迭代求零点
    public int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }



    public static void main(String[] args) {
        int i = mySqrt2(2147483647);
        System.out.println(i);
//        System.out.println(mySqrt(8));
//        System.out.println(46340*46340);
    }

}
