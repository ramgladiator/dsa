package com.kk.recursion.basic.problems;

public class InsertElementUsingRecursion {
	
	public static void main(String[] args) {
		
		Node node = new Node(12);
		
		Node node1 = insertRec(85, 0, node);
		
		System.out.println(node1.val);
		
	}
	
	
	static Node insertRec(int val,int index, Node node) {
		
		if(index == 0) {
			
			return node = new Node(val,node.next);
		}
		
		return node.next = insertRec(val, index-1, node.next);
	}
	
	
	

}

class Node{
	
	int val;

	public Node(int val) {
		super();
		this.val = val;
	}
	Node next;

	public Node(int val, Node next) {
		super();
		this.val = val;
		this.next = next;
	}
	
	
	
}