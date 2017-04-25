package alp3_mulzer_u05_heap;

public class ArrayHeap <T extends Comparable<T>> implements IPQ<T>{
	private int cap = 100;
	private T[] elems;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayHeap(){
		this.elems = (T[]) new Comparable[cap];
		this.size = 0;
	}
	@SuppressWarnings("unchecked")
	public ArrayHeap(int indCap){
		this.elems = (T[]) new Comparable[indCap];
		this.size = 0;
		this.cap = indCap;
	}
	
	@Override
	public void insert(T elem) {
		if (this.size == this.cap){//ds is full
			System.out.println("Heap is full, can not insert new element.");
		}
		else{
			this.elems[this.size] = elem;
			this.size ++;
			bubbleUp(this.size - 1);
		}
		
	}
	
	@Override
	public T getMin() {
		return this.elems[0];
	}
	@Override
	public T delMin() {
		T min = this.elems[0];
		this.elems[0] = this.elems[this.size-1];
		this.size--;
		bubbleDown(0);
		return min;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public boolean isEmpty() {
		return this.size==0;
	}
	
	void bubbleUp(int ind){
		int parent = parent(ind);
		while (ind > 0 && this.elems[parent].compareTo(this.elems[ind]) > 0){
			swap(parent, ind);
			ind = parent;
			parent = parent(ind);
		}
	}
	
	void bubbleDown(int ind){
		int left = leftChild(ind);
		int right = rightChild(ind);
		while ((left < this.size && this.elems[left].compareTo(this.elems[ind]) < 0) || (right < this.size && this.elems[right].compareTo(this.elems[ind]) <0)){
			int nextInd = left;
			if (right < this.size && this.elems[right].compareTo(this.elems[left]) < 0){
				nextInd++;
			}
			swap(ind, nextInd);
			ind = nextInd;
			left = leftChild(nextInd);
			right = rightChild(nextInd);
		}
	}
	
	void swap(int i1, int i2){
		T tmp = this.elems[i1];
		this.elems[i1] = this.elems[i2];
		this.elems[i2] = tmp;
	}
	
	int parent(int ind){
		return (int) (Math.floor((ind+1) / 2) - 1);
	}
	int leftChild(int ind){
		return ind*2+1;
	}
	int rightChild(int ind){
		return ind*2+2;
	}
}
