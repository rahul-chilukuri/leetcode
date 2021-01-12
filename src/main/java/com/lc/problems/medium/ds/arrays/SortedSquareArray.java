package com.lc.problems.medium.ds.arrays;

import java.util.Arrays;

public class SortedSquareArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquareArray(new int[] { -7, -3 })));
        // System.exit(0);
        System.out.println(Arrays.toString(sortedSquareArray(new int[] { -7, -3, 2, 3, 11 })));
        System.out.println(Arrays.toString(sortedSquareArray(new int[] { -4, -1, 0, 3, 10 })));
        System.out.println(Arrays.toString(sortedSquareArray(new int[] { -15, -12, -4, -1, 0, 3 })));
        System.out.println(Arrays.toString(sortedSquareArray(new int[] { -1, 0, 3, 4, 7, 8, 10 })));
        System.out.println(Arrays.toString(sortedSquareArray(new int[] { 0, 3, 4, 7, 8, 10 })));
    }

    static int[] sortedSquareArray(int[] arr) {
        int length = arr.length;
        if (arr[0] >= 0) {
            for (int i = 0; i < length; i++)
                arr[i] *= arr[i];
            return arr;
        } else {
            int[] squared = new int[length];
            int j, i = 0, k = 0;
            for (; i < length - 1 && arr[i + 1] < 0; i++);
            j = i + 1;

            while (i > -1 && j < length) {
                if ((-1 * arr[i]) < arr[j]) {
                    squared[k++] = arr[i] * arr[i--];
                } else {
                    squared[k++] = arr[j] * arr[j++];
                }
            }

            while (j < length) {
                squared[k++] = arr[j] * arr[j++];
            }

            while (i > -1) {
                squared[k++] = arr[i] * arr[i--];
            }

            return squared;
        }
    }
}