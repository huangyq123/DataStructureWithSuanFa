package com.hyq.day8;

/**
 * @ClassName spiraPrint
 * @Description TODO
 * @Author huangyq
 * @Date 2021/3/5 9:53
 * @Version
 **/
public class spiraPrint {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] r = spiralOrder(test);
    }

//注意边界条件
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null)
            return null;
        if(matrix.length==0||matrix[0].length==0)
            return new int[]{};

        int[] result = new int[matrix.length*matrix[0].length];
        int[] r = new int[]{matrix.length,matrix[0].length,0,0,1,-1};
        while(r[1]!=0&&r[0]!=0){
            r = add(matrix,result,r[0],r[1],r[2],r[3],r[4],r[5]);
        }
        return result;
    }

    public static int[] add(int[][] matrix, int[] result,int rows, int columns,int startRow,int startColumn,int flag,int index){
        int[] r = new int[6];
        if(flag == 1){
            for(int i = startColumn;i<startColumn+columns;i++)
                result[++index] = matrix[startRow][i];
            r[0]=rows-1;
            r[1]=columns;
            r[2]=startRow+1;
            r[3]=startColumn+columns-1;
            r[4]=2;
        }else if(flag ==2){
            for(int i = startRow;i<startRow+rows;i++)
                result[++index] = matrix[i][startColumn];
            r[0]=rows;
            r[1]=columns-1;
            r[2]=startRow+rows-1;
            r[3]=startColumn-1;
            r[4]=3;
        }else if(flag==3){
            for(int i =startColumn;i>startColumn-columns;i--)
                result[++index] = matrix[startRow][i];
            r[0]=rows-1;
            r[1]=columns;
            r[2]=startRow-1;
            r[3]=startColumn-columns+1;
            r[4]=4;
        } else if (flag == 4) {
            for(int i = startRow;i>startRow-rows;i--)
                result[++index] = matrix[i][startColumn];
            r[0]=rows;
            r[1]=columns-1;
            r[2]=startRow-rows+1;
            r[3]=startColumn+1;
            r[4]=1;
        }
        r[5]=index;

        return r;
    }
}
