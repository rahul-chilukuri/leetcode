package com.lc.problems.medium.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] { { 1 } }));
        System.out.println(spiralOrder(new int[][] { { 1, 2 } }));
        System.out.println(spiralOrder(new int[][] { { 1 }, { 2 } }));
        System.out.println(spiralOrder(new int[][] { { 1, 2 }, { 3, 4 } }));
        System.out.println(spiralOrder(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } }));
        System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
        System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int row = 0, column = -1;

        while (true) {
            for (int i = 0; i < n; i++) 
                spiral.add(matrix[row][++column]);

            if (--m == 0) break;
            for (int i = 0; i < m; i++)
                spiral.add(matrix[++row][column]);
            
            if(--n == 0 ) break;
            for (int i = 0; i < n; i++)
                spiral.add(matrix[row][--column]);

            if (--m == 0) break;
            for (int i = 0; i < m; i++)
                spiral.add(matrix[--row][column]);

            if (--n == 0) break;
        }

        return spiral;
    }
}
