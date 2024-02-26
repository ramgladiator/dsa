package com.kk.trees.basic;

public class CreateBST {

	public static void main(String[] args) {

		CreateBST bst = new CreateBST();

		populate();
		display();
		boolean bal = balanced(root);
		if (bal) {
			System.out.println("Tree is balanced");
		} else {
			System.out.println("Tree is Not balanced");

		}

	}

	public static void display() {
		display(root);
	}

	private static void display(Node node) {

		if (node == null) {
			return;

		}

		System.out.println("Current Node value " + node.value + "->" + node.height);
		display(node.left);
		display(node.right);

	}

	public static void populate() {

		int[] array = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
		for (int value : array) {
			insert(value);

		}
	}

	public static class Node {

		private int value;
		private Node left;
		private Node right;
		private int height;

		public Node(int value) {
			this.value = value;
		}

	}

	private static Node root;

	public static void insert(int value) {

		root = insert(value, root);

	}

	public static boolean balanced(Node node) {

		if (node == null) {
			return true;
		}

		return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
	}

	private static Node insert(int value, Node node) {

		if (node == null) {
			Node node1 = new Node(value);

			return node1;
		}

		if (value < node.value) {
			node.left = insert(value, node.left);
		}

		if (value > node.value) {
			node.right = insert(value, node.right);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return node;
	}

	public static int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

}
