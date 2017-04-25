package alp3_mulzer_u12_trie;

public interface IVocabulary {
	boolean put(String s, int val);
	int get(String s);
	boolean remove(String s);
	int succ(String s);
}
