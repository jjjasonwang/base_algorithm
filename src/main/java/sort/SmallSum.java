package sort;

import java.util.HashMap;
import java.util.Map;

public class SmallSum {


    public static void MergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        MergeSortProcess(arr, 0, arr.length - 1);
    }

    public static void MergeSortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        MergeSortProcess(arr, l, mid);
        MergeSortProcess(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];

            } else {
                for (int k = p1; k < m+1; k++) {
                    System.out.printf("%d,%d", arr[k], arr[p2]);
                }
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        MergeSort(arr);
    }
}
