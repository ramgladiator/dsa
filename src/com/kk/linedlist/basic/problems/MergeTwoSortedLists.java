package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

	public static void main(String[] args) {

		MergeTwoSortedLists first = new MergeTwoSortedLists();
		first.insertLast(1);
		first.insertLast(2);
		first.insertLast(4);

		MergeTwoSortedLists second = new MergeTwoSortedLists();
		second.insertLast(1);
		second.insertLast(3);
		second.insertLast(4);

		MergeTwoSortedLists mergeTwoLists = mergeTwoLists(first, second);

		mergeTwoLists.display();

	}

	private Node head;
	private Node tail;
	private int size;

	public MergeTwoSortedLists() {
		this.size = 0;
	}

	class Node {

		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

	}

	public void insertFirst(int value) {
		Node node = new Node(value);

		if (this.head == null && this.tail == null) {
			this.head = node;
			this.tail = node;
			return;
		}
		node.next = this.head;
		this.head = node;
		this.size++;

	}

	void insertLast(int value) {
		Node node = new Node(value);
		if (this.head == null && this.tail == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;

		// or

		/*
		 * if(this.tail == null) { insertFirst(value); }
		 */

	}

	public static MergeTwoSortedLists mergeTwoLists(MergeTwoSortedLists first, MergeTwoSortedLists second) {

		MergeTwoSortedLists ans = new MergeTwoSortedLists();
		Node f = first.head;
		Node s = second.head;

		while (f != null && s != null) {

			if (f.value < s.value) {

				ans.insertLast(f.value);
				f = f.next;
			} else {

				ans.insertLast(s.value);
				s = s.next;
			}

		}

		while (f != null) {
			ans.insertLast(f.value);
			f = f.next;
		}

		while (s != null) {
			ans.insertLast(s.value);
			s = s.next;
		}

		return ans;

	}

	public void display() {

		Node temp = this.head;

		while (temp != null) {

			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.println("END ");
	}

}
