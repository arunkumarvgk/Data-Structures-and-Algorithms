package com.ds.algo.stack;

import java.util.Stack;
// Infix to prefix is also same.
// read string in reverse
// Convert the reversed string to postfix
// reverse and print it will be prefix converted
public class InfixToPostfix {

	
	private static int prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	private static void infixToPostfix(String exp) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < exp.length(); i++) {
			char chr = exp.charAt(i);
			
			if (Character.isLetterOrDigit(chr)) {
				sb.append(chr);
			} else 	if (chr == '(') {
				stack.push(chr);
			} else if (chr == ')') {
				while (!stack.empty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				
				if (!stack.empty() && stack.peek() != '(') {
					System.out.println("Invalid Expression");
					return;
				} else {
					stack.pop();
				}
			} else {
				while (!stack.empty() && prec(chr) <= prec(stack.peek()) ) {
					if (stack.peek() == '(') {
						System.out.println("Invalid Expression");
						return;
					} else {
						sb.append(stack.pop());
					}
				}
				stack.push(chr);
			}
		}
		
		while (!stack.empty()) {
			if (stack.peek() == '(') {
				System.out.println("Invalid Expression");
				return;
			} else {
				sb.append(stack.pop());
			}
		}
		
		System.out.println("Postfix ::    "+sb);
	}

	public static void main(String[] args) {
		infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
		infixToPostfix("-2+(4*8)");
		infixToPostfix("a-b-(c-d)");
	}

}
