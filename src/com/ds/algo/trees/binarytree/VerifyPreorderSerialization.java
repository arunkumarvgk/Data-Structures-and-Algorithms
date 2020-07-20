package com.ds.algo.trees.binarytree;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * 
 * "9,3,4,#,#,1,#,#,2,#,6,#,#" is true "1,#" false
 */
public class VerifyPreorderSerialization {

	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		int l = 1;

		for (int i = 0; i < nodes.length; i++) {
			if (l == 0)
				return false;
			l = nodes[i].equals("#") ? --l : ++l;
		}

		return l == 0;
	}

	public static void main(String[] args) {
		VerifyPreorderSerialization bt = new VerifyPreorderSerialization();
		System.out.println(bt.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}

}
