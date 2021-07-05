package com.hyq.day6;

/**
 * @ClassName zhengZe
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/3 8:42
 * @Version
 **/
public class zhengZe {

    //
    public static boolean CompareString(String str1, String str2) {
        int m = str1.length()+1;
        int n = str2.length()+1;
        int[][] result = new int[m][n];

        for (int row = 1; row < m; row++) {
            for (int column = 1; column < n; column++) {
//                if (row == 0 && column == 0)
//                    result[row][column] = 1;
//                else if (row == 0) {
//                    if (column == 1 && str2.charAt(column - 1) == '*')
//                        result[row][column] = 1;
//                    if (column > 1 && str2.charAt(column - 1) == '*')
//                        result[row][column] = result[row][column - 2];
//                }

                if (str2.charAt(column - 1) == '*') {
                    if (result[row][column - 2] == 1)
                        result[row][column] = 1;
                    else if (str1.charAt(row - 1) == str2.charAt(column - 2) && result[row - 1][column] == 1)
                        result[row][column] = 1;
                    else if (str2.charAt(column - 2) == '.' && result[row - 1][column] == 1)
                        result[row][column] = 1;
                } else {
                    if (str1.charAt(row - 1) == str2.charAt(column - 1) && result[row - 1][column - 1] == 1)
                        result[row][column] = 1;
                    else if (str2.charAt(column - 1) == '.' && result[row - 1][column - 1] == 1)
                        result[row][column] = 1;
                }

            }
        }

        if (result[m-1][n-1] == 0)
            return false;
        else
            return true;
    }
}
