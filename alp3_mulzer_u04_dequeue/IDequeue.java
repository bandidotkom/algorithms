package alp3_mulzer_u04_dequeue;

public interface IDequeue <E>{
	E getFirst() throws EmptyQueueException;
	E getLast() throws EmptyQueueException;
	void addFirst(E elem) throws FullQueueException;
	void addLast(E elem) throws FullQueueException;
	void removeFirst() throws EmptyQueueException;
	void removeLast() throws EmptyQueueException;
	boolean isEmpty();
	int size();
}
