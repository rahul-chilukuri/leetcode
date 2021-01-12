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
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;

        while (start < n) {
            int row = start, column = start;
            // print left to right on first row
            while (column < n)
                spiral.add(matrix[row][column++]);

            // column=n-1
            column--;

            // if cant go down, nothing to loop further
            row = start + 1;
            if (row >= m) {
                break;
            }

            // print top to bottom on last column
            while (row < m)
                spiral.add(matrix[row++][column]);

            row--; // row=m-1
            column--;// column=n-2

            // if nothing to go towards left
            if (column < start) {
                break;
            }

            // print right-1 to left on last row
            while (column >= start)
                spiral.add(matrix[row][column--]);

            column++;// column=start
            row--;// row=m-2

            // nothing to go up
            if (row <= start) {
                break;
            }

            // print bottom-1 to start+1
            while (row > start)
                spiral.add(matrix[row--][column]);

            m--;
            n--;
            start++;
        }

        return spiral;
    }
}
