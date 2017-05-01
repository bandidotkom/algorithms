package alp3_mulzer_u07_sorteddict;

public class SkipListNode <K extends Comparable<K>, V>{
		K key;
		V val;
		SkipListNode<K,V> left, right, down;
		
		public SkipListNode(K key, V val){
			this.key = key;
			this.val = val;
		}
		public void setLeft(SkipListNode<K,V> n){
			this.left = n;
		}
		public void setRight(SkipListNode<K,V> n){
			this.right = n;
		}
		public void setDown(SkipListNode<K,V> n){
			this.down = n;
		}
		public SkipListNode<K,V> getLeft(){
			return this.left;
		}
		public SkipListNode<K,V> getRight(){
			return this.right;
		}
		public SkipListNode<K,V> getDown(){
			return this.down;
		}
		public K getKey(){
			return this.key;
		}
		public void setVal(V val){
			this.val = val;
		}
		public V getVal(){
			return this.val;
		}
		
}

