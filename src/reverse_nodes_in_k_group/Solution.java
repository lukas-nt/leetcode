package reverse_nodes_in_k_group;


import java.util.ArrayList;

class Solution {

     // Definition for singly-linked list.
     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode reverseKGroup(ListNode head, int k) {
        printListNode(head);
        var list = new ArrayList<Integer>();
        var current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.size() - i >= k) {
                //System.out.println(i);
                int j = 0;
                while (j < k / 2) {
                    int tmp = list.get(i + j);
                    list.set(i + j, list.get(i + k - j - 1));
                    list.set(i + k - j - 1, tmp);
                    j++;
                }
                i += k - 1;
            }
        }
        head = new ListNode(list.get(0), head.next);
        current = head.next;
        int i = 1;
        while (current != null) {
            current = new ListNode(list.get(i), current.next);
            current = current.next;
            i++;
        }
        return head;
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
        printListNode(reverseKGroup(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))),
            2
        ));

        printListNode(reverseKGroup(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))),
            3
        ));

        printListNode(reverseKGroup(
            new ListNode(2, new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(5, null))))),
            2
        ));
    }

}
