package com.kk.trees.basic.interviewquestions.bfs;

//https://leetcode.com/problems/cousins-in-binary-tree/
public class CousinsInBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {

		TreeNode xx = findNode(root, x);
		TreeNode yy = findNode(root, y);

		return (level(root, xx, 0) == level(root, yy, 0) && !isSibling(root, xx, yy));

	}

	private TreeNode findNode(TreeNode root, int x) {

		if (root == null) {
			return null;
		}

		if (root.val == x) {
			return root;
		}

		TreeNode node = findNode(root.left, x);

		if (node != null) {
			return node;
		}

		return findNode(root.right, x);
	}

	private int level(TreeNode root, TreeNode x, int level) {

		if (root == null) {
			return 0;
		}

		if (root == x) {
			return level;
		}

		int lev = level(root.left, x, level + 1);

		if (lev != 0) {
			return lev;
		}

		return level(root.right, x, level + 1);

	}

	private boolean isSibling(TreeNode root, TreeNode xx, TreeNode yy) {

		if (root == null) {
			return false;
		}

		return ((root.left == xx && root.right == yy)
				|| (root.right == xx && root.left == yy) || isSibling(root.left, xx, yy)
				|| isSibling(root.right, xx, yy));

	}

}
