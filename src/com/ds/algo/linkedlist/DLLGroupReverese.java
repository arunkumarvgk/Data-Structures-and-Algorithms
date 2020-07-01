package com.ds.algo.linkedlist;

public class DLLGroupReverese {

	static DLLNode head;
	/*
	private static DLLNode insertFront(DLLNode head, DLLNode newHead) {
		newHead.prev = null;
		newHead.next = head;
		
		if (head!=null) {
			head.prev = newHead;
		}
		head = newHead;
		return head;
	}
	
	private static DLLNode reverse(DLLNode head, int k) {
		int count = 0;
		DLLNode newHead = null;
		DLLNode cur = head;
		DLLNode next = null;
		
		while (cur != null && count<k) {
			next = cur.next;
			newHead = insertFront(newHead, cur);
			cur = next;
			count++;
		}
		
		if (next != null) {
			head.next = reverse(next, k);
			head.next.prev = head;
		}
		
		return newHead;
	}
	*/
	
	static DLLNode push(DLLNode head, DLLNode new_node)  
    { 
        // since we are adding at the beginning,  
        // prev is always NULL  
        new_node.prev = null; 
  
        // link the old list off the new DLLNode 
        new_node.next = head; 
  
        // change prev of head DLLNode to new DLLNode  
        if (head != null) 
            head.prev = new_node; 
  
        // move the head to point to the new DLLNode  
        head = new_node; 
        return head; 
    } 
  
    // function to reverse a doubly linked list  
    // in groups of given size  
    static DLLNode revListInGroupOfGivenSize(DLLNode head, int k) 
    { 
        DLLNode current = head; 
        DLLNode next = null; 
        DLLNode newHead = null; 
        int count = 0; 
  
        // reversing the current group of k  
        // or less than k nodes by adding  
        // them at the beginning of list  
        // 'newHead' 
        while (current != null && count < k) 
        { 
            next = current.next; 
            newHead = push(newHead, current); 
            current = next; 
            count++; 
        } 
  
        // if next group exists then making the desired  
        // adjustments in the link  
        if (next != null) 
        { 
            head.next = revListInGroupOfGivenSize(next, k);  
            head.next.prev = head; 
        } 
  
        // pointer to the new head of the  
        // reversed group 
        return newHead;  
    } 
  
	private static void print() {
		DLLNode cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DLLNode node1 = new DLLNode(1);
		DLLNode node2 = new DLLNode(2);
		DLLNode node3 = new DLLNode(3);
		DLLNode node4 = new DLLNode(4);
		DLLNode node5 = new DLLNode(5);
		DLLNode node6 = new DLLNode(6);
		DLLNode node7 = new DLLNode(7);
		DLLNode node8 = new DLLNode(8);
		DLLNode node9 = new DLLNode(9);
		DLLNode node10 = new DLLNode(10);

		node1.prev = null;
		node1.next = node2;

		node2.prev = node1;
		node2.next = node3;

		node3.prev = node2;
		node3.next = node4;

		node4.prev = node3;
		node4.next = null;

		head = node1;
		print();
		head = revListInGroupOfGivenSize(head, 2);
		print();
	}

}
