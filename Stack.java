package com.dsaa.stack;

import java.util.LinkedList;

public class Stack<T> {
	
	private LinkedList<T> nodes;
	private int count = 0;
	
	public Stack() {
		nodes  = new LinkedList<T>();
	}
	
	public void push(T node) {
		nodes.addFirst(node);
		count++;
	}

	public T peek() {
		if(!nodes.isEmpty()) {
		    return nodes.getFirst();
		}
		else {
			return null;
		}
	}
	
	public T pop() {
		count--;
		return nodes.removeFirst();
	}
	
	public void clear() {
		nodes.clear();
		count = 0;
	}
	
	public int count() {
		return count;
	}

}
