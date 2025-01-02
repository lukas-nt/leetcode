package swap_nodes_in_pairs;

class Solution {

     //Definition for singly-linked list.
     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head) {
         var current = head;
         while (current != null) {
             if (current.next != null) {
                 int tmp = current.next.val;
                 current.next.val = current.val;
                 current.val = tmp;
                 current = current.next.next;
             } else {
                 current = null;
             }
         }
         return head;
    }

    public static void printListNode(ListNode list) {
         var current = list;
         while (current != null) {
             System.out.println(current.val);
             current = current.next;
         }
        System.out.println();
    }

    public static void main(String[] args) {
         printListNode(swapPairs(
             new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))
         ));
        printListNode(swapPairs(
            null
        ));
        printListNode(swapPairs(
            new ListNode(1, null)
        ));
        printListNode(swapPairs(
            new ListNode(1, new ListNode(2, new ListNode(3, null)))
        ));
    }
}
