package com.kk.linedlist.basic.problems;
//https://leetcode.com/problems/reorder-list/submissions/
public class ReorderList {

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

		 reorderList(node1);

		while (node1 != null) {

			System.out.println("The node values are -> " + node1.val);

			node1 = node1.next;

		}

	}

	private static void reorderList(ListNode head) {

		

		ListNode mid = getMid(head);
		ListNode hs = reverse(mid);
		ListNode hf = head;
		

		while (hf != null && hs != null) {

		   ListNode temp = hf.next;
		   hf.next = hs;
		   hf = temp;
		   
		   temp = hs.next;
		   hs.next = hf;
		   hs = temp;

		}
		
		if(hf!=null)
		{
			hf.next = null;
		}

	}

	private static ListNode reverse(ListNode mid) {

		ListNode previous = null;
		ListNode present = mid;
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

	private static ListNode getMid(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow;
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
