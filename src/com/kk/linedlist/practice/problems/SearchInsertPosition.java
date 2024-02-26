package com.kk.linedlist.practice.problems;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
	
	
	public static void main(String[] args) {
		
		int[] nums = {1,3,5,6};
		int target = 7;//target =0;
		int searchIndex = searchIndex(nums, target);
		System.out.println("Search Indexs is "+ searchIndex);
	}

	
	
	private static int searchIndex(int[] nums,int target){
        
	      int start = 0;
	      int end = nums.length-1;
	      
	       while(start<end){
	        
	        int mid = start + (end-start)/2;
	        
	        if(target == nums[mid]){
	            return mid;
	        }
	        else if(target<nums[mid]){
	            end = mid-1;
	        }else{
	            start = mid+1;
	        }       
	        
	    }
	        
	        
	        
	        if(nums[start]<target){
	            return start+1;
	        }else{
	            return start;
	        }
	       

}
}
