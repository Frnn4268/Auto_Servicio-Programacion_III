package gt.edu.umg.progra3.colas;

import java.util.NoSuchElementException;

public class ColaImpl implements Cola {
	private Node first = null;
	private Node last = null;

	@Override
	public void enqueue(String item) {
		Node newCola = new Node(item, null);
		if (isEmpty()) {
			first = newCola;
		} else {
			last.next = newCola;
		}
		last = newCola;
	}

	@Override
	public String deque() {
		if (isEmpty()) {
			throw new NoSuchElementException("Cannot dequeue from empty Queue");
		}
		String item = first.item;
		if (last == first) {
			last = null;
		}
		first = first.next;
		return item;
	}

	@Override
	public String peek() {
		if (first == null) {
			throw new NoSuchElementException("Cannot peek from empty Queue");
		}
		return first.item;
	}

	@Override
	public int size() {
		int counter = 0;
		for (Node node = first; node != null; node = node.next) {
			counter++;
		}
		return counter;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	class Node {
		private String item;
		private Node next;
		
		public Node(String item, Node next) {
			this.item = item;
			this.next = next;
		}
		
	}

}
