package com.kk.linedlist.basic.problems;

//https://leetcode.com/problems/linked-list-cycle/submissions/
public class LinkedListCycleDetection {

	public static void main(String[] args) {

		LinkedListCycleDetection insertNodeUsingRecursion = new LinkedListCycleDetection();
		
		//Node node10 = new Node(1);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node2; // This creates a cycle

		
		boolean hasCycle = insertNodeUsingRecursion.hasCycle(node1);
		if (hasCycle) {
			System.out.println("yes Cycle has present -> YES");
		} else {
			System.out.println("No Cycle not present -> NO");

		}

		// insertNodeUsingRecursion.display();

	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedListCycleDetection() {
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

	public boolean hasCycle(Node head) {

		return findCycle(head);
	}

	// Applying slow pointer and fast pointer approach
	public boolean findCycle(Node head) {

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow.value == fast.value) {

				return true;
			}

		}

		return false;
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
