package com.lc.explore.ds.list;

import com.base.ds.nodes.Node;
import com.base.ds.list.List;

public class MergeSortList {
    public static void main(String[] args) {
        Node n1 = List.getLinkedList(new int[] { 1, 2, 3, 4 });
        Node n2 = List.getLinkedList(new int[] { 1, 2, 5, 6 });
        List.print(merge(n1, n2), "->");
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/">Merge
     * Two sorted lists</a>}
     * 
     * @param n1
     * @param n2
     * @return
     */
    static Node merge(Node n1, Node n2) {
        Node temp, dummy = new Node(-1), node = dummy;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                temp = n1.next;
                node.next = n1;
                n1 = temp;
            } else if (n1.data > n2.data) {
                temp = n2.next;
                node.next = n2;
                n2 = temp;
            } else {
                temp = n1.next;
                node.next = n1;
                node = node.next;
                n1 = temp;

                temp = n2.next;
                node.next = n2;
                n2 = temp;
            }

            node = node.next;
        }

        if (n1 != null) {
            node.next = n1;
        }

        if (n2 != null) {
            node.next = n2;
        }

        return dummy.next;
    }

}
