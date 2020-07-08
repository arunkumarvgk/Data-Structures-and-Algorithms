package com.ds.algo.stack;

import java.util.Stack;

class MyDS {
	Stack<Integer> stack;
	Stack<Integer> minStack;
	int min;
	
	MyDS() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	
	public void addElement(int data) {
		stack.add(data);
		
		if (minStack.empty()) {
			minStack.add(data);
			return;
		}
		
		if (data <= minStack.peek()) {
			minStack.add(data);
		}
	}
	
	public int removeLastElement() {
		if (stack.empty()) {
			return -1;
		}
		
		if (stack.peek() == minStack.peek()) {
			minStack.pop();
		}
		
		return stack.pop();
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
	public int getLast() {
		return stack.peek();
	}
}
public class CustomDS {
	
	public static void main(String[] args) {
		MyDS ds = new MyDS();
		ds.addElement(15);
		ds.addElement(14);
		ds.addElement(32);
		ds.addElement(30);
		ds.addElement(10);
		ds.addElement(19);
		
		System.out.println(ds.getMin()+" "+ds.getLast());
		System.out.println(ds.removeLastElement());
		

		System.out.println(ds.getMin()+" "+ds.getLast());
		System.out.println(ds.removeLastElement());

		System.out.println(ds.getMin()+" "+ds.getLast());
		System.out.println(ds.removeLastElement());

		System.out.println(ds.getMin()+" "+ds.getLast());
		System.out.println(ds.removeLastElement());

		System.out.println(ds.getMin()+" "+ds.getLast());
		System.out.println(ds.removeLastElement());

		System.out.println(ds.getMin()+" "+ds.getLast());
		System.out.println(ds.removeLastElement());
		
	}

}
