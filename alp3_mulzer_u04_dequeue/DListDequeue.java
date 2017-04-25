package alp3_mulzer_u04_dequeue;

public class DListDequeue<E> implements IDequeue<E>{
	DLNode<E> head, tail;
	int size;
	
	public DListDequeue(){
		this.head = new DLNode<E>(null, null, null);
		this.tail = new DLNode<E>(null, null, null);
		head.setRight(tail);
		tail.setLeft(head);
		this.size = 0;
	}
	
	@Override
	public E getFirst() throws EmptyQueueException {
		return this.head.getRight().getElem();
	}

	@Override
	public E getLast() throws EmptyQueueException {
		return this.tail.getLeft().getElem();
	}

	@Override
	public void addFirst(E elem) throws FullQueueException {
		DLNode<E> newNode = new DLNode<E>(elem, null, null);
		newNode.setRight(this.head.getRight());
		newNode.setLeft(this.head);
		this.head.getRight().setLeft(newNode);
		this.head.setRight(newNode);
		this.size++;
	}

	@Override
	public void addLast(E elem) throws FullQueueException {
		DLNode<E> newNode = new DLNode<E>(elem, null, null);
		newNode.setLeft(this.tail.getLeft());
		newNode.setRight(this.tail);
		this.tail.getLeft().setRight(newNode);
		this.tail.setLeft(newNode);
		this.size++;
		
	}

	@Override
	public void removeFirst() throws EmptyQueueException {
		this.head.setRight(this.head.getRight().getRight());
		this.head.getRight().setLeft(this.head);
		this.size--;
	}

	@Override
	public void removeLast() throws EmptyQueueException {
		this.tail.setLeft(this.tail.getLeft().getLeft());
		this.tail.getLeft().setRight(this.tail);
		this.size--;
		
	}

	@Override
	public boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public int size() {
		return this.size;
	}

}
