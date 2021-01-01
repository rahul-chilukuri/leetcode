package com.lc.explore.ds.list;

import com.sr.ds.nodes.Node;
import com.sr.ds.list.List;
import com.sr.ds.list.LinkedList;

public class CycleDetection {

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/">CycleDetectionCheck</a>
     * }
     * 
     * @param head
     * @return boolean
     */

    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/">CycleDetection</a>
     * }
     * 
     * @param head
     * @return node where cycle starts
     */
    public Node detectStartOfCycle(Node head) {
        Node s = head, f = head;
        do {
            if (f == null || f.next == null) {
                return null;
            } else {
                f = f.next.next;
                s = s.next;
            }
        } while (s != f);

        s = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return s;
    }

    /**
     * See {@linktourl <a href=
     * "https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/">Intersection
     * node</a> }
     * 
     * @param h1
     * @param h2
     * @return
     */
    Node getFirstIntersectionNode(Node h1, Node h2) {
        Node n1 = h1;
        Node n2 = h2;

        while (n1 != n2) {
            n1 = n1 == null ? n2 : n1.next;
            n2 = n2 == null ? n1 : n2.next;
        }
        return n1;
    }

    boolean isLoop(Node head) {
        return getLoopInNode(head) == null ? false : true;
    }

    Node getLoopInNode(Node head) {
        Node fast = head;
        Node slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return slow;
    }

    void detectAndRemoveLoop(Node head) {
        Node loop = getLoopInNode(head);
        if (loop == null) {
            return;
        }

        System.out.println("Loop node is " + loop.data);
        Node l1 = head;

        // l1 at head and l2 at loop node
        // if they move 1 step at a time,
        // they will eventually meet at start of cycle
        while (l1.next != loop.next) {
            l1 = l1.next;
            loop = loop.next;
        }

        loop.next = null;
    }

    public static void main(String[] args) {
        CycleDetection detector = new CycleDetection();
        System.out.println("################ TEST LOOP ################");
        List loopList = new LinkedList();
        for (int i = 1; i < 6; i++) {
            loopList.insertAtEnd(i);
        }
        loopList.print();
        System.out.println("isLoop =>" + detector.isLoop(loopList.head));
        loopList.head.next.next.next.next.next = loopList.head.next;
        Node loop = detector.detectStartOfCycle(loopList.head);
        System.out.println("detectStartOfCycle() => " + (loop == null ? "NULL" : loop.data));
        detector.detectAndRemoveLoop(loopList.head);

        System.out.println("isLoop =>" + detector.isLoop(loopList.head));
        loopList.print();
    }
}
