package alp3_mulzer_u07_sorteddict;

public interface ISortedDict <K extends Comparable<K>, V>{
	public void put(K key, V value);
	public V get(K key);
	public void remove(K key);
	public K min();
	public K max();
	public K pred(K key);
	public K succ(K key);
}
