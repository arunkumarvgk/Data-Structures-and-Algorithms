package com.ds.algo.stack;

import java.util.Stack;

public class SortUsingSecondStack {

	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> temp = new Stack<>();
	
	private static void sortStack() {
		while ( ! stack.empty()) {
			int tmp = stack.pop();
			
			while ( ! temp.empty() && temp.peek() > tmp) {
				stack.push(temp.pop());
			}
			
			temp.push(tmp);
		}
	}
	
	public static void main(String[] args) {
		stack.push(5);
		stack.push(7);
		stack.push(3);
		stack.push(1);
		stack.push(6);
		stack.stream().forEach(v -> System.out.print(v+" "));
		System.out.println();
		sortStack();
		temp.stream().forEach(v -> System.out.print(v+" "));
	}
}
