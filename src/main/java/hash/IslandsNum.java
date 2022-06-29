package hash;

public class IslandsNum {

    public static int getIslandsNum(int[][] matrix){
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0;j < n; j++){
                if (matrix[i][j] == 1){
                    res++;
                    infect(i,j,m,n,matrix);
                }
            }
        }
        return res;
    }

    public static void infect(int i, int j, int m, int n, int matrix[][]){
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != 1){
            return;
        }
        matrix[i][j] = 2;
        infect(i+1,j,m,n,matrix);
        infect(i-1,j,m,n,matrix);
        infect(i,j+1,m,n,matrix);
        infect(i,j-1,m,n,matrix);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1 }, };
        System.out.println(getIslandsNum(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(getIslandsNum(m2));
    }
}
