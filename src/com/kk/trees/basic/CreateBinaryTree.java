package com.kk.trees.basic;

import java.util.Scanner;

public class CreateBinaryTree {

	public static void main(String[] args) {

		CreateBinaryTree binaryTree = new CreateBinaryTree();

		Scanner scanner = new Scanner(System.in);

		binaryTree.populate(scanner);
		binaryTree.display();

	}

	private class Node {

		private int value;
		private Node left;
		private Node right;

		private int height;

		public Node(int value) {
			this.value = value;
		}

	}

	private Node root;

	public void populate(Scanner scanner) {

		System.out.println("Enter the root Node ");

		int value = scanner.nextInt();
		this.root = new Node(value);

		populate(root, scanner);

	}

	private void populate(Node node, Scanner scanner) {

		System.out.println("Do you want insert left node of ->" + node.value);

		boolean left = scanner.nextBoolean();

		if (left) {

			System.out.println("Enter the value of left node of ->" + node.value);

			int value = scanner.nextInt();

			node.left = new Node(value);

			populate(node.left, scanner);

		}

		System.out.println("Do you want insert right node of ->" + node.value);

		boolean right = scanner.nextBoolean();

		if (right) {
			System.out.println("Enter the value of right node of ->" + node.value);

			int value = scanner.nextInt();

			node.right = new Node(value);
			populate(node.right, scanner);

		}

	}

	public void display() {

		display(this.root, "");
	}

	private void display(Node node, String indent) {

		if (node == null) {
			return;
		}
		System.out.println(indent + node.value);
		display(node.left, indent+"\t");
		display(node.right, indent+"\t");
	}
	
	
	public void prettyDisplay() {
	    prettyDisplay(root, 0);
	  }

	  private void prettyDisplay(Node node, int level) {
	    if (node == null) {
	      return;
	    }

	    prettyDisplay(node.right, level + 1);

	    if (level != 0) {
	      for (int i = 0; i < level - 1; i++) {
	        System.out.print("|\t\t");
	      }
	      System.out.println("|------->" + node.value);
	    } else {
	      System.out.println(node.value);
	    }
	    prettyDisplay(node.left, level + 1);
	  }
}
