package com.lc.problems.medium.ds.strings;

import java.util.Arrays;
import static com.base.utils.InputUtil.sysexit;
import static com.base.utils.InputUtil.sysout;

public class LongestSubstring {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        long fm = Runtime.getRuntime().freeMemory();
        sysout(substrA("dvdf")); // vdf -> 3
        sysout(substrA("abcabcbadbcb")); // cbad -> 4
        sysout(substrA("abcabcbb")); // abc -> 3
        sysout(substrA("abcabcdabcde")); // acbde -> 5
        sysout(substrA("abcabcdaecbd")); // bcdae daecb -> 5
        sysout(substrA("abcabcd")); // abcd -> 4
        sysout(substrA("abcabc")); // abc -> 3
        sysout(substrA("pwwkew")); // wke -> 3
        sysout(substrA("bbbbb")); // b -> 1
        sysout(substrA(" "));
        sysout(substrA(""));
        sysout((fm - Runtime.getRuntime().freeMemory()) / (1024));
        sysout(System.currentTimeMillis() - s);
        sysexit();
    }

    public static int substrA(String s) {
        int[] charset = new int[128];
        int chr = 0, i = 0, pos = 0, count = 0, max = 0, len = s.length();

        while (i < len) {
            chr = s.charAt(i);
            pos = charset[chr];
            if (pos > 0) {
                max = Math.max(max, count);
                Arrays.fill(charset, 0);
                i = pos;
                count = 0;
            } else {
                charset[chr] = ++i;
                count++;
            }
        }

        // if the last character was not encountered previously
        return Math.max(count, max);
    }

    // similar implementation to substrB
    public static int substrB(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    static public int substrC(String s) {
        int[] count = new int[128];
        int start = 0, end = 0, max = 0, cur = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            count[c]++;
            cur++;
            while (count[c] > 1) {
                count[s.charAt(start)]--;
                start++;
                cur--;
            }
            max = Math.max(max, cur);
            end++;
        }
        return Math.max(max, cur);
    }
}
