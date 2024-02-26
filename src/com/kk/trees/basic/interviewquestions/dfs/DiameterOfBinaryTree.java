package com.kk.trees.basic.interviewquestions.dfs;

//https://leetcode.com/problems/diameter-of-binary-tree/description/?ref=laigary.com
public class DiameterOfBinaryTree {

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

	int diameter = 0;
	public int diameterOfBinaryTree(TreeNode root) {
		
		height(root);
		return diameter-1;

	}
	
	
	
	private int height(TreeNode node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		int dia = leftHeight + rightHeight+1;
		
		diameter = Math.max(diameter, dia);
		
		return Math.max(leftHeight, rightHeight)+1;
		
	}

}
