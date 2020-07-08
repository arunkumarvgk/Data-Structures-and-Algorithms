package com.ds.algo.stack;

import java.util.Stack;

public class PrefixtoInfix {

	private static void prefixToInfix(String exp) {
		Stack<String> stack = new Stack<>();
		String result = "";
		for (int i = exp.length(); i > 0; i--) {
			String chr = exp.substring(i-1, i);
			if (chr.equals("*") || chr.equals("/") || chr.equals("+") || chr.equals("-") ||chr.equals("^") ) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push("( "+op1+" "+chr+" "+op2+" ) ");
			} else {
				stack.push(chr);
			}
		}
		while (!stack.empty()) {
			result+=stack.pop();
		}
		System.out.println(result);
	}
	
	
	private static void prefixToPostfix(String exp) {
		Stack<String> stack = new Stack<>();
		String result = "";
		for (int i = exp.length(); i > 0; i--) {
			String chr = exp.substring(i-1, i);
			if (chr.equals("*") || chr.equals("/") || chr.equals("+") || chr.equals("-") ||chr.equals("^") ) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push(op1+" "+op2+" "+chr);
			} else {
				stack.push(chr);
			}
		}
		while (!stack.empty()) {
			result+=stack.pop();
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		prefixToInfix("*+AB-CD");
		prefixToInfix("*-A/BC-/AKL");
		
		prefixToPostfix("*+AB-CD");
		prefixToPostfix("*-A/BC-/AKL");
	}

}
