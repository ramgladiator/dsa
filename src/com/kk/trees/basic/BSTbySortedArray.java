package com.kk.trees.basic;

import com.kk.trees.basic.CreateBST.Node;

public class BSTbySortedArray {

	public static void main(String[] args) {

		BSTbySortedArray bst = new BSTbySortedArray();

		populate();
		display();
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

	public static int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	public static void populate() {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		populate(arr, 0, arr.length);

	}

	private static void populate(int[] arr, int start, int end) {

		if (start >= end) {

			return;
		}

		int mid = (start + end) / 2;

		insert(arr[mid]);
		populate(arr, start, mid);
		populate(arr, mid + 1, end);

	}

	public static void insert(int value) {

		root = insert(value, root);

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

}
