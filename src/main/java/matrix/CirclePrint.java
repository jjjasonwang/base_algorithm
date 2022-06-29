package matrix;

public class CirclePrint {
    public static void circlePrint(int[][] matrix){
        int aL = 0;
        int aC = 0;
        int bL = matrix[0].length - 1;
        int bC = matrix.length - 1;
        while (aL <= bL && aC <= bC){
            singleCirclePrint(matrix,aL++,aC++,bL--,bC--);
        }
    }

    public static void singleCirclePrint(int[][] matrix, int aL, int aC, int bL, int bC){
        if (aL == bL && aC != bC){
            for (int i = aC; i <= bC; i++){
                System.out.println(matrix[i][aL] + " ");
            }
        }else if (aL != bL && aC == bC){
            for (int i = aL; i < bL; i++){
                System.out.println(matrix[aC][i] + " ");
            }
        }else if (aL != bL && aC != bC){
            for (int i = aL; i <= bL - 1; i++){
                System.out.println(matrix[aC][i] + " ");
            }

            for (int i = aC; i <= bC - 1; i++){
                System.out.println(matrix[i][bL] + " ");
            }

            for (int i = bL; i >= aL + 1; i--){
                System.out.println(matrix[bC][i] + " ");
            }

            for (int i = bC; i >= aC + 1;i--){
                System.out.println(matrix[i][aL] + " ");
            }
        }else {
            System.out.println(matrix[aC][aL]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,5},{4,5,6,6},{7,8,9,6},{8,8,8,8}};
        circlePrint(matrix);
    }


}
