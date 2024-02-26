package com.kk.linedlist.basic.problems;

public class InsertNodeUsingRecursion {

	public static void main(String[] args) {

		InsertNodeUsingRecursion insertNodeUsingRecursion = new InsertNodeUsingRecursion();
		insertNodeUsingRecursion.insertFirst(13);
		insertNodeUsingRecursion.insertFirst(9);
		insertNodeUsingRecursion.insertFirst(12);
		insertNodeUsingRecursion.insertFirst(5);
		insertNodeUsingRecursion.insertFirst(1);
		insertNodeUsingRecursion.display();
		
		insertNodeUsingRecursion.insertNodeUsinRecursion(19, 2);
		
		insertNodeUsingRecursion.display();

	}

	private Node head;
	private Node tail;
	private int size;

	public InsertNodeUsingRecursion() {
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
	
	public Node insertNodeUsinRecursion(int value,int index) {
		
		return insertNode(value, index, head);
	}

	// Using Recursion
	private Node insertNode(int value, int index, Node head) {

		if (index == 0) {
			Node temp = new Node(value);
			temp.next = head;
			size++;
			return temp;
		}

		head.next = insertNode(value, index-1, head.next);
		return head;

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
