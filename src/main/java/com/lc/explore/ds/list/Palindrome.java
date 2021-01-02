package com.lc.explore.ds.list;

import com.base.ds.nodes.Node;
import com.base.ds.list.List;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] {})));
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] { 1 })));
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] { 1, 1 })));
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] { 1, 2 })));
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] { 1, 3, 1, 1 })));
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] { 1, 1, 3, 1 })));
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] { 1, 2, 2, 1 })));
        System.out.println("is list palindrome " + isPalindrome(List.getLinkedList(new int[] { 1, 2, 3, 2, 1 })));
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/">Palindrome<a>
     * }
     */
    static boolean isPalindrome(Node head) {
        Node slow = head, fast = head, prev = null, temp;

        // splitting this head list into two
        // one starts at the middle
        // the other one starts at middle and points backward
        while (fast != null) {
            if (fast.next == null) {
                slow = slow.next;
                break;
            }

            fast = fast.next.next;
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        while (slow != null && prev != null) {
            if (slow.data != prev.data) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return slow == null && prev == null;
    }
}
