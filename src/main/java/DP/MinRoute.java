package DP;

public class MinRoute {

    public static int walk(int[][] matrix, int i, int j){
        if (i == matrix.length - 1 && j == matrix[0].length - 1){
            return matrix[i][j];
        }
        if (i == matrix.length - 1){
            return matrix[i][j] + walk(matrix,i,j+1);
        }
        if (j == matrix[0].length - 1){
            return matrix[i][j] + walk(matrix,i+1,j);
        }

        //当前位置向右一位到达右下角的最小代价
        int right = walk(matrix,i,j+1);
        //当前位置向下一位到达右下角的最小代价
        int down = walk(matrix,i+1,j);

        return matrix[i][j] + Math.min(right,down);
    }

    public static void main(String[] args) {

    }

}
