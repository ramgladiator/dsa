package com.kk.linedlist.basic;

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	
	class Node{
		
		int value;
		Node next;
		
		Node(int value){
			this.value = value;			
		}
		
		Node(int value, Node next){
			this.next = next;
		}
		
	}
	
	void insertFirst(int value){
		
		Node node = new Node(value);		
		 if(this.head == null && this.tail == null) {
			  this.head = node;
			  this.tail = node;
		 }else {
			 node.next = this.head;
			 this.head = node;
		 }
		
		
			 
		 
		 this.size++;
		
	}
    void insertLast(int value) {
    	Node node = new Node(value);
    	this.tail.next = node;
    	this.tail = node;
    	this.size++;
    	
    	//or
    	
		/*
		 * if(this.tail == null) { insertFirst(value); }
		 */
    	
    }
    
    public int deleteFirst() {
    	
    	Node temp = this.head;
    	this.head = this.head.next;
    	temp.next = null;
    	return temp.value;
    	
    }
    
    public int deleteLast() {
    	
    	Node temp = this.head;
    	int i = 0;
    	Node tails = this.tail;
    	while(temp != null && i<this.size-2) {
    		temp = temp.next;
    		this.tail = temp;
    		this.tail.next = null;
    		i++;
    		
    	}
    	
    	return tails.value;
    }
    
    void insertAtParticularIndex(int value, int index) {
    	
    	Node node = new Node(value);
    	Node temp = this.head;
    	int i = 0;
    	while(temp!=null && i<index) {
    		
    		node.next = temp.next;
    		temp.next = node;
    		i++;
    	}
    }
    
    void deleteAtParticularIndex(int index) {
    	Node temp = this.head;
    	int i = 1;
    	while(temp != null && i<index) {
    		
    		temp = temp.next;
    		i++;
    		
    	}
    	temp.next = temp.next.next;
    	
    }
	
	void display() {
		Node temp = this.head;
		while(temp != null) {
			System.out.print(temp.value);
			temp = temp.next;
			if(temp != null)
			System.out.print("->");
		}
	}
	
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		linkedList.insertFirst(2);		
		//linkedList.display();
		linkedList.insertLast(8);
		//linkedList.display();
		linkedList.insertAtParticularIndex(3, 1);
		linkedList.insertAtParticularIndex(1, 1);
		linkedList.display();
		System.out.println(" ");
		//linkedList.insertAtParticularIndex(9, 2);
		linkedList.deleteAtParticularIndex(1);
		linkedList.display();
		System.out.println(" ");
		System.out.println("delete First Element "+linkedList.deleteFirst());
		//linkedList.display();
		System.out.println("delete Last element "+linkedList.deleteLast());
		
	}
	

}
