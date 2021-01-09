package com.lc.explore.ds.list;

import com.base.ds.nodes.Node;
import com.base.ds.list.List;
import static com.base.ds.list.List.getCircularLinkedList;

import java.util.Arrays;

public class InsertCircularList {

    public static void main(String[] args) {

        int[] arr = new int[] { 3, 3, 3 };
        List.printCircular(insert(getCircularLinkedList(arr), -1));
        List.printCircular(insert(getCircularLinkedList(arr), 0));
        List.printCircular(insert(getCircularLinkedList(arr), 4));
        List.printCircular(insert(getCircularLinkedList(new int[] {}), -1));
        List.printCircular(insert(getCircularLinkedList(new int[] { 1 }), 0));
        List.printCircular(insert(getCircularLinkedList(new int[] { 1, 3, 5 }), 0));
        arr = new int[] { 3, 4, 6, 1 };
        int i = arr.length;
        while (i-- > 0) {
            System.out.println("================ " + Arrays.toString(arr) + " ==============");
            List.printCircular(insert(getCircularLinkedList(arr), -1));
            List.printCircular(insert(getCircularLinkedList(arr), 2));
            List.printCircular(insert(getCircularLinkedList(arr), 5));
            List.printCircular(insert(getCircularLinkedList(arr), 7));
            List.printCircular(insert(getCircularLinkedList(arr), 1));
            List.printCircular(insert(getCircularLinkedList(arr), 3));
            arr = shift(arr);
        }
        System.exit(0);
    }

    static int[] shift(int[] arr) {
        int length = arr.length;
        int[] reordered = new int[length];
        for (int i = 0; i < length; i++)
            reordered[i] = arr[(1 + i) % length];

        return reordered;
    }

    static Node insert(Node head, int val) {
        if (head == null) {
            head = new Node(val);
            head.next = head;
            return head;
        }

        Node prev, node = head;
        do {
            // if value is between two nodes, insert in between
            if (node.val <= val && node.next.val >= val) {
                node.next = new Node(val, node.next);
                return head;
            }

            // if value is outside of high or low nodes, insert in between
            if (node.val > node.next.val) {
                if (val >= node.val || val <= node.next.val) {
                    node.next = new Node(val, node.next);
                    return head;
                }
            }
            prev = node;
            node = node.next;
        } while (node != head);

        // implies all node values are same, insert at end
        prev.next = new Node(val, node);
        return head;
    }
}
