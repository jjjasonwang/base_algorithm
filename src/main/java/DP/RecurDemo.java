package DP;

public class RecurDemo {

    /**
     * 汉诺塔问题
     * @param N
     * @param from
     * @param to
     * @param help
     */
    public static void processHanoi(int N, String from, String to, String help){
        if (N == 1){
            System.out.println("Move 1 from " + from + " to " + to);
        }else {
            processHanoi(N - 1, from, help, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            processHanoi(N - 1, help, to, from);
        }
    }

    /**
     * 打印一个字符串子序列
     * @param str
     * @param i
     * @param res
     */
    public static void printSubString(char[] str, int i, String res){
        if (i == str.length){
            System.out.println(res);
            return;
        }
        printSubString(str,i+1,res);
        printSubString(str,i+1,res+String.valueOf(str[i]));
    }

    /**
     * 打印全排列
     * @param str
     * @param i
     */
    public static void printAllSort(char[] str, int i){
        if (i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            printAllSort(str,i+1);
            swap(str, i, j);
        }
    }

    private static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
//        int N = 3;
//        processHanoi(N, "左","右","中");
        String test = "abc";
        printAllSort(test.toCharArray(),0);

    }
}
