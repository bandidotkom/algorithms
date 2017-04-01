package alp3_mulzer_u03_stack;

public class LinkList<E> {

	private class Node{
		private E elem;
		private Node next;
		
		public Node(E elem){
			this.elem = elem;
		}
		
		public String toString(){
			return elem.toString();
		}
	}
	
	private Node head = null;
	
	public void add(E element){
		Node newNode = new Node(element);
		newNode.next = head;
		head = newNode;
	}
	
	public E remove(){
		Node oldNode = head;
		head = head.next;
		return oldNode.elem;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		Node curr = head;
		while (curr != null) {
			builder.append(curr).append(" ");
			curr = curr.next;
		}
		return builder.toString();
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public E getHead(){
		return head.elem;
	}
}
