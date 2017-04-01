package alp3_mulzer_u03_stack;

import java.util.Arrays;
import java.util.List;

public class ListStack<E> implements Stack<E> {
	LinkList<E> linkList;
	int size;
	
	public ListStack(){
		this.linkList = new LinkList<E>();
		this.size = 0;
	}
	
		
	@Override
	public void push (E element) throws StackFullException{
		linkList.add(element);
		size += 1;
	}

	@Override
	public E pop() throws StackEmptyException {
		if (isEmpty()){
			throw new StackEmptyException("Der Stack ist leer!");
		}
		else{
			size -= 1;
			return linkList.remove();
		}
	}

	@Override
	public E top() throws StackEmptyException {
		return linkList.getHead();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return linkList.isEmpty();
	}

	public String toString(){
		return linkList.toString();
	}

	public static void main (String[] args) throws StackFullException, StackEmptyException{
		
		    List<Integer> values = Arrays.asList(50, 70, 190, 20);
		    ListStack<Integer> listSt = new ListStack<>();
		    System.out.println("Am Anfang leer: " + (listSt.isEmpty()));
		    for (Integer value : values) {
		        listSt.push(value);
		    }
		    System.out.println(listSt.toString());
		    System.out.println("Stack ist leer? " + (listSt.isEmpty()));
		    for (int i = values.size(); i > 0; --i) {
		        System.out.println("entfernen " + listSt.pop());
		    }
		    System.out.println("Ist der Stack nun leer? " + (listSt.isEmpty()));
		
	}

}
