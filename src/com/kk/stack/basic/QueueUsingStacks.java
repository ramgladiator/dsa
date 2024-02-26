package com.kk.stack.basic;

import java.util.Stack;

public class QueueUsingStacks {
	
	
	  public static void main(String[] args) {
		
		  
		  QueueUsingStacks queue = new QueueUsingStacks();
		  
		  queue.push(10);
		  queue.push(19);
		  queue.display();
		  queue.pop();
		  queue.display();

	}
	
	

	    Stack<Integer> stack1 ;
	    Stack<Integer> stack2;

	    public QueueUsingStacks() {
	    	stack1 = new Stack<>();
		    stack2 = new Stack<>();
	    }
	    
	    public void push(int x) {
	        
	        while(!stack1.isEmpty()){
	            stack2.push(stack1.pop());
	        
	        }
	        stack1.push(x);

	while(!stack2.isEmpty()){
	            stack1.push(stack2.pop());
	        
	}
	       
	    }
	    
	    public int pop() {

	         while(!stack1.isEmpty()){
	            stack2.push(stack1.pop());
	        
	        }
	        int popped = stack2.pop();

	while(!stack2.isEmpty()){
	            stack1.push(stack2.pop());
	        }

	        return popped;
	    }
	    
	    public int peek() {

	        while(!stack1.isEmpty()){
	            stack2.push(stack1.pop());
	        
	        }
	    int peeked = stack2.peek();
	while(!stack2.isEmpty()){
	            stack1.push(stack2.pop());
	        
	}
	       

	        return peeked;
	        
	    }
	    
	    public boolean empty() {

	        return stack1.isEmpty();
	        
	    }
	    
	    public void display() {
	    	System.out.println("diplaying stack elements "+ stack1);
	    }
	

	
}
