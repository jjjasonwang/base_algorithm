package matrix;

public class RotateMatrix {

    public static void rotateMatrix(int[][] matrix){
        int aC = 0;
        int aL = 0;
        int bC = matrix.length - 1;
        int bL = matrix[0].length - 1;

        while (aC < bC){
            singleRotate(matrix,aC++,aL++,bC--,bL--);
        }
    }

    public static void singleRotate(int[][] matrix, int aC, int aL, int bC, int bL){
        int times = bL - aL;
        for (int i = 0; i < times; i++){
            //此处不可对变量使用++，++会改变同一次for循环中下一次变量出现时的值，导致数组越界
            int temp = matrix[aC][aL+i];
            matrix[aC][aL+i] = matrix[bC-i][aL];
            matrix[bC-i][aL] = matrix[bC][bL-i];
            matrix[bC][bL-i] = matrix[aC+i][bL];
            matrix[aC+i][bL] = temp;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(matrix);

        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//1 2 3
//4 5 6
//7 8 9


//7 4 1
//8 5 2
//9 6 3



