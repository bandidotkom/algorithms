package alp3_mulzer_u03_stack;

public class ArrayStack<E> implements Stack<E> {
    private static int CAPACITY = 100;
	E[] arr;
	int size;
    
	public ArrayStack(){
		this(getCAPACITY());
	}
	public ArrayStack(int c){
		this.setCAPACITY(c);
		this.arr = (E[]) new Object[getCAPACITY()];
		this.size = 0;
	}
	@Override
	public void push(E element) throws StackFullException {
		if (size>=getCAPACITY()){
			throw new StackFullException("Der Stack ist schon voll!");
		}
		else{
			arr[size]=(E) element;
			this.size += 1;
		}	
	}

	@Override
	public E pop() throws StackEmptyException {
		if (isEmpty()){
			throw new StackEmptyException("Der Stack ist leer!");
		}
		else{
			E elem = arr[size()-1];
			this.size -=1;
			return elem;
		}
	}

	@Override
	public E top() throws StackEmptyException {
		if (isEmpty()){
			throw new StackEmptyException("Der Stack ist leer!");
		}
		else{ 
			return arr[size-1];
		}
	}

	@Override
	public int size(){
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size==0);
	}
	public static int getCAPACITY() {
		return CAPACITY;
	}
	public void setCAPACITY(int cAPACITY) {
		CAPACITY = cAPACITY;
	}

}
