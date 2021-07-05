package com.hyq.day4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName RobatRun
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/1 14:37
 * @Version
 **/
public class RobatRun {

    public static void main(String[] args) {
        movingCount(3,2,17);
    }
   //深度优先——走迷宫问题
    public static int movingCount(int m,int n,int k){
        int count = 0;
        int[] table = new int[m*n];
        int row =0;
        int column = 0;

        count = Run(table, m, n, row, column, k, count);

        return count;
    }

    public static int Run(int[] table,int m,int n,int row,int column,int k,int count){
        if(row<0||column<0||row>=m||column>=n||table[row*n+column]==1)
            return count;

        if((row%10+(row-row%10)/10+column%10+(column-column%10)/10)>k)
            return count;

        //轨迹
        table[row*n+column]=1;
        count+=1;
        //方向
        count = Run(table,m,n,row-1,column,k, count);
        count = Run(table,m,n,row+1,column,k, count);
        count = Run(table,m,n,row,column-1,k, count);
        count = Run(table,m,n,row,column+1,k, count);
        //返回记录信息
        return count;

    }


 //   作者：LeetCode-Solution
    //    链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/ji-qi-ren-de-yun-dong-fan-wei-by-leetcode-solution/
//    来源：力扣（LeetCode）
//该方式使用广度遍历，队列实现
    class Solution {
        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }
            Queue<int[]> queue = new LinkedList<int[]>();
            // 向右和向下的方向数组
            int[] dx = {0, 1};
            int[] dy = {1, 0};
            boolean[][] vis = new boolean[m][n];
            queue.offer(new int[]{0, 0});
            vis[0][0] = true;
            int ans = 1;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 2; ++i) {
                    int tx = dx[i] + x;
                    int ty = dy[i] + y;
                    if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                    ans++;
                }
            }
            return ans;
        }

        private int get(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }


}
