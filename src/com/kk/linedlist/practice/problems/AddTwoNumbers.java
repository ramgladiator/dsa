package com.kk.linkedlist;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
/*
    Time Complexity:

    The algorithm iterates through both input linked lists simultaneously, traversing each list at most once.
    Therefore, the time complexity is O(max(n, m)), where n and m are the lengths of the input linked lists l1 and l2, respectively.
    Space Complexity:

    The space complexity is O(max(n, m)), where n and m are the lengths of the input linked lists l1 and l2, respectively.
    This space is primarily consumed by the output linked list, which stores the sum of the two numbers.
            Additionally, a constant amount of extra space is used for variables like curr and carry.*/

    public static void main(String[] args) {
        // Creating example linked lists representing two numbers: 342 and 465
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Create an instance of AddTwoNumbers
        AddTwoNumbers solution = new AddTwoNumbers();

        // Call the addTwoNumbers method to add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        System.out.println("Sum of the two numbers:");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
