package com.kk.trees.basic.interviewquestions.dfs;

import com.kk.trees.basic.interviewquestions.dfs.LowestCommonAncestorBinaryTree.TreeNode;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
public class KthSmallest {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	
	
	
	
	  int count = 0;
	    public int kthSmallest(TreeNode root, int k) {
	        
	        return helper(root,k).val;
	        
	    }
	    
	    private TreeNode helper(TreeNode root,int k){
	        
	        if(root==null){
	            return null;
	        }
	        
	        
	       TreeNode left =  helper(root.left,k);
	        if(left != null){
	            return left;
	        }
	        count++;
	        if(count == k){
	            return root;
	        }
	       return  helper(root.right,k);
	        
	        
	        
	        
	    }
	

}
