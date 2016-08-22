package com.ytx;

public class LoopDemo {
 static	class Node{
		Node next;
	}
	public static void main(String[] args) {
		Node a = new Node();
		Node b = new Node();
		a.next = b;
		b.next = a;
		System.out.println(a.next);
		System.out.println("---------------");
		System.out.println(b.next);
	}
}
