package merge_two_sorted_lists;

class Solution {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode last = new ListNode(Integer.MIN_VALUE, null);
        ListNode tail = new ListNode(Integer.MIN_VALUE, last);
        var current1 = list1;
        var current2 = list2;
        while (current1 != null || current2 != null) {
            var val1 = current1 != null ? current1.val : null;
            var val2 = current2 != null ? current2.val : null;
            if (val1 != null && (val2 == null || val1 <= val2)) {
                var node = new ListNode(val1, null);
                last.next = node;
                last = node;
                current1 = current1.next;
            } else {
                var node = new ListNode(val2, null);
                last.next = node;
                last = node;
                current2 = current2.next;
            }
        }

        return tail.next.next;
    }

    public static void printListNode(ListNode listNode) {
        var current = listNode;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printListNode(mergeTwoLists(
            new ListNode(1, new ListNode(2, new ListNode(4, null))),
            new ListNode(1, new ListNode(3, new ListNode(4, null)))
        ));
        printListNode(mergeTwoLists(
            new ListNode(2, new ListNode(2, new ListNode(2, null))),
            new ListNode(1, new ListNode(3, new ListNode(4, null)))
        ));
        printListNode(mergeTwoLists(
            new ListNode(2, new ListNode(2, new ListNode(2, null))),
            new ListNode(1, new ListNode(3, new ListNode(4, null)))
        ));
        printListNode(mergeTwoLists(
            new ListNode(1, new ListNode(2, new ListNode(4, null))),
            new ListNode(2, new ListNode(2, new ListNode(2, null)))
        ));
        printListNode(mergeTwoLists(
            null,
            null
        ));
        printListNode(mergeTwoLists(
            null,
            new ListNode(0, null)
        ));
    }
}