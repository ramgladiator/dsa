package com.kk.trees.basic.interviewquestions.dfs;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepathOfBineryTree {
	
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
	
	
public int maxDepth(TreeNode root) {
        
        
        if(root == null){
            return 0;
        }
        
        int leftheight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return Math.max(leftheight,rightHeight)+1;
        
    }


}
