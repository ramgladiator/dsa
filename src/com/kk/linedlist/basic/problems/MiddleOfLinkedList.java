package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {

	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);

		ListNode node3 = new ListNode(3);

		ListNode node4 = new ListNode(4);

		ListNode node5 = new ListNode(5);

		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		
      ListNode findMiddleNode = findMiddleNode(node1);
      System.out.println("Middle node value is -> "+ findMiddleNode.val);

	}
	
	
	public static ListNode findMiddleNode(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			
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
