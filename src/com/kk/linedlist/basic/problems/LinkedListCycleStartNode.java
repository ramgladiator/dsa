package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleStartNode {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);

		ListNode node3 = new ListNode(3);

		ListNode node4 = new ListNode(4);

		ListNode node5 = new ListNode(5);

		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);

		ListNode node8 = new ListNode(8);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node4;
		
		ListNode detectCycle = detectCycle(node1);
		
		System.out.println("Cycle start node is "+ detectCycle.val);
		

	}

	public static ListNode detectCycle(ListNode head) {

		return findCycleStartNode(head);

	}

	// Applying slow & fast pointer approach
	private static ListNode findCycleStartNode(ListNode head) {

		if (head == null) {
			return head;
		}

		int length = findCycleLength(head);

		ListNode slow = head;
		ListNode fast = head;

		while (length > 0) {
			slow = slow.next;
			length--;
		}

		while (fast != slow) {

			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	private static int findCycleLength(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		int length = 0;
		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {

				ListNode temp = slow;

				do {
					temp = temp.next;
					length++;
				} while (slow != temp);
            return length;
			}

		}

		return length;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
