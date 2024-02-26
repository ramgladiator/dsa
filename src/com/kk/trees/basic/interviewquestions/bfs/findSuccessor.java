package com.kk.trees.basic.interviewquestions.bfs;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/
public class findSuccessor {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(18);
		root.right = new TreeNode(26);
		root.right.left = new TreeNode(24);
		root.right.right = new TreeNode(27);
		root.left.right.left = new TreeNode(14);
		root.left.right.left.left = new TreeNode(13);
		root.left.right.left.right = new TreeNode(15);
		root.left.right.right = new TreeNode(19);

		TreeNode findSucecsssor = findSucecsssor(root, 24);
		System.out.println("findSucecsssor val is " + findSucecsssor.value);
	}

	private static class TreeNode {

		private int value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	public static TreeNode findSucecsssor(TreeNode root, int key) {

		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList();

		queue.offer(root);

		while (!queue.isEmpty()) {

			TreeNode currentNode = queue.poll();

			if (currentNode.left != null) {

				queue.offer(currentNode.left);
			}

			if (currentNode.right != null) {

				queue.offer(currentNode.right);
			}

			if (currentNode.value == key) {
				break;
			}

		}

		return queue.peek();
	}

}
