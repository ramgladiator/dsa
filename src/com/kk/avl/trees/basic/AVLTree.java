package com.kk.avl.trees.basic;

public class AVLTree {

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			insert(i);
		}
		System.out.println("tree height " + height(root));

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

		return rotate(node);
	}

	public static int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	private static Node rotate(Node node) {

		if (height(node.left) - height(node.right) > 1) {

			// left is heavy

			if (height(node.left.left) - height(node.left.right) > 0) {

				// left left case

				return rightRotate(node);

			}

			if (height(node.left.left) - height(node.left.right) < 0) {

				// left right case

				node.left = leftRotate(node);

				return rightRotate(node);

			}

		}

		if (height(node.left) - height(node.right) < 1) {

			// right is heavy

			if (height(node.right.left) - height(node.right.right) > 0) {

				// right left case

				node.right = rightRotate(node);

				return leftRotate(node);

			}

			if (height(node.right.left) - height(node.right.right) < 0) {

				// right right case

				return leftRotate(node);

			}

		}

		return node;
	}

	private static Node rightRotate(Node p) {

		Node c = p.left;
		Node t = c.right;

		c.right = p;
		p.left = t;

		p.height = Math.max(height(p.left), height(p.right) + 1);
		c.height = Math.max(height(c.left), height(c.right) + 1);
		return c;
	}

	private static Node leftRotate(Node c) {

		Node p = c.right;
		Node t = p.left;

		c.right = t;
		p.left = c;

		p.height = Math.max(height(p.left), height(p.right) + 1);
		c.height = Math.max(height(c.left), height(c.right) + 1);
		return p;

	}

}
