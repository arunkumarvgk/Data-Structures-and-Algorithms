package com.ds.algo.stack;

import java.util.Stack;

public class PostfixToInfix {

	private static void postfixToInfix(String exp) {
		Stack<String> stack = new Stack<>();
		String result = "";
		
		for (int i = 0; i < exp.length(); i++) {
			String chr = exp.substring(i, i+1);
			
			if (chr.equals("*") || chr.equals("/") || chr.equals("+") || chr.equals("-") ||chr.equals("^") ) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				stack.push("( "+op2+" "+chr+" "+op1+" )");
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
		postfixToInfix("ab*c+");
		postfixToInfix("ab-cd--");
	}

}
