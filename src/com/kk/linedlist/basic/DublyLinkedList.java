package com.kk.linedlist.basic;

public class DublyLinkedList {
	
	
	Node head;
	Node tail;
	int size;
	
	public DublyLinkedList() {
		this.size = 0;
	}
	
	public void insertAtFirst(int val) {
		
		Node node = new Node(val);
		
		if(head != null) {
		
		node.next = head;
		node.prev = null;
		head.prev = node;
		head = node;
		return;
		}
		
		head = node;
		
		
		
		
	}
	
void insertAtLast(int val) {
	
	Node node = new Node(val);
	Node temp = head;
	
	
	while(temp.next != null) {
		
		temp = temp.next;
		
	}
	
	temp.next = node;
	node.prev = temp;
	node.next = null;
	
	
	
	
}
	
	void display() {
		
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
			if(temp !=null) {
				System.out.print("->");

			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
	DublyLinkedList list = new DublyLinkedList();
	
	list.insertAtFirst(3);
	list.insertAtFirst(5);
	list.insertAtFirst(7);
	list.insertAtFirst(9);

	list.display();
	
	list.insertAtLast(31);
	list.display();
		
	}
	
	
	

}

 class Node{
	
	public int val;
	public Node next;
	public Node prev;
	
	public Node(int val) {
		super();
		this.val = val;
	}
	
	
	
	
}