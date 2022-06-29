package matrix;

public class ZigZagPrintMatrix {


    public static void zigZagPrint(int[][] matrix){
        int aC = 0;
        int aL = 0;
        int bC = 0;
        int bL = 0;
        boolean downToUp = true;

        int endC = matrix.length - 1;
        int endL = matrix[0].length - 1;

        while (aC <= endC){
            printSingleLine(matrix,aC,aL,bC,bL,downToUp);
            //顺序不能换，需要行列变化前需要根据现有位置变换
            //a，b走之前先判断需不需要拐弯
            aC = aL == endL? aC + 1 : aC;
            aL = aL == endL? aL : aL + 1;
            bL = bC == endC ? bL + 1 : bL;
            bC = bC == endC ? bC : bC + 1;
            downToUp = !downToUp;
        }
    }

    public static void printSingleLine(int[][] matrix, int aC, int aL, int bC, int bL, boolean downToUp){
        if (downToUp){
            while (bC >= aC){
                System.out.println(matrix[bC--][bL++] + " ");
            }
        }else {
            while (aC <= bC){
                System.out.println(matrix[aC++][aL--] + " ");
            }
        }
    }





    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        zigZagPrint(matrix);
    }
}
