package com.ds.algo.stack;

import java.util.Stack;

public class BalancedParanthesis {

	private static boolean check(String exp) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < exp.length(); i++) {
			char chr = exp.charAt(i);
			
			if (chr == '(' || chr == '{' || chr == '[') {
				stack.push(chr);
			} else if (chr == ')') {
				if (stack.empty() || stack.pop() != '(') {
					return false;
				}
			} else if (chr == ']') {
				if (stack.empty() || stack.pop() != '[') {
					return false;
				}
			} else if (chr == '}') {
				if (stack.empty() || stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.empty();
	}
	public static void main(String[] args) {
		if (check("{()}[]]")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Unbalanced"); 
		}
		
		if (check("{()}[]")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Unbalanced"); 
		}
		
		if (check("[()]{}{[()()]()}")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Unbalanced"); 
		}
		
		if (check("[(])")) {
			System.out.println("Balanced");
		} else {
			System.out.println("Unbalanced"); 
		}
	}

}
