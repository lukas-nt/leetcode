package remove_nth_node_from_end_of_list;


import java.util.ArrayList;

class Solution {

    //Definition for singly-linked list.
    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        var nodes = new ArrayList<ListNode>();
        nodes.add(head);
        var next = head.next;
        while (next != null) {
            nodes.add(next);
            next = next.next;
        }
        if (n > 0 && nodes.size() - n >= 0) {
            var before = (n < nodes.size()) ? nodes.get(nodes.size() - n - 1) : null;
            var removed = nodes.get(nodes.size() - n);
            if (before != null) {
                before.next = removed.next;
            } else {
                head = removed.next;
            }
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printListNode(
            removeNthFromEnd(
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(4,
                                new ListNode(5))))),
            2
        ));

        printListNode(
            removeNthFromEnd(
                new ListNode(1, null),
        1
        ));

        printListNode(
            removeNthFromEnd(
                new ListNode(1, new ListNode(2, null)),
                1
        ));

        printListNode(
            removeNthFromEnd(
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(4,
                                new ListNode(5))))),
                5
        ));

        printListNode(
            removeNthFromEnd(
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(4,
                                new ListNode(5))))),
            6
        ));

        printListNode(
            removeNthFromEnd(
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(4,
                                new ListNode(5))))),
            0
        ));

        printListNode(
            removeNthFromEnd(
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(4,
                                new ListNode(5))))),
            -1
        ));
    }

}