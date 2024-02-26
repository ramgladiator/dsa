package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {

		RemoveDuplicatesFromSortedList insertNodeUsingRecursion = new RemoveDuplicatesFromSortedList();
		insertNodeUsingRecursion.insertFirst(2);
		insertNodeUsingRecursion.insertFirst(1);
		insertNodeUsingRecursion.insertFirst(1);

		insertNodeUsingRecursion.removeDuplicatesMain();

		insertNodeUsingRecursion.display();

	}

	private Node head;
	private Node tail;
	private int size;

	public RemoveDuplicatesFromSortedList() {
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

	public Node removeDuplicatesMain() {

		//return removeDuplicates(this.head);
		return removeDuplicates1(this.head);
	}

	// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	private Node removeDuplicates(Node head) {

		Node temp = head;
		while (temp.next != null) {

			if (temp.value == temp.next.value) {

				temp.next = temp.next.next;

			} else {
				temp = temp.next;
			}

		}

		this.tail = temp;
		this.tail.next = null;
		return temp;

	}

	// leetcode code checking
	private Node removeDuplicates1(Node head) {

		if (head == null) {
			return head;
		}

		Node temp = head;

		while (head.next != null) {

			if (head.value == head.next.value) {

				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}

		return temp;

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
