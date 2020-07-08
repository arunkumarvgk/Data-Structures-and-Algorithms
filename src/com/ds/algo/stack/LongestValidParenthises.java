package com.ds.algo.stack;

import java.util.Stack;

public class LongestValidParenthises {

	private static void find(String exp) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < exp.length(); i++) {
			char chr = exp.charAt(i);

			if (chr == '(') {
				stack.push(chr);
			} else if (chr == ')') {
				if (!stack.empty() && stack.peek() == '(') {
					stack.pop();
					count += 2;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		find("((()");
		find(")()())");
		find("()(()))))");
		find("((()()()()(((())");
	}
}
