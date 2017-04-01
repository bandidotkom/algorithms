package alp3_mulzer_u03_stack;

import java.util.Arrays;

public class DynamicArrayStack<E> implements Stack<E> {
	E[] dArr;
	int size;
	private static int CAPACITY = 100;
	
	public DynamicArrayStack(){
		this(getCAPACITY());
	}
	public DynamicArrayStack(int c){
		DynamicArrayStack.setCAPACITY(c);
		this.dArr = (E[]) new Object[getCAPACITY()];
		this.size = 0;
	}
	
	@Override
	public void push(E element) throws StackFullException {
		if (size>dArr.length){
			resize(dArr);
		}
		dArr[size]=(E) element;
		size += 1;
	}

	@Override
	public E pop() throws StackEmptyException {
		if (isEmpty()){
			throw new StackEmptyException("Der Stack ist leer!");
		}
		else{
			E elem = dArr[size()-1];
			this.size -=1;
			return elem;
		}
	}

	@Override
	public E top() throws StackEmptyException {
		return dArr[size-1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	private void resize(E[] a){
		a = Arrays.copyOf(a, a.length*2);
		
	}
	public static int getCAPACITY() {
		return CAPACITY;
	}
	public static void setCAPACITY(int cAPACITY) {
		CAPACITY = cAPACITY;
	}
}
