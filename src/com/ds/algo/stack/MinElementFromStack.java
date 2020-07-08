package com.ds.algo.stack;

import java.util.Stack;

public class MinElementFromStack {

	static Stack<Integer> stack1 = new Stack<>();
	static Stack<Integer> stack2 = new Stack<>();
	
	private static void push(int data) {
		if (stack1.empty()) {
			stack1.add(data);
			stack2.add(data);
			return;
		}
		
		stack1.add(data);
		if (stack2.peek() > data) {
			stack2.add(data);
		}
	}
	
	private static int pop() {
		if (stack1.empty()) {
			System.out.println("Empty Stack");
			return -1;
		}

		if (stack2.peek() == stack1.peek()) {
			stack2.pop();
		}
		
		return stack1.pop();
	}
	
	private static int getMin() {
		if (stack2.empty()) {
			System.out.println("Empty Stack");
			return -1;
		}
		return stack2.peek();
	}
	
	private static void print() {
		stack1.forEach(elem -> System.out.print(" "+elem));
		System.out.println();
	}
	
	public static void main(String[] args) {
		push(18);
		push(19);
		push(29);
		push(15);
		push(16);
		print();
		System.out.println("Min "+getMin());
		System.out.println("Removed "+pop());
		print();
		System.out.println("Min "+getMin());
		System.out.println("Removed "+pop());
		System.out.println("Min "+getMin());
		print();
	}

}
