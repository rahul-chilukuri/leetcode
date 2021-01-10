package com.lc.explore.ds.list;

import com.base.ds.nodes.Node;
import com.base.ds.list.List;

public class RotateList {
    public static void main(String[] args) {
        List.print(rotateRight(List.getLinkedList(new int[] {}), 10)); // null
        List.print(rotateRight(List.getLinkedList(new int[] { 1 }), 10)); // 1->null
        List.print(rotateRight(List.getLinkedList(new int[] { 1, 2 }), 10)); // 1->2->null
        List.print(rotateRight(List.getLinkedList(new int[] { 1, 2 }), 9)); // 2->1->null

        System.out.println("#################################################");
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        List.print(rotateRight(List.getLinkedList(arr), 1)); // 1->2->3->4->5->null
        List.print(rotateRight(List.getLinkedList(arr), 2)); // 2->3->4->5->1->null
        List.print(rotateRight(List.getLinkedList(arr), 3)); // 3->4->5->1->2->null
        List.print(rotateRight(List.getLinkedList(arr), 4)); // 4->5->1->2->3->null
        List.print(rotateRight(List.getLinkedList(arr), 5)); // 1->2->3->4->5->null
    }

    public static Node rotateRight(Node head, int k) {
        // if k is not positive, or head is null or head is the only element
        // resultant list is same as head
        if (k < 1 || head == null || head.next == null)
            return head;

        Node last = head;
        int n = 1;
        while (last.next != null) {
            n++;
            last = last.next;
        }

        // to avoid unnecessary iterations if k >=n
        k = k < n ? k : k % n;
        if (k == 0) {
            return head;
        }

        Node newTail = head, newHead = null;
        int newTailIdx = n - (k % n) -1;
        while (newTailIdx-- > 0)
            newTail = newTail.next;

        newHead = newTail.next;
        newTail.next = null;
        last.next = head;
        return newHead;
    }

}
