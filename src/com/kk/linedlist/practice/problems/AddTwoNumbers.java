package com.kk.linedlist.practice.problems;

//https://leetcode.com/problems/add-two-numbers/discuss/3675747/Beats-100-oror-C%2B%2B-oror-JAVA-oror-PYTHON-oror-Beginner-Friendly
public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = null;

		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);

		node4.next = node5;
		node5.next = node6;
		node6.next = null;

		ListNode addTwoNumbers = addTwoNumbers(node1, node4);
		while (addTwoNumbers!= null) {
			System.out.println("Final list is " + addTwoNumbers.val);
			addTwoNumbers = addTwoNumbers.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode node = new ListNode(0);
		ListNode dummy = node;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {

			int digit1 = (l1 != null) ? l1.val : 0;
			int digit2 = (l2 != null) ? l2.val : 0;

			int sum = digit1 + digit2 + carry;
			int digit = sum % 10;
			carry = sum / 10;

			ListNode newNode = new ListNode(digit);
			dummy.next = newNode;
			dummy = dummy.next;

			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;

		}

		ListNode result = node.next;
		node.next = null;

		return result;

	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
