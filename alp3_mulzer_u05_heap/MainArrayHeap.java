package alp3_mulzer_u05_heap;

public class MainArrayHeap {

	public static void main(String[] args){
		ArrayHeap<Integer> testHeap = new ArrayHeap<Integer>();
		testHeap.insert(5);
		testHeap.insert(2);
		testHeap.insert(3);
		testHeap.insert(4);
		testHeap.insert(1);
		System.out.println("Das Minimum ist: " + testHeap.getMin());
		System.out.println("Die aktuelle Größe: " + testHeap.size());
		System.out.println("delMin(): " + testHeap.delMin());
		System.out.println("Die aktuelle Größe: " + testHeap.size());
		System.out.println("Das Minimum ist: " + testHeap.getMin());
		System.out.println("delMin(): " + testHeap.delMin());
		System.out.println("Die aktuelle Größe: " + testHeap.size());
		System.out.println("Das Minimum ist: " + testHeap.getMin());
	}
}
