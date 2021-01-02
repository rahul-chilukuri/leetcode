package com.lc.explore.ds.list;

import com.base.ds.nodes.Node;
import com.base.ds.list.List;

public class NodeRemoval {

    public static void main(String[] args) {
        testRemoveNthNode();
        testRemoveAll();
    }

    static void testRemoveNthNode() {
        System.out.println("################ REMOVE Nth from HEAD ################");
        Node dHead = List.getLinkedList(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        List.print(dHead, "->");
        List.print(removeNthNodeFromEnd(dHead, 5), "->");
    }

    static void testRemoveAll() {
        System.out.println("################ REMOVE ALL ################");
        Node dHead = List.getLinkedList(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        List.print(dHead, "->");
        // Node dHead = List.getLinkedList(new int[] { 6, 6, 6, 6, 6, 6, 6 });
        List.print(removeAll(dHead, 6), "->");
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/"
     * >Remove Nth node from End<a> }
     */
    static Node removeNthNodeFromEnd(Node head, int n) {
        if (n < 1 || head == null) {
            return head;
        }

        // n cannot be greater than the size of the list
        // so can increment n2 until n > 1 as n2 is already at head
        // To get nth node from last, set a node(n2) at n distance from beginning
        // have another node(n1) start from head and move both n1 and n2 simultaenously
        // When n2 is at last node, n1 is the nth node from end.
        Node n2 = head;
        while (n-- > 1) {
            n2 = n2.next;
        }

        // end of list reached and intended
        // node to be removed is the first one
        if (n2.next == null) {
            return head.next;
        } else {

            // else traverse n2 until the next element is null
            Node prev, n1 = head;
            do {
                prev = n1;
                n1 = n1.next;
                n2 = n2.next;
            } while (n2.next != null);

            prev.next = n1.next;
            return head;
        }
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/">Remove
     * linked list elements<a> }
     */
    static Node removeAll(Node head, int value) {
        Node dummy = new Node(-1, head);
        Node prev = dummy;
        Node node = dummy.next;

        while (node != null) {
            if (node.data == value) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = prev.next;
        }
        return dummy.next;
    }
}
