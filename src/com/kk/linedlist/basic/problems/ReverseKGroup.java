package com.kk.linedlist.basic.problems;

import com.kk.linedlist.basic.problems.ReverseLinkedList.ListNode;

public class ReverseKGroup {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		// reorderList(node1);
		reverseKGroup(node1, 3);

		while (node1 != null) {

			System.out.println("The node values are -> " + node1.val);

			node1 = node1.next;

		}

	}

	public static ListNode reverseList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode previous = null;
		ListNode present = head;
		ListNode next = present.next;

		while (present != null) {

			present.next = previous;
			previous = present;
			present = next;
			if (next != null) {
				next = next.next;
			}

		}

		return previous;

	}

	public static ListNode reverseKGroup(ListNode head, int k) {

		if (k <= 1 || head == null) {
			return head;
		}

		ListNode node = head;
		ListNode temp = new ListNode();
		for (int i = 0; i < k; i++) {
			node = node.next;
			temp  = node.next;
            
		}
		
		ListNode reverseList = reverseList(head);

		return reverseList;
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
