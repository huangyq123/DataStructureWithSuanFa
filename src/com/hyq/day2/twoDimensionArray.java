package com.hyq.day2;

/**
 * @ClassName twoDimensionArray
 * @Description TODO  二维数组查找
 * @Author huangyq
 * @Date 2021/2/25 13:39
 * @Version
 **/
public class twoDimensionArray {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        //int[][] a = new int[0][0];
        twoDimensionArray t = new twoDimensionArray();
        int RowLength = a.length;
        int ColumnLength = a[0].length;
       // boolean b = t.find(a, 16, 0, RowLength - 1, 0, ColumnLength - 1);
        boolean b = t.find2(a, 7, 0, RowLength - 1, 0, ColumnLength - 1);
        System.out.println(b);
    }

    /**
     * @return boolean
     * @Author huangyq
     * @Description TODO 查找方法：从左往右找，找到一个比目标值大的则删除列得到一个新的查找矩阵进行递归查找；
     * 如果一行中都小于目标值则按顺序往下查找；若找到目标值则结束查找；
     * 考虑边界条件：递归时新矩阵可能不存在；
     * @Date 2021/2/25 14:43
     * @Param [array, number, rowStart, rowEnd, columnStart, columnEnd]
     * @Version
     **/
    public boolean find(int[][] array, int number, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        int m = rowStart;
        int n = columnStart;
        boolean result = false;

        if (columnEnd < 0 || rowStart > rowEnd) {
            result = false;
        }

        while (m >= rowStart && m <= rowEnd && n >= columnStart & n <= columnEnd) {
            if (array[m][n] == number) {
                result = true;
                break;
            } else if (array[m][n] > number) {
                columnEnd = n - 1;
                rowStart = m + 1;
                result = find(array, number, rowStart, rowEnd, columnStart, columnEnd);
                break;
            } else if (array[m][n] < number) {
                if (n < columnEnd)
                    n++;
                else if (n == columnEnd) {
                    m++;
                    n = columnStart;
                }
            }
        }

        return result;
    }
/**
 *@Author huangyq
 *@Description TODO   方法：从右上角开始，每次剔除一行或者一列直到找到结果或查找范围为空
 *@Date 2021/2/25 15:09
 *@Param [array, number, rowStart, rowEnd, columnStart, columnEnd]
 *@return boolean
 *@Version
 **/
    public boolean find2(int[][] array, int number, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        boolean result = false;
        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            if (array[rowStart][columnEnd] > number) {
                columnEnd -= 1;
            } else if (array[rowStart][columnEnd] < number) {
                rowStart += 1;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }


    /**
     *@Author huangyq
     *@Description TODO  书本样例——双指针法（区别在于我写的是在主方法中建立数组传递参数，不考虑数组为空）
     *                   时间复杂度：O(mn)，空间复杂度：O(1)
     *@Date 2021/2/25 15:11
     *@Param [array, target]
     *@return boolean
     *@Version
     **/
    public  boolean find1(int[][] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }

        int row = 0;
        int column = array[0].length - 1;
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}

