package com.lc.explore.ds.list;

import java.util.ArrayDeque;
import java.util.Deque;

import com.base.ds.list.List;
import com.base.ds.nodes.Node;

public class FlattenDoubleLinkedList {

    private static Node getHeadNode() {
        Node l6 = List.getDoubleLinkedList(new int[] { 16, 17 });
        Node l5 = List.getDoubleLinkedList(new int[] { 14, 15 });
        Node l4 = List.getDoubleLinkedList(new int[] { 11, 12, 13 });
        Node l3 = List.getDoubleLinkedList(new int[] { 9, 10 });
        Node l2 = List.getDoubleLinkedList(new int[] { 5, 6, 7, 8 });
        Node l1 = List.getDoubleLinkedList(new int[] { 1, 2, 3, 4 });

        l1.next.next.child = l6;
        l1.next.child = l2;
        l2.next.child = l3;
        l2.next.next.child = l4;
        l2.next.next.next.child = l5;

        /**
         * 1->2->3->4
         *    |  |
         *    |  16->17
         *    |
         *    5->6->7->8
         *       |  |  |
         *       |  |  14->15
         *       |  11->12->13
         *       9->10
         *
         * Finally
         * 1->2->5->6->9->10->7->11->12->13->8->14->15->3->16->17->4
         */

        return l1;
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/">Flatten
     * Double Linked List</a> }
     * 
     * @param args
     */
    public static void main(String[] args) {

        System.out.print("\n");
        System.out.print("Recursive flat list");
        Node recursive = recursive(getHeadNode(), null);
        List.print(recursive);

        System.out.print("\n");
        System.out.print("Iterative flat list");
        Node iterative = iterative(getHeadNode());
        List.print(iterative);

        // Node fullFlat = flatten(l1, null);
        // validation part
        // Node temp = fullFlat;
        // while (temp != null) {
        // System.out.println(String.format("data -%d, prev - %s, child -%s, next - %s",
        // temp.data, temp.prev.data,
        // temp.child, temp.next == null ? -1 : temp.next.data));
        // temp = temp.next;
        // }

        System.out.print("\n");
        System.out.print("PreOrder flat list");
        Node preOrder = preOrder(getHeadNode());
        List.print(preOrder);
    }

    static Node recursive(Node head, Node next) {
        Node node = head, prev = null, tempNext = null, flat;
        while (node != null) {
            tempNext = node.next;
            if (node.child != null) {
                flat = recursive(node.child, tempNext);
                node.child = null;
                node.next = flat;
                flat.prev = node;
            }
            prev = node;
            node = tempNext;
        }

        if (prev != null && next != null) {
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = next;
            next.prev = prev;
        }
        return head;
    }

    static Node iterative(Node head) {
        Node node = head, prev = null;
        Deque<Node> stack = new ArrayDeque<>();
        while (node != null) {
            if (node.child != null) {
                if (node.next != null)
                    stack.push(node.next);

                node.next = node.child;
                node.child.prev = node;
                node.child = null;
                prev = node;
            }
            node = node.next;
            if (node == null && !stack.isEmpty()) {
                while (prev.next != null) {
                    prev = prev.next;
                }
                node = stack.pop();
                prev.next = node;
                node.prev = prev;
            }
        }

        return head;
    }

    static Node preOrder(Node node) {
        Node head = node,preoChild = null, preoNext, child, next;
        if (node == null)
            return node;

        child = node.child;
        next = node.next;
        if (child != null) {
            preoChild = preOrder(child);
            node.next = preoChild;
            node.child = null;
            if (preoChild != null)
                preoChild.prev = node;
            while (node.next != null)
                node = node.next;
        }

        if (next != null) {
            preoNext = preOrder(next);
            node.next = preoNext;
            if (preoNext != null)
                preoNext.prev = node;
        }
        return head;
    }
}