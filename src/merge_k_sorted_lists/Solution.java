package merge_k_sorted_lists;


import java.util.TreeSet;

class Solution {

     //Definition for singly-linked list.
     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     record ValueIndex(int value, int index) implements Comparable<ValueIndex> {

         @Override
         public int compareTo(ValueIndex o) {
             int diff = Integer.compare(value, o.value);
             if (diff == 0) return Integer.compare(index, o.index);
             else return diff;
         }

     }

    public static ListNode mergeKLists(ListNode[] lists) {
         ListNode latest = new ListNode(Integer.MIN_VALUE, null);
         ListNode result = new ListNode(Integer.MIN_VALUE, latest);
         TreeSet<ValueIndex> heads = new TreeSet<>();
         for (int i = 0; i < lists.length; i++) {
             if (lists[i] != null) heads.add(new ValueIndex(lists[i].val, i));
         }

         while (!heads.isEmpty()) {
            var entry = heads.removeFirst();
            int index = entry.index();
            var node = lists[index];
            var newNode = new ListNode(node.val, null);
            latest.next = newNode;
            latest = newNode;
            if (node.next != null) {
                lists[index] = node.next;
                heads.add(new ValueIndex(node.next.val, index));
            }
         }
         return result.next.next;
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
         printListNode(mergeKLists(new ListNode[]{
                 new ListNode(1, new ListNode(4, new ListNode(5, null))),
                 new ListNode(1, new ListNode(3, new ListNode(4, null))),
                 new ListNode(2, new ListNode(6, null)),
         }));
        printListNode(mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5, null)))
        }));
        printListNode(mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(-1, new ListNode(3, new ListNode(4, null))),
                new ListNode(2, new ListNode(6, null)),
        }));
        printListNode(mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5, null))),
                new ListNode(-1, new ListNode(3, new ListNode(4, null))),
                null,
        }));
        printListNode(mergeKLists(new ListNode[]{
                null,
                null,
                null,
        }));
        printListNode(mergeKLists(new ListNode[]{
                null
        }));
        printListNode(mergeKLists(new ListNode[]{}));
    }
}