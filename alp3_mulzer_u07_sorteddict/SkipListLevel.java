package alp3_mulzer_u07_sorteddict;

public class SkipListLevel<K extends Comparable<K>, V>{
	SkipListNode<K,V>first;
	SkipListNode<K,V> last;
	int size;
	
	public SkipListLevel(){
		this.first = new SkipListNode<K,V>(null, null);
		this.last = new SkipListNode<K,V>(null, null);
		this.first.setRight(this.last);
		this.last.setLeft(this.first);
	}
	
	public void addAt(SkipListNode<K,V> currNode, SkipListNode<K,V> n){ 
		System.out.println("adding after (" + currNode.getKey() + "," + currNode.getVal() +")");
		n.setLeft(currNode);
		n.setRight(currNode.getRight());				
		currNode.getRight().setLeft(n);
		currNode.setRight(n);
		this.size++;
	}
	
	public void removeNode(SkipListNode<K,V> n){
		n.getLeft().setRight(n.getRight());
		n.getRight().setLeft(n.getLeft());
		this.size--;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public String toString(){
		String s = new String();
		SkipListNode<K,V> currNode = this.first;
		for (int i=0; i<this.size; i++){
			s += "("+currNode.getRight().getKey()+", "+currNode.getRight().getVal()+") ";
			currNode = currNode.getRight();
		}
		return s;
		
	}
}
