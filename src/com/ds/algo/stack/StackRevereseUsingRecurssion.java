package com.ds.algo.stack;

import java.util.Stack;

public class StackRevereseUsingRecurssion {
	
	static Stack<Integer> stack = new Stack<>();
	
	private static void rev() {
		if (stack.empty()) {
			return;
		}
		
		int x = stack.pop();
		rev();
		insertToBottom(x);
	}
	
	private static void insertToBottom(int x) {
		if (stack.empty()) {
			stack.push(x);
			return;
		}
		
		int a = stack.pop();
		insertToBottom(x);
		stack.push(a);
	}

	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.stream().forEach(v -> System.out.print(v+" "));
		System.out.println();
		rev();
		stack.stream().forEach(v -> System.out.print(v+" "));
	}

}
