package com.lc.explore.ds.list;

import com.base.ds.nodes.Node;
import com.base.ds.list.List;

public class MergeSortList {
    public static void main(String[] args) {
        Node n1 = List.getLinkedList(new int[] { 1, 2, 3, 4 });
        Node n2 = List.getLinkedList(new int[] { 1, 2, 5, 6 });
        List.print(merge(n1, n2));
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/">Merge
     * Two sorted lists</a>}
     * 
     * @param l1
     * @param l2
     * @return
     */
    static Node merge(Node l1, Node l2) {
        Node dummy = new Node(-1), node = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }

            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
