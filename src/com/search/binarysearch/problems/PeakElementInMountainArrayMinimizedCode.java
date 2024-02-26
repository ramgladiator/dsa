package com.search.binarysearch.problems;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakElementInMountainArrayMinimizedCode {
	
	public static void main(String[] args) {
		
		int[] arr = {0,2,5,6,9,18,19,7,4,3,2,1};
		int peakIndexInMountainArray = peakIndexInMountainArray(arr);
		System.out.println("Peak index in mountain array "+ peakIndexInMountainArray);
		
	}
	
	
	
	 public static int peakIndexInMountainArray(int[] arr) {
		 
		 
		 int start = 0, end = arr.length-1;
		 
		 while(start<end) {
			 
			 int mid = start + (end-start)/2;
			 
			 if(arr[mid]<arr[mid+1]) {
				 start = mid+1;
			 }else {
				 end = mid;// here why we are keeping the end=mid means if you have 4,3,2 in decreasing part and you found 3 is mid 
				 //then we cant make end= mid-1 (means if(mid>mid+1) i.e. here 4>3) why because mid element might be the peak index so we have to consider end from mid only when you are increasing part
				 //since we are in decreasing part so that we cant go back to 4
			 }
			 
			 
		 }
		 
		 
		 return start;//when start==end means we found the max indexd then we can return either start/end
	        
	    }
	

}
