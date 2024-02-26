package com.kk.trees.basic.interviewquestions.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class LevelOrderBottomTraversal {

	private static class TreeNode {

		private int value;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {	
		

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
        //offer methods add elements to queue
		queue.offer(root);

		while (!queue.isEmpty()) {

			int level = queue.size();

			List<Integer> resultList = new ArrayList<>();

			for (int i = 0; i < level; i++) {

				//poll method retrieves the node and removes
				TreeNode currentNode = queue.poll();

				resultList.add(currentNode.value);

				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}

			}

			result.add(0,resultList);
		}

		return result;

	}
}
