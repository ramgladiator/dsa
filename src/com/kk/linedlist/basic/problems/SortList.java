package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/sort-list/
public class SortList {

	public static void main(String[] args) {

		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		ListNode sortList = sortList(node1);

	}

	public static ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);

		return merge(left, right);

	}

	static ListNode getMid(ListNode head) {

		ListNode midPrev = null;
		while (head != null && head.next != null) {

			midPrev = (midPrev == null) ? head : midPrev.next;

			head = head.next.next;

		}

		ListNode mid = midPrev.next;
		midPrev.next = null;
		return mid;

	}

	static ListNode merge(ListNode list1, ListNode list2) {

		ListNode dummyHead = new ListNode();

		ListNode tail = dummyHead;

		while (list1 != null && list2 != null) {

			if (list1 != null && list2 != null) {

				if (list1.val < list2.val) {
					tail.next = list1;
					list1 = list1.next;
					tail = tail.next;
				} else {
					tail.next = list2;
					list2 = list2.next;
					tail = tail.next;
				}

			}

		}

		tail.next = (list1 != null) ? list1 : list2;

		return dummyHead.next;
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
