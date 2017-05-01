package alp3_mulzer_u07_sorteddict;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SkipListSortedDict<K extends Comparable<K>, V> implements ISortedDict<K, V>{
	
	List<SkipListLevel<K,V>> skiplist;
	int height;
	private static final double PROB = 0.5;
	
	public SkipListSortedDict(){
		this.skiplist = new ArrayList<SkipListLevel<K,V>>();
		skiplist.add(new SkipListLevel<K,V>());
		this.height = 0;
	}

	@Override
	public void put(K key, V value) {
		System.out.println("putting ("+key.toString()+", "+value.toString()+")");
		Stack<SkipListNode<K,V>> pos= search(key);
		K posKey = pos.peek().getKey();
		if (posKey!=null && posKey.equals(key)){//change only value on level 0
			System.out.println("setting value of " + posKey.toString() + " to " + value.toString());
			pos.pop().setVal(value);
		}
		else{//add always to level 0
			int index = 0;
			SkipListNode<K,V> lastAddedNode = new SkipListNode<K,V>(key, value);
			lastAddedNode.setDown(null);
			skiplist.get(index).addAt(pos.pop(), lastAddedNode);
			while(Math.random()<PROB){//add to further level
				index++;
				if(!pos.isEmpty()){//insert new node after pos.pop()
					if(index>this.height){System.out.println("ERROR");}
					SkipListNode<K,V> newNode = new SkipListNode<K,V>(key, value);
					skiplist.get(index).addAt(pos.pop(), newNode);
					newNode.setDown(lastAddedNode);
					lastAddedNode = newNode;
				}
				else{//create new level
					System.out.println("creating new level");
					SkipListLevel<K,V> newLevel = new SkipListLevel<K,V>();
					SkipListNode<K,V> newNode = new SkipListNode<K,V>(key, value);
					newLevel.addAt(newLevel.first, newNode);
					//create vertical links
					newNode.setDown(lastAddedNode);
					lastAddedNode = newNode;
					newLevel.first.setDown(this.skiplist.get(this.height).first);
					newLevel.last.setDown(this.skiplist.get(this.height).last);
					this.skiplist.add(newLevel);
					this.height++;
				}
			}
		}
		int printHeight = this.height+1;
		System.out.println("Skiplist of height "+ printHeight +": ");
		print();
	}

	@Override
	public V get(K key) {
		System.out.println("getting value of "+key.toString());
		Stack<SkipListNode<K,V>> pos= search(key);
		K posKey = pos.peek().getKey();
		if (posKey!=null && posKey.equals(key)){
			return pos.pop().getVal();
		}
		else{
			return null;
		}
	}

	@Override
	public void remove(K key) {
		System.out.println("removing key "+key.toString());
		Stack<SkipListNode<K,V>> pos= search(key);
		int index = 0;
		SkipListNode<K,V> currNode = pos.pop();
		if (currNode.getKey()==null || !currNode.getKey().equals(key)){
			System.out.println("No such key!");
			return;
		}
		//delete matching nodes on search path  
		while(currNode!=null && currNode.getKey()!=null && currNode.getKey().equals(key)){
			this.skiplist.get(index).removeNode(currNode); 
			index++;
			if(pos.isEmpty() ){
				currNode = null;
			}
			else{
				currNode = pos.pop();
			}
		}
		//delete empty levels except for level 0
		for(int i=this.height; i>0; i--){
			if (this.skiplist.get(i).size==0){
				this.skiplist.remove(i);
				this.height--;
			}
		}
		print();
	}

	@Override
	public K min() {
		System.out.println("getting smallest key:");
		return this.skiplist.get(0).first.getRight().getKey();
	}

	@Override
	public K max() {
		System.out.println("getting biggest key:");
		return this.skiplist.get(0).last.getLeft().getKey();
	}

	@Override
	public K pred(K key) {
		System.out.println("getting predecessor of " + key.toString());
		Stack<SkipListNode<K,V>> pos= search(key);
		K posKey = pos.peek().getKey();
		if (posKey!=null && posKey.equals(key)){
			return pos.pop().getLeft().getKey();
		}
		else{
			return null;
		}
	}

	@Override
	public K succ(K key) {
		System.out.println("getting successor of "+key.toString());
		Stack<SkipListNode<K,V>> pos= search(key);
		K posKey = pos.peek().getKey();
		if (posKey!=null && posKey.equals(key)){
			return pos.pop().getRight().getKey();
		}
		else{
			return null;
		}
	}
//====================================================================================================================
	private Stack<SkipListNode<K,V>> search(K key){
		Stack<SkipListNode<K,V>> path = new Stack<SkipListNode<K,V>>();
		int index = this.height;
		SkipListNode<K,V>currNode = this.skiplist.get(index).first;
		
		while(currNode != null){
			while((index>=0) && (currNode.getRight().getKey()!=null)&&currNode.getRight().getKey().compareTo(key) <= 0){
				currNode = currNode.getRight();
			}
			path.push(currNode);
			currNode = currNode.getDown();
			index--;
		}
		return path;
	}
	
	public void print(){
		for(int i=this.height; i>=0; i--){
			System.out.println(this.skiplist.get(i).toString());
			
		}
		System.out.println("===========================================");
	}
	


	

	
	


}
