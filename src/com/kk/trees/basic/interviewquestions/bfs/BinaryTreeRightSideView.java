package com.kk.trees.basic.interviewquestions.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView {

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

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> resultList = new ArrayList<>();

		if (root == null) {
			return resultList;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		// offer methods add elements to queue
		queue.offer(root);

		while (!queue.isEmpty()) {

			int level = queue.size();

			for (int i = 0; i < level; i++) {

				// poll method retrieves the node and removes
				TreeNode currentNode = queue.poll();

				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}

				if (i == level - 1) {
					resultList.add(currentNode.val);
				}

			}

		}

		return resultList;

	}

}
