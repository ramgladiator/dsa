package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromLinkedList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;

		boolean palindrome = isPalindrome(node1);
		if (palindrome) {
			System.out.println("Yes it is palindrome");
		} else {
			System.out.println("No it is nto a palindrome");

		}

		/*
		 * //ListNode reverseList = reverseList(node1,2,4);
		 * 
		 * while (reverseList != null) {
		 * 
		 * System.out.println("The node values are -> " + reverseList.val);
		 * 
		 * reverseList = reverseList.next;
		 * 
		 * }
		 */

	}

	private static ListNode reverse(ListNode head) {

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

	public static boolean isPalindrome(ListNode head) {

		if (head == null ) {
			return false;
		}
        
        //only one element means return true
        if(head.next == null){
            return true;
        }

		ListNode mid = getMid(head);		

		ListNode headSecond = reverse(mid);
		
		ListNode second = headSecond;

		while (head != null && second != null) {

			if (head.val != second.val) {
				break;
			}
			head = head.next;
			second = second.next;
		}
		
		reverse(headSecond);

		if (head == null || second == null) {
			return true;
		}

		return false;

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
