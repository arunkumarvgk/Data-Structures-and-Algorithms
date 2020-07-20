package com.ds.algo.trees.binarytree;

import java.util.Stack;

import com.ds.algo.trees.binarysearchtree.TreeNode;

public class ConvertStringToBT {

	private TreeNode convert(String str, int start, int end) {
		if (str == null || str == "()" || str == "" || start > end) {
			return null;
		}
		
		int num = getNum(str, start);
		TreeNode node = new TreeNode(num);
		start = getStartIndex(str, start);
		end = getIndex(str, start);
		node.left = convert(str, start, end);
		node.right = convert(str, end + 1, str.length() - 1);

		return node;
	}

	private int getNum(String str, int start) {
		if (str.length() == 1) {
			return Integer.parseInt(str);
		}
		int i = start + 1;
		String num = "";
		while(str.charAt(i) != '(' && str.charAt(i) != ')') {
			num+=str.charAt(i++);
		}
		return Integer.parseInt(num);
	}

	private int getStartIndex(String str, int start) {
		int i = start + 1;
		while(str.charAt(i) != '(' && str.charAt(i) != ')') {
			i++;
		}
		return i;
	}
	
	private int getIndex(String str, int i) {
		Stack<Character> stack = new Stack<>();
		char[] charArray = str.toCharArray();
		
		stack.add(charArray[i]);
		
		for (i = i + 1; i < charArray.length; i++) {
			if (stack.isEmpty()) {
				break;
			}
			if (charArray[i] == ')') {
				
				while (stack.peek() != '(') {
					stack.pop();
				}
				stack.pop();

			} else {
				stack.push(charArray[i]);
			}
		}
		return i;
	}

	private void preorderPrint(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val+" ");
		preorderPrint(node.left);
		preorderPrint(node.right);
	}

	public static void main(String[] args) {
		ConvertStringToBT bt = new ConvertStringToBT();
		TreeNode node = bt.convert("(-4(2(3)(1))(6(5)))", 0, 18);
		bt.preorderPrint(node);
	}

}
