package alp3_mulzer_u04_dequeue;

public class DLNode<E>{
	E elem;
	DLNode<E> right;
	DLNode<E> left;
	
	public DLNode(E elem, DLNode<E> right, DLNode<E> left){
		this.elem = elem;
		this.right = right;
		this.left = left;
	}

	public E getElem() {
		return elem;
	}

	public void setElem(E elem) {
		this.elem = elem;
	}

	public DLNode<E> getRight() {
		return right;
	}

	public void setRight(DLNode<E> right) {
		this.right = right;
	}

	public DLNode<E> getLeft() {
		return left;
	}

	public void setLeft(DLNode<E> left) {
		this.left = left;
	}
	
}
