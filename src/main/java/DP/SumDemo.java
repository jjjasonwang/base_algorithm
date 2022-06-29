package DP;

public class SumDemo {


    public static boolean isSum(int[] arr, int i, int sum, int aim){
        if (i == arr.length){
            return sum == aim;
        }
        return isSum(arr, i+1, sum+arr[i],aim) || isSum(arr,i+1, sum,aim);
    }


    public static void main(String[] args) {
        boolean flag = isSum(new int[]{1,2,3},0,0,9) ;
        System.out.println(flag);
    }
}
