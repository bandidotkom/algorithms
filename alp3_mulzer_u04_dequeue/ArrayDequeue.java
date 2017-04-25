package alp3_mulzer_u04_dequeue;

import java.util.Stack;

public class ArrayDequeue<E> implements IDequeue<E>{
	int size;
	E[] deq;
	private static int cap = 100;
	
	public ArrayDequeue(){
		this(getCap());
	}
	public ArrayDequeue(int c){
		ArrayDequeue.setCap(c);
		this.deq = (E[]) new Object[c];
	}
	
	@Override
	public E getFirst() throws EmptyQueueException {
		if (isEmpty()){
			throw new EmptyQueueException("Queue is empty!");
		}
		return this.deq[0];
	}

	@Override
	public E getLast() throws EmptyQueueException {
		if (isEmpty()){
			throw new EmptyQueueException("Queue is empty!");
		}
		return this.deq[this.size-1];
	}

	@Override
	public void addFirst(E elem) throws FullQueueException {
		if (this.size==ArrayDequeue.getCap()){
			throw new FullQueueException("Queue is full!");
		}
		else{
			reverse();
			addLast(elem);
			this.size++;
			reverse();
		}
		
	}

	@Override
	public void addLast(E elem) throws FullQueueException {
		if (this.size==ArrayDequeue.getCap()){
			throw new FullQueueException("Queue is full!");
		}
		else{
			this.deq[size] = elem;
			this.size++;
		}
	}

	@Override
	public void removeFirst() throws EmptyQueueException {
		if (isEmpty()){
			throw new EmptyQueueException("Queue is empty!");
		}
		reverse();
		removeLast();
		this.size--;
		reverse();
		
	}

	@Override
	public void removeLast() throws EmptyQueueException {
		if (isEmpty()){
			throw new EmptyQueueException("Queue is empty!");
		}
		this.deq[this.size-1] = null;
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
	
	private void reverse(){
		Stack<E> helpStack = new Stack<E>();
		for (E e : this.deq){
			helpStack.push(e);
		}
		for (int i=0; i<this.size; i++){
			this.deq[i] = helpStack.pop();
		}
	}
	public static int getCap() {
		return cap;
	}
	public static void setCap(int cap) {
		ArrayDequeue.cap = cap;
	}
}
