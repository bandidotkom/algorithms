package alp3_mulzer_u06_hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HashingWithChaining <K, V> implements IHashing <K, V>{
	private int size;
	private int cap = 11;
	List<List<Entry>> hashTable;
	
	public HashingWithChaining(){
		this.size=0;
		this.hashTable = new ArrayList<List<Entry>>(this.cap);
	}
	
	@Override
	public void put(K key, V val) {
		int index = getIndex(key);
		int i = find(key, index);
		if (i>-1){
			hashTable.get(index).get(i).val = val;
		}
		else{
			hashTable.get(index).add(new Entry(key,val));
		}
		this.size++;
		if ((this.size / this.cap) > 10){
			resize();
		}
	}

	@Override
	public V get(K key) throws NoSuchElementException {
		int index = getIndex(key);
		int i = find(key, index);
		if (i>-1){
			return (V) this.hashTable.get(index).get(i).val;
		}
		else{
			throw new NoSuchElementException();
		}
	}

	@Override
	public V remove(K key) throws NoSuchElementException {
		int index = getIndex(key);
		int i = find(key, index);
		if (i>-1){
			V val = (V) this.hashTable.get(index).get(i).val;
			this.hashTable.get(index).remove(i);
			return val;
		}
		else{
			throw new NoSuchElementException();
		}
	}

	@Override
	public int size() { 
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size==0;
	}
	//-------------------------------------------------------------------
	private class Entry<K, V>{
		private K key;
		private V val;
		
		Entry(K k, V v){
			this.key=k;
			this.val=v;
		}
	}
	
	//-------------------------------------------------------------------
	private int getIndex(K k){
		return Math.abs(k.hashCode() % this.cap);
	}
	
	private int find(K k, int i){
		for (int j=0; j<this.hashTable.get(i).size(); j++){
			if (this.hashTable.get(i).get(j).key == k){
				return j;
			}
		}
		return -1;
	}
	
	private void resize(){
		this.cap *= 2;
		List<List<Entry>> newTable = new ArrayList<List<Entry>>(this.cap);
		for (int i=0; i<this.hashTable.size(); i++){
			for (int j=0; j<this.hashTable.get(i).size(); j++){
				Entry e = this.hashTable.get(i).get(j);
				int index = getIndex((K) e.key);
				newTable.get(index).add(e);
			}
		}
		this.hashTable = newTable;
	} 
}
