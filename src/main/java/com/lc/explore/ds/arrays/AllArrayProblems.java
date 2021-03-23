package com.lc.explore.ds.arrays;

import java.util.Arrays;

import com.base.ds.heap.HeapArrImpl;
import com.base.utils.InputUtil;

public class AllArrayProblems {
    public static void main(String[] args) {
        // testReverseInPlace();
        // testMissingNumberInRange();
        // testUnique();
        // testKthValue();
        testMedian();
    }

    static void testReverseInPlace() {
        // reverse(new int[] { 1 });
        // reverse(new int[] { 1, 2 });
        // reverse(new int[] { 1, 2, 3 });
        // reverse(new int[] { 1, 2, 3, 4, 5 });
        // reverse(new int[] { 1, 2, 3, 4, 5, 6 });
        reverse(InputUtil.getIntArray(15));
    }

    static void testMissingNumberInRange() {
        getMissingNumberInArray(5);
        getMissingNumberInArray(10);
    }

    static void testUnique() {
        printUnique(new int[] { 1 });
        printUnique(new int[] { 1, 1 });
        printUnique(new int[] { 1, 1, 2 });
        printUnique(new int[] { 1, 1, 2, 2, 3 });
    }

    static void testKthValue() {
        int n = 10;
        int[] arr = InputUtil.getIntArray(n);
        InputUtil.print(arr);

        int k = (int) (10 * Math.random());
        // int[] arr = new int[] { 2, 1, 3, 0, 2, 5, 5, 6, 3, 9 };
        // int k = 4;
        findKthLargest(arr, k);
        findKSmallest(arr, n - k);

        findKthLargest(arr, n - k);
        findKSmallest(arr, k);
        Arrays.sort(arr);
        InputUtil.print(arr);
    }

    static void testMedian() {
        InputUtil.print(String.format("findMedianOfSortedArrays(new int[] {}, new int[] {}) => %.2f",
                findMedianOfSortedArrays(new int[] {}, new int[] {})));
        InputUtil.print(String.format("findMedianOfSortedArrays(new int[] {1}, new int[] {}) => %.2f",
                findMedianOfSortedArrays(new int[] { 1 }, new int[] {})));
        InputUtil.print(String.format("findMedianOfSortedArrays(new int[] {}, new int[] {1}) => %.2f",
                findMedianOfSortedArrays(new int[] {}, new int[] { 1 })));
        InputUtil.print(String.format("findMedianOfSortedArrays(new int[] {9}, new int[] {1}) => %.2f",
                findMedianOfSortedArrays(new int[] { 9 }, new int[] { 1 })));
        InputUtil.print(String.format("findMedianOfSortedArrays(new int[] {1,4,15,27}, new int[] {19}) => %.2f",
                findMedianOfSortedArrays(new int[] { 1, 4, 15, 27 }, new int[] { 19 })));
        InputUtil.print(String.format("findMedianOfSortedArrays(new int[] {1, 4, 15, 18, 27 },new int[]{19})=>%.2f",
                findMedianOfSortedArrays(new int[] { 1, 4, 15, 18, 27 }, new int[] { 19 })));
        InputUtil.print(String.format(
                "findMedianOfSortedArrays(new int[] {1, 14, 15, 18, 27 }, new int[] {2,3,4,5,7, 8}) => %.2f",
                findMedianOfSortedArrays(new int[] { 1, 14, 15, 18, 27 }, new int[] { 2, 3, 4, 5, 7, 8 })));

    }

    static void reverse(int[] arr) {
        int t, n = arr.length;
        InputUtil.print(arr);
        for (int i = 0; i < n / 2; i++) {
            t = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = t;
        }
        InputUtil.print(arr);
    }

    static void getMissingNumberInArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int rIdx;
        do {
            rIdx = (int) (Math.random() * n);
        } while (rIdx == 0);
        arr[rIdx] = 0;

        int expected = (n * (n + 1)) >> 1;
        int actual = 0;
        for (int i : arr) {
            actual += i;
        }
        InputUtil.print(arr);
        InputUtil.print("Missing number is " + (expected - actual));
    }

    static void printUnique(int[] arr) {
        InputUtil.print(arr);
        int d = 0;
        for (int i : arr) {
            d ^= i;
        }
        System.out.println("Unique " + d);
    }

    private static double findMedianOfSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            return findMedianOfSortedArrays(b, a);
        }

        int m = a.length, n = b.length;
        int low = 0, high = m;
        int total = m + n;
        while (low <= high) {
            int posX = (low + high) / 2;
            int posY = (total + 1) / 2 - posX;

            InputUtil.print(String.format("posX, posY is (%d, %d)", posX, posY));

            int la = getMax(a, posX);
            int ra = getMin(a, posX);

            int lb = getMax(b, posY);
            int rb = getMin(b, posY);

            if (la > rb) {
                high = posX - 1;
            } else if (lb > ra) {
                low = posX + 1;
            } else {
                if ((total & 1) == 0) {
                    return (Math.max(la, lb) + Math.min(ra, rb)) / 2;
                }
                return Math.max(la, lb);
            }
        }
        return 0;
    }

    private static int getMax(int[] nums, int pos) {
        if (pos == 0) {
            return Integer.MIN_VALUE;
        } else {
            return nums[pos - 1];
        }
    }

    private static int getMin(int[] nums, int pos) {
        if (pos == nums.length) {
            return Integer.MAX_VALUE;
        } else {
            return nums[pos];
        }
    }

    static void findKSmallest(int[] arr, int k) {
        findKthValue(arr, k, false);
    }

    static void findKthLargest(int[] arr, int k) {
        findKthValue(arr, k, true);
    }

    static void findKthValue(int[] arr, int k, boolean largest) {
        int i = 0;
        int[] heap = new int[k];

        while (i < k) {
            heap[i] = arr[i++];
        }

        if (largest) {
            HeapArrImpl.minHeap(heap);
        } else {
            HeapArrImpl.maxHeap(heap);
        }

        while (i < arr.length) {
            if (largest) {
                if (arr[i] > heap[0]) {
                    heap[0] = arr[i];
                    HeapArrImpl.minHeap(heap);
                }
            } else {
                if (arr[i] < heap[0]) {
                    heap[0] = arr[i];
                    HeapArrImpl.maxHeap(heap);
                }
            }
            i++;
        }
        InputUtil.print(String.format("%d %s is %d", k, largest ? "largest" : "smallest", heap[0]));
    }

    public static boolean isPalindrome(int n) {
        if (n < 0 || (n != 0 && n % 10 == 0)) {
            return false;
        }

        int x = 0;
        while (x < n) {
            x *= 10;
            x += n % 10;
            n /= 10;
        }
        return x == n ? true : n == x / 10;

    }
}