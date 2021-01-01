package com.lc.explore.ds.list;

import com.sr.ds.nodes.Node;
import com.sr.ds.list.List;

public class OddEvenList {
    public static void main(String[] args) {
        // Node head = list.getLinkedList(new int[] { 1, 2, 3, 4, 5 });
        // Node head = list.getLinkedList(new int[] { 2, 1, 3, 5, 6, 4, 7 });
        Node head = List.getLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        List.print(oddEvenList(head), "->");
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/">oddEvenList<a>
     * }
     */
    static Node oddEvenList(Node head) {
        Node nextOdd, odd = head, evenStart = head == null ? null : head.next, even = evenStart;

        while (even != null && even.next != null) {
            nextOdd = even.next;
            odd.next = nextOdd;
            even.next = nextOdd.next;
            nextOdd.next = evenStart;

            odd = nextOdd;
            even = even.next;
        }
        return head;
    }
}
