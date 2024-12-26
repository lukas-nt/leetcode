package add_two_numbers;

import java.math.BigInteger;

class Solution {

    // Definition for singly-linked list.
    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = "";
        var t1 = l1;
        while (t1 != null) {
            num1 = t1.val + num1;
            t1 = t1.next;
        }

        String num2 = "";
        var t2 = l2;
        while (t2 != null) {
            num2 = t2.val + num2;
            t2 = t2.next;
        }


        String num = new BigInteger(num1).add(new BigInteger(num2)).toString();
        ListNode res = null;
        ListNode last = null;
        for (int i = 0; i < num.length(); i++) {
            int newNum = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (res != null) {
                last = new ListNode(res.val, res.next);
            }
            res = new ListNode(newNum, last);
        }
        return res;
    }

    public static void main(String[] args) {
        addTwoNumbers(
            new ListNode(2, new ListNode(2, new ListNode(3))),
            new ListNode(5, new ListNode(6, new ListNode(4)))
        );

        addTwoNumbers(
            new ListNode(0),
            new ListNode(0)
        );
    }

}