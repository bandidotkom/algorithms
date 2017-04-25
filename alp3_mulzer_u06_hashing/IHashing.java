package alp3_mulzer_u06_hashing;

import java.util.NoSuchElementException;

public interface IHashing <K, V>{
	public void put(K key, V val);
	public V get(K key) throws NoSuchElementException;
	public V remove(K key) throws NoSuchElementException;
	public int size();
	public boolean isEmpty();
}
