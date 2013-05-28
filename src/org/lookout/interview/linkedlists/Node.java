package org.lookout.interview.linkedlists;

public class Node {
    private int value;
    private Node next;
    private Node other;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getOther() {
		return other;
	}
	public void setOther(Node other) {
		this.other = other;
	}
    
}
