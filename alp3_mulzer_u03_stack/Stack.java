package alp3_mulzer_u03_stack;

public interface Stack<E> {
	void push(E element) throws StackFullException;
	E pop() throws StackEmptyException;
	E top() throws StackEmptyException;
	int size();
	boolean isEmpty();
}
