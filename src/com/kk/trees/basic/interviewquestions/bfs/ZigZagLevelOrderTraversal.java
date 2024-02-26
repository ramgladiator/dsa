package com.kk.trees.basic.interviewquestions.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class ZigZagLevelOrderTraversal {

	private static class TreeNode {

		private int value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		boolean reverse = false;

		while (!queue.isEmpty()) {
			List<Integer> currentLevel = new ArrayList<>();
			int level = queue.size();
			
			for (int i = 0; i < level; i++) {
				TreeNode currentNode = queue.poll();
				currentLevel.add(currentNode.value);

				if (!reverse) {
					if (currentNode.right != null) {

						queue.offer(currentNode.right);
					}
					if (currentNode.left != null) {

						queue.offer(currentNode.left);
					}

				} else {

					if (currentNode.left != null) {

						queue.offer(currentNode.left);
					}

					if (currentNode.right != null) {

						queue.offer(currentNode.right);
					}

				}

			}

			reverse = !reverse;
			result.add(currentLevel);

		}

		return result;

	}

}
