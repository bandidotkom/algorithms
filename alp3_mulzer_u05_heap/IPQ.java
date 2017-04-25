package alp3_mulzer_u05_heap;

public interface IPQ <T extends Comparable<T>> {
	public T getMin();
	T delMin();
	int size();
	boolean isEmpty();
	void insert(T elem);
}
