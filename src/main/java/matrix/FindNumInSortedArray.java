package matrix;

public class FindNumInSortedArray {
    public static boolean findNum(int[][] matrix, int num){
        int aC = 0;
        int aL = 0;
        int bC = matrix.length - 1;
        int bL = matrix[0].length - 1;

        int targetC = aC;
        int targetL = bL;

        while (targetC <= bC && targetL >= 0){
            if (matrix[targetC][targetL] < num){
                targetC++;
            }else if (matrix[targetC][targetL] > num){
                targetL--;
            }else {
                System.out.println(matrix[targetC][targetL]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        boolean flag = findNum(matrix,18);
        System.out.println(flag);
    }




}
