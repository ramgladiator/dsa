package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedList2 {

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

		ListNode reverseList = reverseList(node1, 2, 4);

		while (reverseList != null) {

			System.out.println("The node values are -> " + reverseList.val);

			reverseList = reverseList.next;

		}

	}

	public static ListNode reverseList(ListNode head, int left, int right) {

		if (head == null || head.next == null && left==right) {
			return head;
		}

		ListNode previous = null;
		ListNode present = head;
		ListNode next = present.next;

		for (int i = 0; i < left - 1; i++) {

			previous = present;
			present = present.next;
			next = next.next;

		}

		ListNode last = previous;
		ListNode newEnd = present;

		for (int i = 0; present != null && i <= right - left; i++) {

			present.next = previous;
			previous = present;
			present = next;
			if (next != null) {
				next = next.next;
			}

		}

		if (last != null) {
			last.next = previous;
		}
		else{
			head = previous;

		}

		newEnd.next = present;


		return head;

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
