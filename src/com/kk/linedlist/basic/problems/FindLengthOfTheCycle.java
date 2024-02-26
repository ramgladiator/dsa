package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/linked-list-cycle/submissions/
public class FindLengthOfTheCycle {

	public static void main(String[] args) {

		FindLengthOfTheCycle insertNodeUsingRecursion = new FindLengthOfTheCycle();

		// Node node10 = new Node(1);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node4;

		int hasCycle = insertNodeUsingRecursion.hasCycle(node1);
		
		System.out.println("Cycle is presented and length is -> " + hasCycle);

		// insertNodeUsingRecursion.display();

	}

	private Node head;
	private Node tail;
	private int size;

	public FindLengthOfTheCycle() {
		this.size = 0;
	}

	public static class Node {

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

	public int hasCycle(Node head) {

		//return findCycleLength(head);//using normal while loop
		return findCycleLengthUsingdoWhile(head);//using do while loop
	}

	// Applying slow pointer and fast pointer approach
	public int findCycleLength(Node head) {

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow.value == fast.value) {

				int length = 0;
				Node temp = slow.next;// we moved temp one step ahead so that we need to add 1 to actual length
				while (temp != slow) {

					length++;
					temp = temp.next;
				}

				return length + 1;
			}

		}

		return 0;
	}

	// Applying slow pointer and fast pointer approach using do-while loop
	public int findCycleLengthUsingdoWhile(Node head) {

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow.value == fast.value) {

				int length = 0;
				Node temp = slow;
				do {

					temp = temp.next;
					length++;

				} while (temp != slow);

				return length;
			}

		}

		return 0;
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
