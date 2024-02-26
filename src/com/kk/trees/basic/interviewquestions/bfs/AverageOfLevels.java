package com.kk.trees.basic.interviewquestions.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

	public static void main(String[] args) {
		// https://leetcode.com/problems/average-of-levels-in-binary-tree/
	}

	private class TreeNode {

		private int value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	public List<Double> averageOfLevels(TreeNode root) {

		List<Double> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {

			int levelSize = queue.size();
			double sum = 0;

			for (int i = 0; i < levelSize; i++) {

				TreeNode currentNode = queue.poll();
				sum += currentNode.value;
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}

			}

			double average = sum / levelSize;

			result.add(average);

		}
		return result;

	}

}
